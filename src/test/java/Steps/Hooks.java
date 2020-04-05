package Steps;

import Helpers.CookieManager;
import Helpers.DriverHelper;
import Helpers.DriverManager;
import TestProperties.TestConfig;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void getDriver(){
        TestConfig testConfig = ConfigFactory.create(TestConfig.class);
        driver = DriverManager.getDriver(testConfig.browser());
    }

    @After(order = 0)
    public void closeDriver(){
        DriverManager.closeDriver();
    }

    @After(order = 100,value = "@cookies")
    public void saveAuthorizationCookies(){
        CookieManager cookieManager = new CookieManager(DriverManager.getDriver("chrome"));
        cookieManager.saveCookiesToFile();
    }
}
