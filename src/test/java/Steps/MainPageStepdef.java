package Steps;


import Helpers.DriverManager;
import PageObjects.MainPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;

public class MainPageStepdef {
    MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(MainPageStepdef.class);


    public MainPageStepdef() {
        mainPage = new MainPage(DriverManager.getChromeDriver());
    }

    @When("I open otus main page")
    public void iOpenOtusMainPage() {
        mainPage.driverHelper.openUrl(mainPage.otusMainPageUrl);
        logger.info("When I open otus main page - completed");
    }
    @When("I сlick on Login button")
    public void iСlickOnLoginButton() {
        mainPage.clickOnLoginButton();
        logger.info("When I click on Login button - completed");
    }

    @Then("I see main page opened for logged user")
    public void iSeeMainPageOpenedForLoggedUser(){
        try {
            mainPage.checkMainPageOpenInAuthorizedMode();
        } catch (TimeoutException e) {
            logger.error("Login is not successful. See error {}", e);
            throw e;
        }
    }



}
