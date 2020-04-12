package otus.bdd.springConfig;

import otus.bdd.helpers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan("otus.bdd")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class SpringConfig {

    public SpringConfig() {
        System.out.println("Spring configuration loaded");
    }

    @Bean
    public WebDriver getDriver(){
        WebDriver driver = DriverManager.getDriver("chrome");
        System.out.println("Bean intialized. Now container has WebDriver object");
        return driver;
    }
}
