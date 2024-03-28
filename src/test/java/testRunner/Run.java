package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/LoginFeature.feature", ".//Features/Customer.feature"},
		glue = "stepDefination",
		dryRun = false,
		monochrome = true,
		tags = "@Regression",
//		plugin = {"pretty",	"html:target/cucumber-reports/reports3.html"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
//"pretty", "html:target/cucumber-reports/reports1.html"  >> html report \
//"pretty", "json:target/cucumber-reports/reports2.json"  >> json report  ==>> not used for extend report
//"pretty", "junit:target/cucumber-reports/reports3.xml"  >> xml report  /
public class Run extends AbstractTestNGCucumberTests{
//	This class will be empty
}
