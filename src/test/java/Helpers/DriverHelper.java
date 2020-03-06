package Helpers;

import org.openqa.selenium.WebDriver;

public class DriverHelper {
    WebDriver driver;

    public DriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url){
        driver.get(url);
    }
}
