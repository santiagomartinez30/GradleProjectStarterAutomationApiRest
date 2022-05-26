package co.com.gorest.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consult_users.feature",
        glue = "co.com.gorest.steps",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ConsultUsersRunner {
}
