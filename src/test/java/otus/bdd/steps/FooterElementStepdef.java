package otus.bdd.steps;

import org.springframework.beans.factory.annotation.Autowired;
import otus.bdd.pageObjects.MainFooterElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class FooterElementStepdef   {

    @Autowired
    MainFooterElement mainFooterElement;


    @When("I input {string} in subscribe email field")
    public void iInputSubscribeField(String value){
        mainFooterElement.commonActions.enterTextField(mainFooterElement.SUBSCRIBE_FIELD,value);
    }

    @Then("I see subscribe button becomes unavailable")
    public void iSeeSubscribeButtonBecomesUnavailable() {
        Assert.assertFalse(mainFooterElement.SUBSCRIBE_BUTTON.isEnabled());
    }
    @Then("I see subscribe button becomes available")
    public void iSeeSubscribeButtonBecomesAvailable() {
        Assert.assertTrue(mainFooterElement.SUBSCRIBE_BUTTON.isEnabled());
    }

    @When("I click on subscribe button")
    public void iClickOnSubscribeButton() {
        mainFooterElement.commonActions.clickOn(mainFooterElement.SUBSCRIBE_BUTTON);
    }

    @Then("I see {string}")
    public void iSeeTextAppears(String value) {
      Assert.assertEquals(value,mainFooterElement.commonActions.getTextOfElement(mainFooterElement.SUBSCRIBE_CONFIRM_TEXT));
    }
}
