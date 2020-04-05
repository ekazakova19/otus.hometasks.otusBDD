package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainFooterElement  extends BasePage{

    public MainFooterElement(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="form.footer2__subscribe>input[type=email]")
    public WebElement SUBSCRIBE_FIELD;
    @FindBy(css = "form.footer2__subscribe>button")
    public WebElement SUBSCRIBE_BUTTON;
    @FindBy(css="p.subscribe-modal__success")
    public WebElement SUBSCRIBE_CONFIRM_TEXT;




}
