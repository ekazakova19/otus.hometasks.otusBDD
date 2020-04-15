package otus.bdd.helpers;

import org.openqa.selenium.WebDriver;

public class DriverHelper {
    WebDriver driver;

    public DriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    //to remove
    public void openUrl(String url){
        driver.get(url);
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

}
