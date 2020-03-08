package CucumberBDD.reports;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions (
	features = {"src/test/java/CucumberBDD/featurefiles/"},
	monochrome = true,
	glue = {"CucumberBDD.stepfiles"},
	plugin = {"pretty", "html:target/cucumber", 
			"json:target/cucumberbdd.json",
			"com.cucumber.listener.ExtentCucumberFormatter:target/CucumberBDD_Report.html"
			}
	
)

public class Runner {

}
