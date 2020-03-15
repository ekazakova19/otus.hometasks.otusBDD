package Steps;

import Helpers.DriverHelper;
import Helpers.DriverManager;
import org.openqa.selenium.WebDriver;

public class BaseStepdef {
    public WebDriver driver;
    public DriverHelper driverHelper;

    public BaseStepdef() {
        driver =DriverManager.getDriver();
        driverHelper = new DriverHelper(driver);
    }
}
