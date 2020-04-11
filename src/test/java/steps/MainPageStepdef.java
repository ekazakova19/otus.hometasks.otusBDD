package steps;


import helpers.CookieManager;
import pageObjects.MainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class MainPageStepdef {
    public WebDriver driver;
    MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(MainPageStepdef.class);


    public MainPageStepdef() {
        driver = Hooks.driver;
        mainPage = new MainPage(driver);
    }

    @When("I open otus main page")
    public void iOpenOtusMainPage() {
        mainPage.driverHelper.openUrl(mainPage.otusMainPageUrl);
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
        mainPage.driverHelper.openUrl(mainPage.otusMainPageUrl);
        CookieManager cookieManager = new CookieManager(driver);
        Set<Cookie> cookies = cookieManager.readCookiesFromFile();
        cookieManager.addCookiesToDriver(cookies);
        mainPage.driverHelper.refreshPage();

    }


}
