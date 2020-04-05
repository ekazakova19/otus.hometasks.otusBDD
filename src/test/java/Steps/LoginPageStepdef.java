package Steps;

import PageObjects.LoginPage;
import TestProperties.TestConfig;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginPageStepdef {

    public WebDriver driver;
    LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginPageStepdef.class);
    TestConfig testConfig = ConfigFactory.create(TestConfig.class);

    public LoginPageStepdef() {
        driver = Hooks.driver;
        loginPage = new LoginPage(driver);
    }

    @Then("I see login page is opened")
    public void iSeeLoginPage(){
        loginPage.isLoginPageOpened();
        logger.info("I see login page is opened - completed");
    }

    @When("I fill email field")
    public void iFillEmailField(){
        loginPage.fillEmail(testConfig.user());
        logger.info("I fill email field - completed");
    }
    @When("I fill password field")
    public void iFillPassField(){
        loginPage.fillPassword(testConfig.password());
        logger.info("I fill password field - completed");
    }

    @When("I сlick on submit button")
    public void iСlickOnLoginButton() {
        loginPage.clickOnLoginButton();
        logger.info("I сlick on submit button - completed");
    }






}
