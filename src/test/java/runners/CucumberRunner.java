package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features/Login.feature" }, glue = { "stepdefination" })
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
