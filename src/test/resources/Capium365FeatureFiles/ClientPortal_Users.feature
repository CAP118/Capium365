Feature: Validate USers Menu

  Background: Login into Capium Application
    Given Launch the browser
    And User need to enter the Application Url
    And Click on Accountant login
    When Enter username and password 
    And click on Login Button
    Then Navigate to capium365 module

  Scenario: Validate Users Main Grid
    When Click on Users Menu
    Then Validate Users Main Grid Should Display

  Scenario: Validate Add New User with Mandatory Fileds
    When Click on Users Menu
    When Click on Add User button
    Then Enter All Mandatory Fields
    And Click on Save and Exit button in user screen
    Then Verify Success Message

  Scenario: Validate Save and Send Invite to 365
    When Click on Users Menu
    When Click on Add User button
    Then Enter All Mandatory Fields
    And Click on Save and Send Invite to 365 button
    Then Verify Success Message

  Scenario: Validate Add New User With Non Mandatory Fields
    When Click on Users Menu
    When Click on Add User button
    Then Enter Non Mandatory Fields
    And Click on Save and Exit button
    Then Verify Error Message

  Scenario: Valiadate Search bar in Users Main Grid
    When Click on Users Menu
    Then Enter user Name and Search
    Then Validate User Should Display

  Scenario: validate Status Dropdown
    When Click on Users Menu
    Then Click on dropdown and Validate

  Scenario: Validate Footer cancel button
    When Click on Users Menu
    Then Select Checkbox
    Then Click on userCancel button
    Then Validate EditPage shouldnot Visible

  Scenario: Validate Footer Delete button
    When Click on Users Menu
    Then Select Checkbox
    Then Click on UserfooterDelete button
    And Click on Delete CheckBox
    And Click on DeleteYes button
    Then Validate Delete Message Should Display
@Test
  Scenario: Validate Archive button
    When Click on Users Menu
    Then Select Checkbox
    And Click on Archive button
    Then Validate Archive Message

  Scenario: Validate Restore button
    When Click on Users Menu
    Then Select Checkbox
    Then Click on Restore button
    Then Validate Restore Message
