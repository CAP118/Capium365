Feature: Validate ManageTab

  Background: Login into Capium Application
    Given Launch the browser
    And User need to enter the Application Url
    And Click on Accountant login
    When Enter username and password
    And click on Login Button
    Then Navigate to capium365 module

  
  Scenario: Verify Add New Client Page
    When Click on Add Client button
    Then Validate Add New Client Page Should Display

  Scenario: Verify Add New Client Page
    When Click on Add Client button
    Then Enter Add Mandatory Details
    Then Verify Success Message

  Scenario: Verify Save and Send Invite to Threesixty
    When Click on Add Client button
    Then Enter Add Mandatory Details
    Then Click on Save and Send Invite to Threesixytyfive button
    Then Validate 365status should ResendInvitation

  Scenario: Validate SearchClient and GotoThreeSixtyFive
    When Search Client Name and ClickonGotoTreeSixtyFive
    Then Vaidate ThreeSixtyFiveDahsBoardShouldDisplay

  Scenario: Validate MoreVertbutton In Client Main Page
    When Mouse hover and Click on Three button
    Then Archive and Importpopup Should Didplay

  Scenario: Validate Edit Client Manage Tab
    When Click on Edit Icon in Client Portal Main Grid
    Then Edit Client Page Should Display

  Scenario: Validate Archive button
    When Mousehover and Click on Archive button
    Then Confirm Archive popup Should Display

  Scenario: Validate Delete button
    When Click on Delete Icon
    Then Validate DeleteSuccess Message

  Scenario: Validate Import button by Morevert button
    When Mouse hover and Click on Three button
    Then Click on Import button
    Then Validate Client Main Dashboard Should Display

  Scenario: Validate All365 Status dropdown
    When Click on All365Status dropdown and Verify

  Scenario: Vaidate AllStatus dropdown
    When Click on AllStatus Dropdown and Verify

  Scenario: Validate Contact Name Poup
    When Click on Contact Link
    Then Valdiate Conatact Link popup Should Display
