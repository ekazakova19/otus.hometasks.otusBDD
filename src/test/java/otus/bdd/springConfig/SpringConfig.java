package otus.bdd.springConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Scope;
import otus.bdd.helpers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import otus.bdd.pageObjects.BasePage;
import otus.bdd.testProperties.TestConfig;

@Configuration
@ComponentScan("otus.bdd")
//@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)

public class SpringConfig {

    public SpringConfig() {
        System.out.println("Spring configuration loaded");
    }

    @Bean(destroyMethod = "quit")
    public WebDriver getDriver(){
        TestConfig testConfig = ConfigFactory.create(TestConfig.class);
        WebDriver driver = DriverManager.getDriver(testConfig.browser());
        System.out.println("Bean intialized. Now container has WebDriver object");
        return driver;
    }


}
