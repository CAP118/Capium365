package com.Capium365.StepDefination;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.TimeoutException;

import com.Capium.Utilites.StepTracker;
import com.Capium365.Actions.Capium365_InvoicesTab_recurringInvoice_Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Capium365_InvoicesTab_recurringInvoice_Stepdefination {
	
	Capium365_InvoicesTab_recurringInvoice_Actions RecurringInvoicepage=new Capium365_InvoicesTab_recurringInvoice_Actions();
	
	@Given("Click on invoices tab")
	public void click_on_invoices_tab() throws Exception {
		RecurringInvoicepage.invoicestab();
		StepTracker.setCurrentStep("Click on invoices tab");
	}
	@When("Click on arrow button in invoice tab")
	public void click_on_arrow_button_in_invoice_tab() throws Exception {
		RecurringInvoicepage.Arrowbutton();
		StepTracker.setCurrentStep("Click on arrow button in invoice tab");
	}
	@Then("Click on recurring invoice and verify page")
	public void click_on_recurring_invoice_and_verify_page() {
        RecurringInvoicepage.recurringinvoicetab();
        StepTracker.setCurrentStep("Click on recurring invoice and verify page");
	}
	@Then("Click on add recurring invoice button")
	public void click_on_add_recurring_invoice_button() {
		RecurringInvoicepage.addrecurringinvoicebutton();
		StepTracker.setCurrentStep("Click on add recurring invoice button");
	}
	@Then("Click on edit in company details")
	public void click_on_edit_in_company_details() throws InterruptedException {
	    RecurringInvoicepage.editbuttonincompanydetails();
	    StepTracker.setCurrentStep("Click on edit in company details");
	}
	@Then("Click on save without giving mandatory details in company details")
	public void click_on_save_without_giving_mandatory_details_in_company_details() throws InterruptedException, IOException {
	    RecurringInvoicepage.Clickonsavewithoutgivingmandatorydetailsincompanydetails(); 
	    StepTracker.setCurrentStep("Click on save without giving mandatory details in company details");
	} 
	@Then("Click on save with giving mandatory details in comapany details")
	public void click_on_save_with_giving_mandatory_details_in_comapany_details() throws InterruptedException {
	    RecurringInvoicepage.Clickonsavewithgivingmandatorydetailsincomapanydetails();
	    StepTracker.setCurrentStep("Click on save with giving mandatory details in comapany details");
	}
@Then("Click on cancel button in company details")
	public void click_on_cancel_button_in_company_details() {
	    RecurringInvoicepage.cancelbuttonincompanydetails();
	    StepTracker.setCurrentStep("Click on cancel button in company details");
	}
	@Then("Click customer name add button")
	public void click_customer_name_add_button() {
	    RecurringInvoicepage.customernameaddbutton();
	    StepTracker.setCurrentStep("Click customer name add button");
	}
	@Then("Fill the mandatory details and save")
	public void fill_the_mandatory_details_and_save() throws InterruptedException{
	    RecurringInvoicepage.Fillallmandatorydetailsinaddnewcustomer();
	    StepTracker.setCurrentStep("Fill the mandatory details and save");
	}
	@Then("Fill all the non mandatory details and save")
	public void fill_all_the_non_mandatory_details_and_save() throws InterruptedException, AWTException, IOException {
	    RecurringInvoicepage.Fillallnonmandatorydetailsinaddnewcustomer();
	    StepTracker.setCurrentStep("Fill all the non mandatory details and save");
	}
	@Then("Select customer and verify")
	public void select_existing_customer_and_verify() throws InterruptedException {
        RecurringInvoicepage.selectcustomerandverify();
        StepTracker.setCurrentStep("Select customer and verify");
	}
	@Then("Click on add new line in contact details")
	public void click_on_add_new_line_in_contact_details() throws InterruptedException {
	    RecurringInvoicepage.addnewlineincontactdetails();
	    StepTracker.setCurrentStep("Click on add new line in contact details");
	}
	@Then("Click on add new line cross button in contact details")
	public void click_on_add_new_line_cross_button_in_contact_details() throws InterruptedException {
	    RecurringInvoicepage.addnewlinecrossbuttonincontactdetails();
	    StepTracker.setCurrentStep("Click on add new line cross button in contact details");
	}
	@Then("Click on add new line in address details")
	public void click_on_add_new_line_in_address_details() throws InterruptedException {
	    RecurringInvoicepage.addnewlineinaddressdetails();
	    StepTracker.setCurrentStep("Click on add new line in address details");
	}
	@Then("Click on add new line cross button in address details")
	public void click_on_add_new_line_cross_button_in_address_details() throws InterruptedException {
	    RecurringInvoicepage.addnewlinecrossbuttoninaddressdetails();
	    StepTracker.setCurrentStep("Click on add new line cross button in address details");
	}
	@Then("Enter email in customer")
	public void enter_email_in_customer() {
		RecurringInvoicepage.Enteremail();
	    StepTracker.setCurrentStep("Click on add new line cross button in address details");
	}
	@Then("click on cancel changes in add new customer")
	public void click_on_cancel_changes_in_add_new_customer() {
	    RecurringInvoicepage.cancelchangesinaddnewcustomer();
	    StepTracker.setCurrentStep("click on cancel changes in add new customer");
	}
	@Then("click on settings and save and verify")
	public void click_on_settings_and_save_and_verify() throws InterruptedException {
	    RecurringInvoicepage.clickonsettingsandsaveandverify();
	    StepTracker.setCurrentStep("click on settings and save and verify");
	}
	@Then("select due date and verify in recurring invoices")
	public void select_due_date_and_verify_in_invoices() throws TimeoutException, IOException, InterruptedException {
	    RecurringInvoicepage.selectduedateandverifyininvoices();
	    StepTracker.setCurrentStep("select due date and verify in recurring invoices");
	}
	@Then("check repeat invoice check box and verify in invoice")
	public void check_repeat_invoice_check_box_and_verify_in_invoice() throws InterruptedException, TimeoutException {
		RecurringInvoicepage.checkrepeatinvoicecheckboxandverifyininvoice();
		 StepTracker.setCurrentStep("check repeat invoice check box and verify in invoice");
	}
	@Then("click on discount option and verify value")
	public void click_on_discount_option_and_verify_value() throws TimeoutException, InterruptedException {
	    RecurringInvoicepage.clickondiscountoptionandverifyvalue();
	    StepTracker.setCurrentStep("click on discount option and verify value");
	}
	@Then("Add item and verify")
	public void add_item_and_verify() throws TimeoutException, InterruptedException {
	    RecurringInvoicepage.additemandverify();
	    StepTracker.setCurrentStep("Add item and verify");
	}
	@Then("Select existing item")
	public void select_existing_item() throws TimeoutException {
		RecurringInvoicepage.selectexistingitem();
		 StepTracker.setCurrentStep("Select existing item");
	}
 
	@Then("Click on add bank and enter mandatory details")
	public void click_on_add_bank_and_enter_mandatory_details() throws InterruptedException, TimeoutException {
		RecurringInvoicepage.clickonaddbankandentermandetails();
		StepTracker.setCurrentStep("Click on add bank and enter mandatory details");
	}
	@Then("Select existing bank account")
	public void select_existing_bank_account() throws InterruptedException, TimeoutException {
		RecurringInvoicepage.selectexistingbankaccount();
		StepTracker.setCurrentStep("Select existing bank account");
	}
	@Then("Select repeat invoice status")
	public void Select_repeat_invoice_status() throws InterruptedException {
		RecurringInvoicepage.Selectrepeatinvoicestatus();
		 StepTracker.setCurrentStep("Select repeat invoice status");
	}
	@Then("Click on save and new and verify recurring invoice")
	public void click_on_save_and_new_and_verify_recurring_invoice() throws InterruptedException {
		RecurringInvoicepage.Clickonsaveandnewandverifyrecurringinvoice();
		 StepTracker.setCurrentStep("Click on save and new and verify recurring invoice");
	}
	@Then("Click on save and continue and verify recurring invoice")
	public void click_on_save_and_continue_and_verify_recurring_invoice() throws InterruptedException {
		RecurringInvoicepage.Clickonsaveandcontinueandverifyrecurringinvoice();
		 StepTracker.setCurrentStep("Click on save and continue and verify recurring invoice");
	}
	@Then("Click on save and exit and verify recurring invoice")
	public void click_on_save_and_exit_and_verify_recurring_invoice() throws InterruptedException {
		RecurringInvoicepage.Clickonsaveandexitandverifyrecurringinvoice();
		 StepTracker.setCurrentStep("Click on save and exit and verify recurring invoice");
	}
	@Then("Click on cancel changes and verify details")
	public void click_on_cancel_changes_and_verify_details() throws InterruptedException, IOException {
		RecurringInvoicepage.Clickoncancelchangesandverifydetails();
		 StepTracker.setCurrentStep("Click on cancel changes and verify details");
	}
	@Then("Click on add new recurring invoice plus button and verify")
	public void click_on_add_new_recurring_invoice_plus_button_and_verify() throws InterruptedException {
		RecurringInvoicepage.clickonaddnewrecurringinvoiceplusbuttonandverify();
		 StepTracker.setCurrentStep("Click on add new recurring invoice plus button and verify");
	}
	@Then("Check the checkbox and verify options are enabling")
	public void check_the_checkbox_and_verify_options_are_enabling() throws InterruptedException {
	    RecurringInvoicepage.checkthecheckboxandverifyoptionsareenabling();
	    StepTracker.setCurrentStep("Check the checkbox and verify options are enabling");
	}
	@Then("Click export to excel")
	public void click_export_to_excel() throws InterruptedException{
	    RecurringInvoicepage.clickexporttoexcel();
	    StepTracker.setCurrentStep("Click export to excel");
	}
	@Then("Click export to csv")
	public void click_export_to_csv() throws InterruptedException {
	    RecurringInvoicepage.clickexporttocsv();
	    StepTracker.setCurrentStep("Click export to csv");
	}
	@Then("Click export to pdf")
	public void click_export_to_pdf() throws InterruptedException {
	    RecurringInvoicepage.clickexporttopdf();
	    StepTracker.setCurrentStep("Click export to pdf");
	}
	@Then("Enter recurring invoice name and verify")
	public void enter_recurring_invoice_name_and_verify() throws InterruptedException {
	    RecurringInvoicepage.enterrecurringinvoicenameandverify();
	    StepTracker.setCurrentStep("Enter recurring invoice name and verify");
	}
	@Then("Select all status and validate")
	public void select_all_status_and_validate() throws InterruptedException {
	    RecurringInvoicepage.selectallstatusandvalidate();
	    StepTracker.setCurrentStep("Select all status and validate");
	}
    @Then ("Click on all time status and verify")
    public void click_on_all_time_status_and_verify() throws InterruptedException, TimeoutException, IOException {
	    RecurringInvoicepage.clickonalltimestatusandverify();
	    StepTracker.setCurrentStep("Click on all time status and verify");
    }
    @Then ("Click on recurring invoice check box and verify enabling options")
    public void click_on_recurring_invoice_checkbox_and_verify_enabling_options() throws InterruptedException {
	    RecurringInvoicepage.clickoninvoicecheckboxandverifyenablingoptions();
	    StepTracker.setCurrentStep("Click on recurring invoice check box and verify enabling option");
    }
    @When ("Click on export report as excel")
    public void click_on_export_report_as_excel() throws InterruptedException {
	    RecurringInvoicepage.clickonexportreportasexcel();
	    StepTracker.setCurrentStep("Click on export report as excel");
    }
@When ("Click on export report as csv")
    public void click_on_export_report_as_csv() throws InterruptedException {
	    RecurringInvoicepage.clickonexportreportascsv();
	    StepTracker.setCurrentStep("Click on export report as csv");
    }
    @When ("Click on export report as pdf")
    public void click_on_export_report_as_pdf() throws InterruptedException {
	    RecurringInvoicepage.clickonexportreportaspdf();
	    StepTracker.setCurrentStep("Click on export report as pdf");
    }
    @Then("Click on actions")
    public void click_on_actions() throws InterruptedException {
    	RecurringInvoicepage.clickonactions();
	    StepTracker.setCurrentStep("Click on actions");
    }
    @Then("Click on actions export excel")
    public void click_on_actions_export_excel() throws InterruptedException {
    	RecurringInvoicepage.clickonactionsexportexcel();
	    StepTracker.setCurrentStep("Click on actions export excel");
    }
    @Then("Click on actions export csv")
    public void click_on_actions_export_csv() throws InterruptedException {
    	RecurringInvoicepage.clickonactionsexportcsv();
	    StepTracker.setCurrentStep("Click on actions export csv");
    }
    @Then("Click on actions export pdf")
    public void click_on_actions_export_pdf() throws InterruptedException {
    	RecurringInvoicepage.clickonactionsexportpdf();
	    StepTracker.setCurrentStep("Click on actions export pdf");
    }

}
