package Steps;

import PageObjects.PollsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class PollsPageStepdef extends BaseStepdef{
    PollsPage pollsPage;
    private static final Logger logger = LogManager.getLogger(PollsPageStepdef.class);

    public PollsPageStepdef() {
        pollsPage = new PollsPage(driver);
    }

    @When("I open the poll link {string}")
    public void iOpenPollLink(String link){
        pollsPage.driverHelper.openUrl(link);
    }

    @Then("I see {string} text")
    public void iSeeText(String text) {
        Assert.assertTrue(pollsPage.getErrorText().equalsIgnoreCase(text));
    }


    @Then("I see poll page")
    public void iSeePollPage() {
        Assert.assertTrue(pollsPage.POLL_HEADER.isDisplayed());
    }
}
