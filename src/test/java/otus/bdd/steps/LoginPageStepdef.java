package otus.bdd.steps;

import org.springframework.beans.factory.annotation.Autowired;
import otus.bdd.pageObjects.LoginPage;
import otus.bdd.testProperties.TestConfig;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginPageStepdef {

//    @Autowired
//    public WebDriver driver2;
    @Autowired
    LoginPage loginPage;

    private static final Logger logger = LogManager.getLogger(LoginPageStepdef.class);
    TestConfig testConfig = ConfigFactory.create(TestConfig.class);

    public LoginPageStepdef() {
       // driver = Hooks.driver;
        //loginPage = new LoginPage(driver);
    }

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






}
