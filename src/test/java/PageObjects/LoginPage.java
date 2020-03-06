package PageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    public static String url = "https://otus.ru/login/";

    @FindBy(css="\"form.new-log-reg__form.js-login\"")
    public WebElement LOGIN_FORM ;
    @FindBy(css="input[type=text]")
    public WebElement EMAIL;
    @FindBy(css="input[type=password]")
    public WebElement PASSWORD;
    @FindBy(linkText = "Войти")
    public WebElement LOGIN_BUTTON;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void fillEmail(String email){
        enterTextField(EMAIL,email);
    }
    public void fillPassword(String pass){
        enterTextField(PASSWORD,pass);
    }
    public void clickOnLoginButton(){
        clickOn(LOGIN_BUTTON);
    }

    public void isLoginPageOpened(){
        wait.until(ExpectedConditions.visibilityOf(LOGIN_FORM));
    }

//    public void loginAs(String email, String password){
//        driver.get(url);
//        logger.info("Page {} opened.Starting enter credentials ...", url);
//        WebElement loginForm = driver.findElement(LOGIN_FORM);
//        loginForm.findElement(EMAIL).sendKeys(email);
//        loginForm.findElement(PASSWORD).sendKeys(password);
//        logger.info("Credentials entered, submitting the form...");
//        loginForm.submit();
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.USER_NAME_MENU));
//            logger.info("Login is successful.Home page is opened for the user");
//
//        } catch (TimeoutException e) {
//            logger.error("Login is not successful. See error {}", e);
//            throw e;
//        }
//    }
}
