package otus.bdd.pageObjects;

import cucumber.api.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import otus.bdd.helpers.CommonActions;

@Component
public class MainFooterElement implements InitializingBean {
    @Autowired
    public WebDriver driver;
    @Autowired
    public CommonActions commonActions;

    @FindBy(css="form.footer2__subscribe>input[type=email]")
    public WebElement SUBSCRIBE_FIELD;
    @FindBy(css = "form.footer2__subscribe>button")
    public WebElement SUBSCRIBE_BUTTON;
    @FindBy(css="p.subscribe-modal__success")
    public WebElement SUBSCRIBE_CONFIRM_TEXT;


    @Override
    public void afterPropertiesSet() throws Exception {
        PageFactory.initElements(driver,this);
    }
}
