package otus.bdd.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class LoginPage implements InitializingBean {

    @Autowired
    public WebDriver driver;

    @Autowired
    public CommonActions commonActions;

    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    public static String url = "https://otus.ru/login/";

    @FindBy(css = "form.new-log-reg__form.js-login")
    public WebElement LOGIN_FORM;
    @FindBy(css = "input[type=text]")
    public WebElement EMAIL;
    @FindBy(css = "input[type=password]")
    public WebElement PASSWORD;
    @FindBy(css = "form.new-log-reg__form button")
    public WebElement LOGIN_BUTTON;


    public void fillEmail(String email) {
        commonActions.enterTextField(EMAIL, email);
    }

    public void fillPassword(String pass) {
        commonActions.enterTextField(PASSWORD, pass);
    }


    public void clickOnLoginButton() {
        commonActions.clickOn(LOGIN_BUTTON);
    }

    public void isLoginPageOpened() {
        commonActions.wait.until(ExpectedConditions.visibilityOf(LOGIN_FORM));
    }


    @Override
    public void afterPropertiesSet() {
        PageFactory.initElements(driver, this);
    }

}
