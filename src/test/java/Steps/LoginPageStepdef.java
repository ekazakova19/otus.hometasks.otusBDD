package Steps;

import Helpers.CookieManager;
import Helpers.DriverHelper;
import Helpers.DriverManager;
import PageObjects.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class LoginPageStepdef extends BaseStepdef{
   // private WebDriver driver;
    LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginPageStepdef.class);

    public LoginPageStepdef() {
       // driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Then("I see login page is opened")
    public void iSeeLoginPage(){
        loginPage.isLoginPageOpened();
        logger.info("I see login page is opened - completed");
    }

    @When("I fill email field")
    public void iFillEmailField(){
        loginPage.fillEmail("al.kz93@mail.ru");
        logger.info("I fill email field - completed");
    }
    @When("I fill password field")
    public void iFillPassField(){
        loginPage.fillPassword("090393elka!");
        logger.info("I fill password field - completed");
    }

    @When("I сlick on submit button")
    public void iСlickOnLoginButton() {
        loginPage.clickOnLoginButton();
        logger.info("I сlick on submit button - completed");
    }






}
