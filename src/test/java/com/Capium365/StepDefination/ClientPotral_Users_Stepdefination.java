package com.Capium365.StepDefination;

import java.awt.AWTException;
import java.io.IOException;

import com.Capium365.Actions.ClientPortal_Users_Actions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientPotral_Users_Stepdefination {

	ClientPortal_Users_Actions userAct=new ClientPortal_Users_Actions();
	@When("Click on Users Menu")
	public void click_on_users_menu() throws Throwable {
	    userAct.ClickonUserMenu();
	}
 
	@Then("Validate Users Main Grid Should Display")
	public void validate_users_main_grid_should_display() {
	    userAct.ValidateUserMainGrid();
	}
	@When("Click on Add User button")
	public void click_on_add_user_button() {
	    userAct.ClickonAddUserBtton();
	}
 
	@Then("Enter All Mandatory Fields")
	public void enter_all_mandatory_fields() throws Throwable, AWTException, IOException {
	    userAct.FillthemandatorydetailsinaddUserandsaveandexit();
	}

	@Then("Enter Non Mandatory Fields")
	public void enter_non_mandatory_fields() throws Throwable, Throwable, Throwable {
	    userAct.FilltheNonmandatorydetailsinaddUserandsaveandexit();
	}
 
	@Then("Verify Error Message")
	public void verify_error_message() {
		userAct.ValidateErrorMessage(); 
	}
	@Then("Click on Save and Exit button in user screen")
	public void click_on_save_and_exit_button_in_user_screen() {
	    userAct.ClickonSaveandExitUser();
	}
	@Then("Enter user Name and Search")
	public void enter_user_name_and_search() throws Throwable {
	    userAct.SearchUserName();
	}
 
	@Then("Validate User Should Display")
	public void validate_user_should_display() {
	   userAct.ValidateUser();
	}
	@Then("Click on dropdown and Validate")
	public void click_on_dropdown_and_validate() throws Throwable {
	   userAct.SelectStatusDropdownandVerify();
	}
	@Then("Select Checkbox")
	public void select_checkbox() throws Throwable {
	   userAct.clickonusercheckbox();
	}
 
	@Then("Validate EditPage shouldnot Visible")
	public void validate_edit_page_shouldnot_visible() {
	    userAct.ValidateEditPageshouldnotvisible();
	}
	@Then("Click on userCancel button")
	public void click_on_user_cancel_button() throws Throwable {
	    userAct.clickoncancelbutton();
	}
	@Then("Click on UserfooterDelete button")
	public void click_on_userfooter_delete_button() throws Throwable {
	   userAct.ClickonFooterdeletebutton();
	}
 
	@Then("Validate Delete Message Should Display")
	public void validate_delete_message_should_display() {
	  userAct.ValidatedeleteMessage();
	}
	@Then("Click on Delete CheckBox")
	public void click_on_delete_check_box() throws Throwable {
		 userAct.ClickonDeleteCheckBox();
	}
 
	@Then("Click on DeleteYes button")
	public void click_on_delete_yes_button() throws Throwable {
		userAct.ClickonYesbutton();
	}
	@Then("Click on Archive button")
	public void click_on_archive_button() throws Throwable {
	    userAct.ClickonFooterArchivebutton();
	}
 
	@Then("Validate Archive Message")
	public void validate_archive_message() {
	    userAct.ValidateArchiveMessage();
	}
	@Then("Click on Restore button")
	public void click_on_restore_button() throws Throwable {
	   userAct.ClickonFooterRestorebutton();
	}
 
	@Then("Validate Restore Message")
	public void validate_restore_message() {
	    userAct.ValidateRestoreMessage();
	}
 
}
