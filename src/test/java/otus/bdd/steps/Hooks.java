package otus.bdd.steps;

import cucumber.api.java.After;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import otus.bdd.helpers.CookieManager;
import otus.bdd.helpers.DriverManager;
import otus.bdd.springConfig.SpringConfig;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;



@ContextConfiguration(classes = SpringConfig.class)
//@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD) - закрывал драйвер после каждого сценария, но не закрывал после последнего
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Autowired
    CookieManager cookieManager;
    public static WebDriver driver;


//    //@Before
//    public void getDriver(){
//    //    TestConfig testConfig = ConfigFactory.create(TestConfig.class);
//      //  driver = DriverManager.getDriver(testConfig.browser());
//       // System.out.println("Before hooks executed");
//        logger.info("Before hooks executed");
//    }


   //@After(order = 0)
//
//    public void closeDriver(){
//     //   DriverManager.closeDriver();
//      //  System.out.println("After hooks executed");
//        logger.info("After hooks executed");
//    }

    @After(order = 100,value = "@cookies")
    public void saveAuthorizationCookies(){
       // CookieManager cookieManager = new CookieManager();
        cookieManager.saveCookiesToFile();
    }
}
