package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src\\main\\java\\Features\\Feature.feature"
,glue= {"StepDefinition"},
format = {"pretty"},plugin = {"json:target/cucumber.json"},
strict = true,
dryRun = false,
monochrome = true
)


public class TestRunner {

}
