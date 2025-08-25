package com.Capium365.StepDefination;

import com.Capium.Utilites.StepTracker;
import com.Capium365.Actions.Capium365_BankTab_Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Capium365_BankTab_Stepdefination {

	Capium365_BankTab_Actions bankpage = new Capium365_BankTab_Actions();

	@Given("Click on bank tab")
	public void click_on_bank_tab() throws Exception {
		bankpage.clickonbanktab();
		StepTracker.setCurrentStep("Click on bank tab");
	}

	@Then("Verify bank tab")
	public void verify_bank_tab() {
		bankpage.Verifybanktab();
		StepTracker.setCurrentStep("Verify bank tab");
	}

	@Given("Click on expand icon")
	public void click_on_expand_icon() throws Exception {
		bankpage.Clickonexpandicon();
		StepTracker.setCurrentStep("Click on expand icon");
	}

	@Then("Validate bank accounts")
	public void validate_bank_accounts() {
		bankpage.Validatebankaccounts();
		StepTracker.setCurrentStep("Validate bank accounts");

	}

	@Given("Click on add new account")
	public void click_on_add_new_account() throws Exception {
		bankpage.Clickonaddnewaccount();
		StepTracker.setCurrentStep("Click on add new account");
	}

	@Then("Continue with the following steps")
	public void navigate_to_true_layer_page_and_select_page() throws Exception {
		bankpage.Continuewiththefollowingsteps();
		StepTracker.setCurrentStep("Continue with the following steps");
	}

	@Given("Delete account")
	public void select_bank_account() throws Exception {
		bankpage.Deleteaccount();
		StepTracker.setCurrentStep("Delete account");
	}

	@Then("Enter text in the search text field and Verify data")
	public void verify_data() throws Exception {
		bankpage.EntertextinthesearchtextfieldandVerifydata();
		StepTracker.setCurrentStep("Enter text in the search text field and Verify data");
	}

	@Given("Click on date dropdown")
	public void click_on_date_dropdown() throws Exception {
		bankpage.Clickondatedropdown();
		StepTracker.setCurrentStep("Click on date dropdown");

	}

	// Export
	@Given("Click on three dot menu")
	public void Click_on_three_dot_menu() throws Exception {
		bankpage.exportthreedotmenu();
		StepTracker.setCurrentStep("Click on three dot menu");
	}

	@Given("click on export to excel")
	public void click_on_export_to_excel() {
		bankpage.exporttoexcel();
		StepTracker.setCurrentStep("click on export to excel");
	}

	@Given("click on export to csv")
	public void click_on_export_to_csv() throws Exception {
		bankpage.exporttocsv();
		StepTracker.setCurrentStep("click on export to csv");
	}

	@Given("click on export to pdf")
	public void click_on_export_to_pdf() {
		bankpage.exporttopdf();
		StepTracker.setCurrentStep("click on export to pdf");
	}

	@Then("verify headers")
	public void verify_headers() throws Exception {
		bankpage.verifyheaders();
		StepTracker.setCurrentStep("verify headers");
	}

	@Given("click on refresh account")
	public void click_on_refresh_account() throws Exception {
		bankpage.clickonrefreshaccount();
		StepTracker.setCurrentStep("click on refresh account");
	}

	@Given("Click on pagination dropdown and verify the records based on dropdown value")
	public void click_on_pagination_dropdown() throws Exception {
		bankpage.Clickonpaginationdropdownandverifytherecordsbasedondropdownvalue();
		StepTracker.setCurrentStep("Click on pagination dropdown and verify the records based on dropdown value");
	}

	@Then("Click on each page number")
	public void click_on_each_page_number() throws Exception {
		bankpage.Clickoneachpagenumber();
		StepTracker.setCurrentStep("Click on each page number");
	}

	@Then("verify previoud button is disabled whenever the first page number is highlighted")
	public void verify_previoud_button_is_disabled_whenever_the_first_page_number_is_highlighted() {
		bankpage.verifyprevioudbuttonisdisabledwheneverthefirstpagenumberishighlighted();
		StepTracker.setCurrentStep("verify previoud button is disabled whenever the first page number is highlighted");
	}

	@Then("verify next button is disabled whenever the last page number is highlighted")
	public void verify_next_button_is_disabled_whenever_the_last_page_number_is_highlighted() throws Exception {
		bankpage.verifynextbuttonisdisabledwheneverthelastpagenumberishighlighted();
		StepTracker.setCurrentStep("verify next button is disabled whenever the last page number is highlighted");
	}

	@Given("click on goto TF and change the page")
	public void click_on_goto_tf_an_chanage_the_page() throws Exception {
		bankpage.clickongotoTFandchangethepage();
		StepTracker.setCurrentStep("click on goto TF and change the page");
	}

	@Given("go to settings and click on business")
	public void go_to_settings_and_click_on_business() throws Exception {
		bankpage.gotosettingsandclickonbusiness();
		StepTracker.setCurrentStep("go to settings and click on business");
	}

	@Then("Compare the bank accounts in bank tab and bussiness tab")
	public void get_the_data_of_bank_account_and_store() throws Exception {
		bankpage.Comparethebankaccountsinbanktabandbussinesstab();
		StepTracker.setCurrentStep("Compare the bank accounts in bank tab and bussiness tab");

	}

	@Then("Click on check box for id and export to excel")
	public void click_on_check_box_for_id_and_export_to_excel() throws Exception {
		bankpage.Clickoncheckboxforidandexporttoexcel();
		StepTracker.setCurrentStep("Click on check box for id and export to excel");
	}

	@Then("Click on check box for id and export to csv")
	public void click_on_check_box_for_id_and_export_to_csv() throws Exception {
		bankpage.Clickoncheckboxforidandexporttocsv();
		StepTracker.setCurrentStep("Click on check box for id and export to csv");
	}

	@Then("Click on check box for id and export to pdf")
	public void click_on_check_box_for_id_and_export_to_pdf() throws Exception {
		bankpage.Clickoncheckboxforidandexporttopdf();
		StepTracker.setCurrentStep("Click on check box for id and export to pdf");
	}

	@Then("Click on check box and clcik on cross mark")
	public void click_on_check_box_and_clcik_on_cross_mark() throws Exception {
		bankpage.Clickoncheckboxandclcikoncrossmark();
		StepTracker.setCurrentStep("Click on check box and clcik on cross mark");
	}

	@Then("enter text in search text field and verify")
	public void enter_in_text_in_search_text_field_and_verify() throws Exception {
		bankpage.entertextinsearchtextfieldandverify();
		StepTracker.setCurrentStep("enter text in search text field and verify");
	}

	@Then("Click on cross mark in search text field and verify the data is cleared")
	public void click_on_cross_mark_in_search_text_field_and_verify_the_data_is_cleared() throws Exception {
		bankpage.Clickoncrossmarkinsearchtextfieldandverifythedataiscleared();
		StepTracker.setCurrentStep("Click on cross mark in search text field and verify the data is cleared");
	}

}
