import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( plugin = { "pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json" },
        features = "src/test/resources/features", glue = "stepDefinitions")

public class TestRunner {

}