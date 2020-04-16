package otus.bdd.springConfig;

import org.aeonbits.owner.ConfigFactory;
import otus.bdd.helpers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
