package otus.bdd.steps;

import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import otus.bdd.pageObjects.MainPage;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainPageStepdef {

    @Autowired
    MainPage mainPage;

    private static final Logger logger = LogManager.getLogger(MainPageStepdef.class);

    @When("I open otus main page")
    public void iOpenOtusMainPage() {
        mainPage.commonActions.openUrl(mainPage.otusMainPageUrl);
    }

    @When("I сlick on Login button")
    public void iСlickOnLoginButton() {
        mainPage.clickOnLoginButton();
    }

    @Then("I see main page opened for logged user")
    public void iSeeMainPageOpenedForLoggedUser() {
        mainPage.checkMainPageOpenInAuthorizedMode();
    }

}
