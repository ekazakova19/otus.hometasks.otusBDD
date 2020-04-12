package otus.bdd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StandalonePostPage extends BasePage {
    @FindBy(css="div.blog__content")
    private WebElement POST;

    public StandalonePostPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getPost(){
        return POST;
    }
}
