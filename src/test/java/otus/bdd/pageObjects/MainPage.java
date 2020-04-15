package otus.bdd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import otus.bdd.helpers.CommonActions;


@Component
public class MainPage implements InitializingBean  {
    @Autowired
    public WebDriver driver;

    @Autowired
    public CommonActions commonActions;

    public String otusMainPageUrl = "http://otus.ru/";
    @FindBy(css = "button.header2__auth")
    private WebElement RegisterButton;
    @FindBy(css = "p.header2-menu__item-text.header2-menu__item-text__username")
    private WebElement USER_NAME_MENU;


    public MainPage() {
        System.out.println("Main page constructor has been called");

    }

    public void openURL(){
        commonActions.openUrl(otusMainPageUrl);
    }
    public void clickOnLoginButton(){
       commonActions.clickOn(RegisterButton);
        //RegisterButton.click();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PageFactory.initElements(driver,this);
        System.out.println("Main page - Bean init method executed");
    }


    public void checkMainPageOpenInAuthorizedMode(){
        commonActions.wait.until(ExpectedConditions.visibilityOf(USER_NAME_MENU));
    }

  

}
