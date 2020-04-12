package otus.bdd.steps;


import org.springframework.beans.factory.annotation.Autowired;
import otus.bdd.pageObjects.MainPage;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainPageStepdef {

    @Autowired
    MainPage mainPage;

    private static final Logger logger = LogManager.getLogger(MainPageStepdef.class);


    public MainPageStepdef() {
       // driver = Hooks.driver;
       // mainPage = new MainPage(driver);
    }

    @When("I open otus main page")
    public void iOpenOtusMainPage() {
      //  mainPage.driverHelper.openUrl(mainPage.otusMainPageUrl);
        mainPage.driver.get(mainPage.otusMainPageUrl);
    }
    @When("I сlick on Login button")
    public void iСlickOnLoginButton() {
        mainPage.clickOnLoginButton();
    }

//    @Then("I see main page opened for logged user")
//    public void iSeeMainPageOpenedForLoggedUser(){
//            mainPage.checkMainPageOpenInAuthorizedMode();
//    }

//    @Given("My user is logged on")
//    @When("I log in")
//    public void myUserIsLoggedOn(){
//        mainPage.driverHelper.openUrl(mainPage.otusMainPageUrl);
//        CookieManager cookieManager = new CookieManager(driver);
//        Set<Cookie> cookies = cookieManager.readCookiesFromFile();
//        cookieManager.addCookiesToDriver(cookies);
//        mainPage.driverHelper.refreshPage();
//
//    }


}
