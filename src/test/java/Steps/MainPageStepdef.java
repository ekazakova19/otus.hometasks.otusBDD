package Steps;


import Helpers.CookieManager;
import Helpers.DriverManager;
import PageObjects.MainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class MainPageStepdef extends BaseStepdef{
  //  private WebDriver driver;
    MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(MainPageStepdef.class);


    public MainPageStepdef() {
        //driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
    }

    @When("I open otus main page")
    public void iOpenOtusMainPage() {
        mainPage.driverHelper.openUrl(mainPage.otusMainPageUrl);
        logger.info("When I open otus main page - completed");
    }
    @When("I сlick on Login button")
    public void iСlickOnLoginButton() {
        mainPage.clickOnLoginButton();
        logger.info("When I click on Login button - completed");
    }

    @Then("I see main page opened for logged user")
    public void iSeeMainPageOpenedForLoggedUser(){
        try {
            mainPage.checkMainPageOpenInAuthorizedMode();
        } catch (TimeoutException e) {
            logger.error("Login is not successful. See error {}", e);
            throw e;
        }
    }

    @Given("My user is logged on")
    public void myUserIsLoggedOn(){
        mainPage.driverHelper.openUrl(mainPage.otusMainPageUrl);
        CookieManager cookieManager = new CookieManager(driver);
        Set<Cookie> cookies = cookieManager.readCookiesFromFile();
        cookieManager.addCookiesToDriver(cookies);
        driverHelper.refreshPage();

    }


}
