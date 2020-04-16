package otus.bdd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StandalonePostPage  implements InitializingBean {
    @Autowired
    WebDriver driver;

    @FindBy(css="div.blog__content")
    private WebElement POST;


    public WebElement getPost(){
        return POST;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PageFactory.initElements(driver,this);
    }
}
