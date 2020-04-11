package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PollsPage extends BasePage {

    @FindBy(css="div.error__description")
    WebElement ERROR_MESSAGE;
    @FindBy(css="div.js-polls")
    public WebElement POLL_HEADER;

    public PollsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver,this);
    }

    public String getErrorText(){
        return ERROR_MESSAGE.getText();
    }


}
