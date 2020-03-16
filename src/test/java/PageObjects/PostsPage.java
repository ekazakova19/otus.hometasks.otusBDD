package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PostsPage extends BasePage{
    public String postsPageUrl = "https://otus.ru/nest/posts/";

    @FindBy(css="div.nav__item.vertical-middle div.search__button")
    public WebElement SEARCHING_BUTTON;
    @FindBy(css="div.nav__item.vertical-middle div[class=\"search__box js-search-box\"]>input")
    public WebElement SEARCH_BOX;
    @FindBy(css="div.nav__item.vertical-middle div.search__box.js-search-box>button")
    public WebElement SEARCH_BUTTON;

    public PostsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver,this);
    }



}
