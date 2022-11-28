package testRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
//		features = ".//Features/Customers.feature",  //To run Single feature file
		features = "C:\\Users\\Omkar\\eclipse-workspace\\Cucumber_Project\\Features" ,  //all feature file run
//		features = {".//Features/Customers.feature",".//Features/Login.feature"},  //Select features file that you want to run
		glue = "stepDefinitions",
		tags="@Sanity", 
		dryRun = false,
		publish=true,
//		plugin = {"pretty","html:Reports/report.html","json:Reports/cucumber.json","junit:Reports/cucumber.xml"}
	
		//plugin for extent report
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)

public class TestRunner {

	
}
