package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PostsPage extends BasePage{
    public String postsPageUrl = "https://otus.ru/nest/posts/";

    public PostsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver,this);
    }
}
