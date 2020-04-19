package otus.bdd.steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchCookieException;
import org.springframework.beans.factory.annotation.Autowired;
import otus.bdd.helpers.CookieManager;
import otus.bdd.pageObjects.LoginPage;
import otus.bdd.testProperties.TestConfig;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;


public class LoginPageStepdef {
    @Autowired
    LoginPage loginPage;
    @Autowired
    CookieManager cookieManager;
    @Autowired
    MainPageStepdef mainPageStepdef;

    private static final Logger logger = LogManager.getLogger(LoginPageStepdef.class);
    TestConfig testConfig = ConfigFactory.create(TestConfig.class);

    @Then("I see login page is opened")
    public void iSeeLoginPage(){
        loginPage.isLoginPageOpened();
    }

    @When("I open login page")
    public void iOpenLoginPage(){
        loginPage.commonActions.openUrl(loginPage.url);
    }

    @When("I fill email field")
    public void iFillEmailField(){
        loginPage.fillEmail(testConfig.user());
    }
    @When("I fill password field")
    public void iFillPassField(){
        loginPage.fillPassword(testConfig.password());
    }

    @When("I сlick on submit button")
    public void iСlickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Given("My user is logged on")
    @When("I log in")
    public void myUserIsLoggedOn() {
        loginPage.commonActions.openUrl("http://otus.ru/");
        Set<Cookie> cookies = null;
        try {
            cookies = cookieManager.readCookiesFromFile();
        } catch (NoSuchCookieException e) {
            forceLogin();
            cookieManager.saveCookiesToFile();
        }
        if(cookies==null){
            cookies = cookieManager.readCookiesFromFile();
        }
        cookieManager.addCookiesToDriver(cookies);
        loginPage.commonActions.openUrl("http://otus.ru/");

    }
    public void forceLogin(){
        loginPage.commonActions.openUrl(loginPage.url);
        iFillEmailField();
        iFillPassField();
        iСlickOnLoginButton();
        mainPageStepdef.iSeeMainPageOpenedForLoggedUser();

    }


}
