package com.Capium365.StepDefination;

import com.Capium365.Actions.ClientPortal_ManageTab_Actions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientPortal_ManageTab_Stepdefination {
	
	
	ClientPortal_ManageTab_Actions cpmanageActions =new ClientPortal_ManageTab_Actions();
	@When("Click on Add Client button")
    public void click_on_add_client_button() throws Throwable {
        cpmanageActions.ClickonAddClientButton();
    }
 
    @Then("Validate Add New Client Page Should Display")
    public void validate_add_new_client_page_should_display() {
        cpmanageActions.VerifyAddNewClientPage();
    }
    @Then("Enter Add Mandatory Details")
    public void enter_add_mandatory_details() throws Throwable {
        cpmanageActions.FillthemandatorydetailsinaddClientandsaveandexit();
    }
 
 
    @Then("Verify Success Message")
    public void verify_Successs_Message() {
       cpmanageActions.ValidateSuccessMessage();
    }
    @Then("Click on Save and Send Invite to Threesixytyfive button")
    public void click_on_save_and_send_invite_to_Threesixytyfive_button() throws Throwable {
       cpmanageActions.ClickonSaveandSendInviteTo365();
    }
    
    @Then("Click on Save and Send Invite to {int} button")
    public void click_on_save_and_send_invite_to_button(Integer int1) throws Throwable {
    	 cpmanageActions.SendInvite();
    }
 
    @Then("Validate 365status should ResendInvitation")
    public void validate_365status_should_resend_invitation() throws Throwable {
        cpmanageActions.ValidateThreeSixtyFiveStatus();
    }
    @When("Search Client Name and ClickonGotoTreeSixtyFive")
    public void search_client_name_and_clickon_goto_tree_sixty_five() throws Throwable {
        cpmanageActions.validateSearchandNaviagteto365();
    }
 
    @Then("Vaidate ThreeSixtyFiveDahsBoardShouldDisplay")
    public void vaidate_three_sixty_five_dahs_board_should_display() {
        cpmanageActions.Validate365DashBoardMainGrid();
    }
    @When("Click on Edit Icon in Client Portal Main Grid")
    public void click_on_edit_icon_in_client_portal_main_grid() throws Throwable {
       cpmanageActions.ClickonEditIcon();
    }
 
    @Then("Edit Client Page Should Display")
    public void edit_client_page_should_display() {
       cpmanageActions.ValidateEditDetailsPage();
    }
    @When("Mouse hover and Click on Three button")
    public void mouse_hover_and_click_on_three_button() throws Throwable {
        cpmanageActions.ClickonMoreVertOptions();
    }
    @When("Mousehover and Click on Archive button")
    public void mousehover_and_click_on_archive_button() throws Throwable {
        cpmanageActions.ClickonnArchivebutton();
    }
 
    @Then("Archive and Importpopup Should Didplay")
    public void archive_and_importpopup_should_didplay() {
    }
    @Then("Click on Import button")
    public void click_on_import_button() {

    }
 
    @Then("Validate Client Main Dashboard Should Display")
    public void validate_client_main_dashboard_should_display() {

    }
    @When("Click on All365Status dropdown and Verify")
    public void click_on_all_365status_dropdown_and_verify() throws Throwable {
        cpmanageActions.SelectStatusDropdownandVerify();
    }
    @When("Click on AllStatus Dropdown and Verify")
    public void click_on_all_status_dropdown_and_verify() throws Throwable {
        cpmanageActions.ValidateStatusdrodown();
    }
    @When("Click on Contact Link")
    public void click_on_contact_link() {
      cpmanageActions.ClickonContactLink();    	
    }
 
    @Then("Valdiate Conatact Link popup Should Display")
    public void valdiate_conatact_link_popup_should_display() {
        cpmanageActions.ValidateConctactDetails();
    }
    @Then("Confirm Archive popup Should Display")
    public void confirm_archive_popup_should_display() {
        cpmanageActions.ValidateConfirmArchivePopup();
    }
 
    @When("Click on Delete Icon")
    public void click_on_delete_icon() throws Throwable {
        cpmanageActions.mousehoverandClickonDeleteIcon();
        cpmanageActions.selectcheckboxdelete();
    }
 
    @Then("Validate DeleteSuccess Message")
    public void validate_delete_success_message() {
    }

}
