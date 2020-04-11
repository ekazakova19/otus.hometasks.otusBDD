import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/featureFiles/",
        glue = "steps",
        snippets = SnippetType.CAMELCASE,
        plugin = { "pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}
        , tags = {"@debug"}
)
public class cucumberTest {

}
