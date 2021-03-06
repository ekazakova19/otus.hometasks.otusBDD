package otus.bdd.steps;

import org.springframework.beans.factory.annotation.Autowired;
import otus.bdd.pageObjects.SkillPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class SkilsPageStepdef {
    @Autowired
    SkillPage skillPage;

    private static final Logger logger = LogManager.getLogger(SkilsPageStepdef.class);

    @Given("I open skill page")
    public void iOpenSkillPage() {
        skillPage.commonActions.openUrl(skillPage.skillPageUrl);
    }

    @When("I set the following parameters")
    public void iSetTheFollowingParameters(Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println("params =  " + entry.getKey() + " value = " + entry.getValue());
            switch (entry.getKey()) {
                case "direction":
                    skillPage.commonActions.clickOn(skillPage.DIRECTION_FIELD);
                    skillPage.selectValueFromDropdownList(entry.getValue());
                    break;
                case "specialization":
                    skillPage.commonActions.clickOn(skillPage.SPECIALIZATION_FIELD);
                    skillPage.selectValueFromDropdownList(entry.getValue());
                    break;
                default:
                    throw new IllegalArgumentException("Parameter not supported");
            }
        }
    }

    @When("I click on Save and Fill Later")
    public void iClickOnSaveAndFillLater() {
        skillPage.commonActions.clickOn(skillPage.SAVE_AND_FILL_LATER_BTN);
    }

    @Then("I see the following parameters")
    public void iSeeTheFollowingParameters(Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            switch (entry.getKey()) {
                case "direction":
                    System.out.println(skillPage.getDirectionValue(skillPage.DIRECTION_FIELD));
                    Assert.assertTrue(skillPage.getDirectionValue(skillPage.DIRECTION_FIELD).equalsIgnoreCase(entry.getValue()));
                    break;
                case "specialization":
                    System.out.println(skillPage.getDirectionValue(skillPage.SPECIALIZATION_FIELD));
                    Assert.assertTrue(skillPage.getDirectionValue(skillPage.SPECIALIZATION_FIELD).equalsIgnoreCase(entry.getValue()));
                    break;
                default:
                    throw new IllegalArgumentException("Parameter not supported");
            }
        }
    }

    @Then("I see error notification")
    public void iSeeErrorNotification() {
        skillPage.checkErrorMessageAppears();
    }

}
