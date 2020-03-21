package Steps;

import Helpers.CookieManager;
import Helpers.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksStepsdef {

  //  @After(order = 0)
    public void closeDriver(){
        DriverManager.closeDriver();
    }

    @After(order = 100,value = "@cookies")
    public void saveAuthorizationCookies(){
        CookieManager cookieManager = new CookieManager(DriverManager.getDriver());
        cookieManager.saveCookiesToFile();
    }
}
