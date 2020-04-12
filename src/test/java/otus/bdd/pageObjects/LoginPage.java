package otus.bdd.pageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginPage implements InitializingBean {

    @Autowired
    public WebDriver driver;

    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    public static String url = "https://otus.ru/login/";

    @FindBy(css="form.new-log-reg__form.js-login")
    public WebElement LOGIN_FORM ;
    @FindBy(css="input[type=text]")
    public WebElement EMAIL;
    @FindBy(css="input[type=password]")
    public WebElement PASSWORD;
    @FindBy(css="form.new-log-reg__form button")
    public WebElement LOGIN_BUTTON;

    public LoginPage() {
        System.out.println("Login Page constructor has been called");
    }



//    public LoginPage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver,this);
//    }

//    public void fillEmail(String email){
//        enterTextField(EMAIL,email);
//    }
//    public void fillPassword(String pass){
//        enterTextField(PASSWORD,pass);
//    }
    public void clickOnLoginButton(){
        LOGIN_BUTTON.click();
    }

    public void isLoginPageOpened(){
        WebDriverWait wait =new WebDriverWait(driver,7);
      wait.until(ExpectedConditions.visibilityOf(LOGIN_FORM));
  }


    @Override
    public void afterPropertiesSet() throws Exception {
        PageFactory.initElements(driver,this);
        System.out.println("Login page - Bean init method executed");
    }
}