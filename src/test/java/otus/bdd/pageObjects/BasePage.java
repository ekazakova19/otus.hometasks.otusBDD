package otus.bdd.pageObjects;

import otus.bdd.helpers.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;

    WebDriverWait wait;
    public DriverHelper driverHelper;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        wait = new WebDriverWait(driver,7);
        driverHelper = new DriverHelper(driver);
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