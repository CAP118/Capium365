package com.Capium365.StepDefination;

import com.Capium.Utilites.ConfigReader;
import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.Capium.Utilites.StepTracker;
import com.Capium365.Actions.LoginActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefination {

	LoginActions loginpage = new LoginActions();

	@Given("Launch the browser")
	public void launch_the_browser() {
		StepTracker.setCurrentStep("Launch the browser");
		Log.info("Launch browser successfully.", "Browser Launching");
	}

	@Given("User need to enter the Application Url")
	public void user_need_to_enter_the_application_url() {
		String url = ConfigReader.getProperty("app.url");
		HelperClass.openPage(url);
		StepTracker.setCurrentStep("User need to enter the Application Url");
		Log.info("User need to enter the Application Url", "URL entered successfully.");
	}

	@Given("Click on Capium365 Client login")
	public void click_on_capium365_client_login() {
		loginpage.clickCapium365ClientLogin();
		StepTracker.setCurrentStep("Click on Capium365 Client login");
		Log.info("Click on Capium365 Client login", "Click");
	}

	@When("User Enter username")
	public void user_enter_username() {
		String username = ConfigReader.getProperty("username");
		loginpage.EnterUsername(username);
		StepTracker.setCurrentStep("User Enter username and Password");
		Log.info("Username and Password entered successfully.", "Credentials");
	}

	@Then("User Click on next button")
	public void user_click_on_login_button() throws Exception {
		loginpage.Clicknextbtn();
		StepTracker.setCurrentStep("User Click on login button");
		Log.info("User Click on next button", "Button");
	}

	@Then("User enter OTP")
	public void user_enter_otp() {
		loginpage.EnterOTP();
		StepTracker.setCurrentStep("User enter OTP");
		Log.info("OTP enterned sucessfully", "OTP");

	}

	@Then("Click on verify account")
	public void click_on_verify_account() throws InterruptedException {
		loginpage.Clickonverifyaccount();
		Log.info("Login button clicked sucessfully", "Verifying");
		StepTracker.setCurrentStep("Click on verify account");
	}

	@Then("Redirect to365 client")
	public void redirect_to365_client() {
		loginpage.isHomePage();
		StepTracker.setCurrentStep("Redirect to365 client");
		Log.info("Redirected to Capium365 homepage sucessfully", "Redirection");
		Hooks.captureScreenshotBase64(HelperClass.getDriver(), Hooks.getScenarioTest(), "Redirect to365 client");

	}
	
	@Given("Click on Accountant login")
	public void click_on_accountant_login() {
	    loginpage.ClickOnAccountant();
	}
	@When("Enter username and password")
	public void enter_username_and_password() {
	    loginpage.EnterUsernamePassword();
	}
	@When("click on Login Button")
	public void click_on_login_button() {
	    loginpage.ClickOnLogin();
	}
	@Then("Navigate to capium365 module")
	public void navigate_to_capium365_module() {
	    loginpage.navigateToCapium365Module();
	}

}
