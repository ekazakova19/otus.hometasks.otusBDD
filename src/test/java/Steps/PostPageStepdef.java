package Steps;

import PageObjects.PostsPage;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PostPageStepdef extends BaseStepdef {
    PostsPage postsPage;
    private static final Logger logger = LogManager.getLogger(PostPageStepdef.class);

    public PostPageStepdef() {
        postsPage = new PostsPage(driver);
    }

    @When("I open post page")
    public void iOpenPostPage(){
        postsPage.driverHelper.openUrl(postsPage.postsPageUrl);
    }
}
