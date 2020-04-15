package otus.bdd.steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.runner.RunWith;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import otus.bdd.helpers.CookieManager;
import otus.bdd.helpers.DriverHelper;
import otus.bdd.pageObjects.MainPage;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import otus.bdd.springConfig.SpringConfig;

import java.util.Set;


//@ContextConfiguration(classes = SpringConfig.class)
//@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class MainPageStepdef {

    @Autowired
    MainPage mainPage;
    @Autowired
    CookieManager cookieManager;

    private static final Logger logger = LogManager.getLogger(MainPageStepdef.class);


//    public MainPageStepdef() {
//       // driver = Hooks.driver;
//       // mainPage = new MainPage(driver);
//    }

    @When("I open otus main page")
    public void iOpenOtusMainPage() {
      //  DriverHelper driverHelper1 = mainPage.driverHelper;
      // mainPage.driverHelper.openUrl(mainPage.otusMainPageUrl);
        mainPage.driver.get(mainPage.otusMainPageUrl);
    }
    @When("I сlick on Login button")
    public void iСlickOnLoginButton() {
        mainPage.clickOnLoginButton();
    }

    @Then("I see main page opened for logged user")
    public void iSeeMainPageOpenedForLoggedUser(){
            mainPage.checkMainPageOpenInAuthorizedMode();
    }

    @Given("My user is logged on")
    @When("I log in")
    public void myUserIsLoggedOn(){
        mainPage.commonActions.openUrl(mainPage.otusMainPageUrl);
        Set<Cookie> cookies = cookieManager.readCookiesFromFile();
        cookieManager.addCookiesToDriver(cookies);
        mainPage.commonActions.refreshPage();

    }


}
