package otus.bdd.steps;

import org.springframework.test.context.ContextConfiguration;
import otus.bdd.springConfig.SpringConfig;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

@ContextConfiguration(classes = SpringConfig.class)

public class Hooks {
    public static WebDriver driver;

    @Before
    public void getDriver(){
    //    TestConfig testConfig = ConfigFactory.create(TestConfig.class);
      //  driver = DriverManager.getDriver(testConfig.browser());
        System.out.println("Before hooks executed");
    }

/*    @After(order = 0)
    public void closeDriver(){
        DriverManager.closeDriver();
    }

    @After(order = 100,value = "@cookies")
    public void saveAuthorizationCookies(){
        CookieManager cookieManager = new CookieManager(DriverManager.getDriver("chrome"));
        cookieManager.saveCookiesToFile();
    }*/
}
