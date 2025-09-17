package com.Capium365.StepDefination;

import com.Capium365.Actions.ClientPortal_Imports_Actions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientPortal_Imports_Stepdefination {

	ClientPortal_Imports_Actions importsact=new ClientPortal_Imports_Actions();
	
	@When("Click on Imports Menu")
	public void click_on_imports_menu() throws Throwable {
	    importsact.ClickonImportsMenu();
	}
 
	@Then("Select Client CheckBox")
	public void select_client_check_box() throws Throwable {
	   importsact.ClickonClientCheckBox();
	   importsact.ClickonImportNextbutton();
	}
 
	@Then("Import Excel File From Folder")
	public void import_excel_file_from_folder() throws Throwable {
	   importsact.uploadExcelWithRobot();
	   importsact.ClickonImportNextbutton();
	}
 
	@Then("Validate Success List")
	public void validate_Success_List() throws Throwable {	 
	    importsact.ValidatteUploadSuccessList();
	}

	@Then("Click on Save and Next button")
	public void click_on_save_and_next_button() throws Throwable {
	    importsact.ClickonSaveandNextbutton();
	}
 
	@Then("Validate Client Imported")
	public void validate_client_imported() {
	    importsact.ValidateClientImportedornot();
	}
 
	@Then("Validate Duplicate Client Imported")
	public void validate_duplicate_client_imported() {
	    importsact.ValidateDuplicateImportuser();
	}
	@Then("Click on ClientNext button")
	public void click_on_client_next_button() throws Throwable {
		 importsact.ClickonImportNextbutton();
    }
	@Then("Select Users CheckBox")
	public void select_users_check_box() throws Throwable {
		 importsact.ClickonuserscheckBox();
		 importsact.ClickonImportNextbutton();
	}
 
	@Then("Import Excel File From Folder for user")
	public void import_excel_file_from_folder_for_user() throws Throwable {
	   importsact.uploadExceluserWithRobot();
	}
 
	@Then("Validate userSuccess List")
	public void validate_user_success_list() {
		importsact.ValidatteUploadSuccessList();
	}
	
}
