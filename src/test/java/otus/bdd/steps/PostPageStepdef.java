package otus.bdd.steps;

import org.springframework.beans.factory.annotation.Autowired;
import otus.bdd.pageObjects.StandalonePostPage;
import otus.bdd.pageObjects.PostsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
public class PostPageStepdef {

    @Autowired
    PostsPage postsPage;
    @Autowired
    StandalonePostPage standalonePostPage;
    private static final Logger logger = LogManager.getLogger(PostPageStepdef.class);

    @Given("I open post page")
    public void iOpenPostPage(){
        postsPage.commonActions.openUrl(postsPage.postsPageUrl);
    }

    @When("I input {string} in search field")
    public void iSearchForGit(String text) {
        postsPage.commonActions.clickOn(postsPage.SEARCHING_BUTTON);
        postsPage.commonActions.enterTextField(postsPage.SEARCH_BOX,text);
    }

    @When("I click on search button")
    public void iClickOnSearchButton() {
        postsPage.commonActions.clickOn(postsPage.SEARCH_BUTTON);
    }


    @Then("I see posts found")
    public void iSeePostsFound() {
        Assert.assertTrue(postsPage.getFoundPostsCount()>0);
    }


    @When("I close search box")
    public void iCloseSearchBox() {
        postsPage.commonActions.clickOn(postsPage.CLOSE_SEARCHBOX_BTN);
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
        postsPage.commonActions.openUrl(postsPage.favoritePageUrl);
        Assert.assertTrue(postsPage.getPostsCount()>0);
    }

    @When("I click on read more for any post")
    public void iClickOnReadMoreForAnyPost() {
        postsPage.readMoreAnyPost();
    }

    @Then("I see the post page opened")
    public void iSeeThePostPageOpened() {
        standalonePostPage.getPost();
    }
}
