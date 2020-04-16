package otus.bdd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import otus.bdd.helpers.CommonActions;

@Component
public class PollsPage implements InitializingBean {
    @Autowired
    public WebDriver driver;
    @Autowired
    public CommonActions commonActions;

    @FindBy(css="div.error__description")
    WebElement ERROR_MESSAGE;
    @FindBy(css="div.js-polls")
    public WebElement POLL_HEADER;

    public String getErrorText(){
        return ERROR_MESSAGE.getText();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PageFactory.initElements(driver,this);
    }
}
