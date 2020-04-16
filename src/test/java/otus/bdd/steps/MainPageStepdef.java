package otus.bdd.steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import otus.bdd.helpers.CookieManager;
import otus.bdd.pageObjects.MainPage;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class MainPageStepdef {

    @Autowired
    MainPage mainPage;
    @Autowired
    CookieManager cookieManager;

    private static final Logger logger = LogManager.getLogger(MainPageStepdef.class);

    @When("I open otus main page")
    public void iOpenOtusMainPage() {
        mainPage.driver.get(mainPage.otusMainPageUrl);
    }

    @When("I сlick on Login button")
    public void iСlickOnLoginButton() {
        mainPage.clickOnLoginButton();
    }

    @Then("I see main page opened for logged user")
    public void iSeeMainPageOpenedForLoggedUser() {
        mainPage.checkMainPageOpenInAuthorizedMode();
    }

    @Given("My user is logged on")
    @When("I log in")
    public void myUserIsLoggedOn() {
        mainPage.commonActions.openUrl(mainPage.otusMainPageUrl);
        Set<Cookie> cookies = cookieManager.readCookiesFromFile();
        cookieManager.addCookiesToDriver(cookies);
        mainPage.commonActions.refreshPage();
    }
}
