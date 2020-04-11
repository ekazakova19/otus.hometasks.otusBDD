package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public String otusMainPageUrl = "http://otus.ru/";
    @FindBy(css = "button.header2__auth")
    private WebElement RegisterButton;
    @FindBy(css = "p.header2-menu__item-text.header2-menu__item-text__username")
    private WebElement USER_NAME_MENU;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnLoginButton(){
        clickOn(RegisterButton);
    }


    public void checkMainPageOpenInAuthorizedMode(){
            wait.until(ExpectedConditions.visibilityOf(USER_NAME_MENU));
    }

  

}
