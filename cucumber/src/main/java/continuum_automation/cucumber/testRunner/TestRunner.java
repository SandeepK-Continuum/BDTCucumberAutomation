package continuum_automation.cucumber.testRunner;
import java.io.File;

import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import continuum_automation.cucumber.DriverFactory;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.TestNgReporter;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;





@RunWith(Cucumber.class)
@CucumberOptions(
features = "classpath:features",
glue="continuum_automation.cucumber.stepDefinations",
plugin = {
"pretty",
"html:target/cucumber",
"json:results/cucumber.json",
"junit:results/cucumber.xml",
"rerun:target/rerun.txt" },
tags = {"@SmokeTest"}
)
public class TestRunner extends AbstractTestNGCucumberTests
{


}