package otus.bdd.pageObjects;

import org.junit.After;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import otus.bdd.helpers.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage implements InitializingBean {

    @Autowired
    public WebDriver driver;

    WebDriverWait wait;


   public DriverHelper driverHelper;

    public BasePage() {
        System.out.println(" Base page constructor has been called");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        wait = new WebDriverWait(driver,7);
        driverHelper = new DriverHelper(driver);
        System.out.println("Base page - Bean init method executed");
        System.out.println(driverHelper);
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



}
