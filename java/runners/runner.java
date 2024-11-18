package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features={"src/test/java/features/Salesforce.feature"},glue= {"stepdef"},publish=true, monochrome = true)
public class runner extends AbstractTestNGCucumberTests {

}
