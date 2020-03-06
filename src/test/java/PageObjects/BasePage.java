package PageObjects;

import Helpers.DriverHelper;
import Helpers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public DriverHelper driverHelper;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        wait = new WebDriverWait(driver,7);
        driverHelper = new DriverHelper(driver);
    }

    @Before
    public void initDriver(){
       this.driver =  DriverManager.getChromeDriver();
    }

    public void clickOn(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void enterTextField(WebElement element, String val){
        if(!element.getAttribute("value").isEmpty()){
            element.clear();
        }
        element.sendKeys(val);
    }
}
