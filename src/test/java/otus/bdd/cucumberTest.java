package otus.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/otus/bdd/featureFiles/",
        glue = "otus.bdd.steps",
        snippets = SnippetType.CAMELCASE,
        plugin = { "pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}
        //, tags = {"@debug"}
)
public class cucumberTest {

}
