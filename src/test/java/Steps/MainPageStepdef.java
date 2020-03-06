package Steps;


import PageObjects.MainPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainPageStepdef {
    MainPage mainPage;


    public MainPageStepdef() {

        mainPage = new MainPage();
    }

    @When("I open otus main page")
    public void iOpenOtusMainPage() {
        // Write code here that turns the phrase above into concrete actions
        mainPage.driverHelper.openUrl(mainPage.otusMainPageUrl);
    }
    @When("I сlick on Login button")
    public void iСlickOnLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        mainPage.clickOnLoginButton();
    }



}
