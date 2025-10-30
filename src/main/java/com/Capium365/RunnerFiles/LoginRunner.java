package com.Capium365.RunnerFiles;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Capium.Utilites.HelperClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// change here your Feature file path
@CucumberOptions(features = "D:\\Core Modules\\Capium365\\src\\test\\resources\\Capium365FeatureFiles\\LoginFeature.feature",
       glue = "com.Capium365.StepDefination",
       tags="@Login",
        plugin = {
		"pretty", 
		"html:target/cucumber-reports/CucumberReport.html",
		"json:target/cucumber-reports/CucumberReport.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

)

public class LoginRunner extends AbstractTestNGCucumberTests {

	@BeforeClass(alwaysRun = true)
    @Parameters("browserType") 
    public void setup(String browserType) {
		// If you want to run individual ruuner clas here provide Optinal chrome
        System.out.println("Initializing browser: " + browserType);
        HelperClass.setUpDriver(browserType);
        System.out.println("Scenario started on driver: " + HelperClass.getDriver());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        System.out.println("Closing browser...");
        HelperClass.tearDown();
    }
}
