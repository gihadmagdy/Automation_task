package StepDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",glue={"StepDefinitions"},
        plugin = {"pretty","html:target/HtmlReports"}
)

public class testRunner {
}
