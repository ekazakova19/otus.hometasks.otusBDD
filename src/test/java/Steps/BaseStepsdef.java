package Steps;

import Helpers.DriverManager;
import org.junit.Before;

public class BaseStepsdef {
    @Before
    public void initDriver(){
        DriverManager.getChromeDriver();
    }

}
