package otus.bdd.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CommonActions implements InitializingBean {

    @Autowired
    WebDriver driver;

    public WebDriverWait wait;

    @Override
    public void afterPropertiesSet() {
        wait = new WebDriverWait(driver,7);
    }

    public void clickOn(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void enterTextField(WebElement element, String val){
        wait.until(ExpectedConditions.visibilityOf(element));
        if(element.getAttribute("value")!=null){
            element.clear();
        }
        element.sendKeys(val);
    }

    public String getTextOfElement(WebElement element){
        return  element.getText();
    }

    public void openUrl(String url){
        driver.get(url);
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }


}
