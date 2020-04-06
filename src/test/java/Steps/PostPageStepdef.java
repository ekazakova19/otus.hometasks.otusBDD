package Steps;

import PageObjects.StandalonePostPage;
import PageObjects.PostsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PostPageStepdef {
    WebDriver driver;
    PostsPage postsPage;
    StandalonePostPage standalonePostPage;
    private static final Logger logger = LogManager.getLogger(PostPageStepdef.class);

    public PostPageStepdef() {
        driver = Hooks.driver;
        postsPage = new PostsPage(driver);
    }

    @Given("I open post page")
    public void iOpenPostPage(){
        postsPage.driverHelper.openUrl(postsPage.postsPageUrl);
    }

    @When("I input {string} in search field")
    public void iSearchForGit(String text) {
        postsPage.clickOn(postsPage.SEARCHING_BUTTON);
        postsPage.enterTextField(postsPage.SEARCH_BOX,text);
    }

    @When("I click on search button")
    public void iClickOnSearchButton() {
        postsPage.clickOn(postsPage.SEARCH_BUTTON);
    }


    @Then("I see posts found")
    public void iSeePostsFound() {
        Assert.assertTrue(postsPage.getFoundPostsCount()>0);
    }


    @When("I close search box")
    public void iCloseSearchBox() {
        postsPage.clickOn(postsPage.CLOSE_SEARCHBOX_BTN);
    }

    @Then("I don't see search box anymore")
    public void iDonTSeeSearchBoxAnymore() {
        Assert.assertTrue(postsPage.isSearchBoxClosed());
    }

    @When("I click on add to favorite icon for any post")
    public void iClickOnAddToFavoriteIconForAnyPost() {
        postsPage.addAnyPostToFavorite();
    }

    @Then("I see the post in my favorite posts")
    public void iSeeThePostInMyFavoritePosts() {
        postsPage.driverHelper.openUrl(postsPage.favoritePageUrl);
        Assert.assertTrue(postsPage.getPostsCount()>0);
    }

    @When("I click on read more for any post")
    public void iClickOnReadMoreForAnyPost() {
        postsPage.readMoreAnyPost();
        standalonePostPage = new StandalonePostPage(driver);
    }

    @Then("I see the post page opened")
    public void iSeeThePostPageOpened() {
        standalonePostPage.getPost();
    }
}
