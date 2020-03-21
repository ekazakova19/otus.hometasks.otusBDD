import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/FeatureFiles/Polls.feature",
        glue = "Steps",
        snippets = SnippetType.CAMELCASE
     //, tags = {"@debug"}
)
public class cucumberRunner {

}
