package otus.bdd.steps;

import cucumber.api.java.After;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import otus.bdd.helpers.CookieManager;
import otus.bdd.springConfig.SpringConfig;
import org.openqa.selenium.WebDriver;

@ContextConfiguration(classes = SpringConfig.class)
//@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD) - закрывал драйвер после каждого сценария, но не закрывал после последнего выполненного сценария
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Autowired
    CookieManager cookieManager;
    public static WebDriver driver;

    @After(value = "@cookies")
    public void saveAuthorizationCookies(){
        cookieManager.saveCookiesToFile();
    }
}
