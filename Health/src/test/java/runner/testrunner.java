package runner;

	import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
	import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features ="src/test/java/features"
	        ,glue= "seleniumgluecode",
	        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
	        monochrome = true
	                )

	public class testrunner {
		 @AfterClass
		    public static void writeExtentReport() {
		        Reporter.loadXMLConfig(new File("config/report.xml"));
		 }
		 }