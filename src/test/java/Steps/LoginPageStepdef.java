package Steps;

import Helpers.DriverHelper;
import Helpers.DriverManager;
import PageObjects.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginPageStepdef {
    LoginPage loginPage;

    public LoginPageStepdef() {
        loginPage = new LoginPage(DriverManager.getChromeDriver());
    }

    @Then("I see login page is opened")
    public void iSeeLoginPage(){
        loginPage.isLoginPageOpened();
    }

    @When("I fill email field")
    public void iFillEmailField(){
        loginPage.fillEmail("al.kz93@mail.ru");
    }
    @When("I fill password field")
    public void iFillPassField(){
        loginPage.fillPassword("090393elka!");
    }
}
