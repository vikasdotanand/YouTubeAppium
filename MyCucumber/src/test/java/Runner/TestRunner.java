package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features= {"Features"}, glue = {"stepDefination"},
		
		dryRun = false, 
		monochrome = true,
		plugin = {"pretty","html:target/cucumber.html" , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		
		)






public class TestRunner {

}
