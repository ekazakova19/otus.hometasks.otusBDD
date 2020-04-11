package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PostsPage extends BasePage{
    public String postsPageUrl = "https://otus.ru/nest/posts/";
    public String favoritePageUrl = "https://otus.ru/nest/marked/";

    @FindBy(css="div.nav__item.vertical-middle div.search__button")
    public WebElement SEARCHING_BUTTON;
    @FindBy(css="div.nav__item.vertical-middle div[class=\"search__box js-search-box\"]>input")
    public WebElement SEARCH_BOX;
    @FindBy(css="div[class=\"search__box js-search-box search__box_close\"]")
    public WebElement SEARCH_BOX_CLOSED;
    @FindBy(css="div.nav__item.vertical-middle div.search__box.js-search-box>button")
    public WebElement SEARCH_BUTTON;
    @FindBy(css="div.container__col>a")
    private List<WebElement> SEARCH_LIST;
    @FindBy(css="div[class=\"search__box js-search-box\"] i.ic-close")
    public WebElement CLOSE_SEARCHBOX_BTN;


    @FindBy(css="div.blog-post")
    private List<WebElement> POST_LIST;

    private By ADD_TO_FAVORITE_BTN = By.cssSelector("div.blog__counters-item>a");
    private By READ_MORE = By.cssSelector("div.text.text_p>a");


    public PostsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver,this);
    }

    public int getFoundPostsCount(){
        return SEARCH_LIST.size();
    }
    public int getPostsCount(){
        return POST_LIST.size();
    }

    public boolean isSearchBoxClosed(){
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.cssSelector("div.nav__item.vertical-middle div.search__box.js-search-box>button")));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public WebElement getAnyPost(){
        return POST_LIST.get(0);
    }

    public void addAnyPostToFavorite(){
        clickOn(getAnyPost().findElement(ADD_TO_FAVORITE_BTN));
    }

    public void readMoreAnyPost(){
        clickOn(getAnyPost().findElement(READ_MORE));
    }






}
