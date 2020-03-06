package Steps;

import PageObjects.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginPageStepdef {
    LoginPage loginPage;

    public LoginPageStepdef(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Then("I see login page is opened")
    public void iSeeLoginPage(){
        loginPage.isLoginPageOpened();
    }

    @When("I fill email field")
    public void iFillEmailField(){
        loginPage.fillEmail("");
    }
    @When("I fill password field")
    public void iFillPassField(){
        loginPage.fillPassword("");
    }
}
