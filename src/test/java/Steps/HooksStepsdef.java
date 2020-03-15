package Steps;

import Helpers.CookieManager;
import Helpers.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksStepsdef {

    @After(order = 0)
    public void closeDriver(){
        System.out.print("Hooks close driver");
        DriverManager.closeDriver();
    }

    @After(order = 100,value = "@cookies")
    public void saveAuthorizationCookies(){
        System.out.println("Cookies hooks after");
        CookieManager cookieManager = new CookieManager(DriverManager.getDriver());
        cookieManager.saveCookiesToFile();
    }
}
