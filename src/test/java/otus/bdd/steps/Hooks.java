package otus.bdd.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import otus.bdd.helpers.CookieManager;
import otus.bdd.springConfig.SpringConfig;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

@ContextConfiguration(classes = SpringConfig.class)
//@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD) - закрывал драйвер после каждого сценария, но не закрывал после последнего выполненного сценария
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    @Autowired
    CookieManager cookieManager;
    @Autowired
    public  WebDriver driver;



    @After(value = "@cookies")
    public void saveAuthorizationCookies(Scenario scenario){
        if (!scenario.isFailed()) {
            cookieManager.saveCookiesToFile();
        }
    }

    @After
    public void saveScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public void takeScreenshot(Scenario scenario) {
      Allure.addAttachment(scenario.getName(),
                new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }


}

