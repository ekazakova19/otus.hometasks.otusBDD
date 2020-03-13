import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/FeatureFiles",
        glue = "Steps",
        snippets = SnippetType.CAMELCASE
)
public class cucumberRunner {

}