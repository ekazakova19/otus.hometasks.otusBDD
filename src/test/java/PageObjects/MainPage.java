package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {


    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver,this);
    }
    public String otusMainPageUrl = "http://otus.ru/";
    @FindBy(css = "button.header2__auth")
    private WebElement RegisterButton;

    public void clickOnLoginButton(){
        clickOn(RegisterButton);
    }

  

}
