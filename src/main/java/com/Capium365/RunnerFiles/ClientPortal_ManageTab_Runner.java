package com.Capium365.RunnerFiles;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src\\test\\resources\\Capium365FeatureFiles\\ClientPortal_ManageTab.feature",
	    glue = "com.Capium365.StepDefination",
	    tags = "",
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/CucumberReport.html",
	        "json:target/cucumber-reports/CucumberReport.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    },
	    monochrome = true
	)

public class ClientPortal_ManageTab_Runner {

}
