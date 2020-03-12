package Steps;


import Helpers.DriverManager;
import PageObjects.MainPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainPageStepdef {
    MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(MainPageStepdef.class);


    public MainPageStepdef() {
        mainPage = new MainPage(DriverManager.getChromeDriver());
    }

    @When("I open otus main page")
    public void iOpenOtusMainPage() {
        mainPage.driverHelper.openUrl(mainPage.otusMainPageUrl);
        logger.info("");
    }
    @When("I сlick on Login button")
    public void iСlickOnLoginButton() {
        mainPage.clickOnLoginButton();
    }



}
