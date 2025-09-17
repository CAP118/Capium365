Feature: Validate Imports Tab

 Background: Login into Capium Application
    Given Launch the browser
    And User need to enter the Application Url
    And Click on Accountant login
    When Enter username and password
    And click on Login Button
    Then Navigate to capium365 module
    
      Scenario: Validate Clients  Imports
    When Click on Imports Menu
    Then Select Client CheckBox
    Then Import Excel File From Folder
    Then Validate Success List
    
    Scenario: Validate Import Client Should Display in Client Main Grid
    When Click on Imports Menu
    Then Select Client CheckBox
    Then Import Excel File From Folder
    And Click on Save and Next button
    Then Validate Client Imported
     
     
    Scenario: Validate Duplicate ImportClient
    When Click on Imports Menu
    Then Select Client CheckBox  
    Then Import Excel File From Folder
    And Click on ClientNext button
    Then Validate Duplicate Client Imported
    
    
    Scenario: Validate Users  Imports
    When Click on Imports Menu
    Then Select Users CheckBox
    Then Import Excel File From Folder for user
    Then Validate userSuccess List
    
    Scenario: Validate Import User Should Display in Client Main Grid
    When Click on Imports Menu
    Then Select Client CheckBox
    Then Import Excel File From Folder
    And Click on Save and Next button
    Then Validate Client Imported
     
     
    Scenario: Validate Duplicate ImportClient
    When Click on Imports Menu
    Then Select Client CheckBox
    Then Import Excel File From Folder
    And Click on ClientNext button
    Then Validate Duplicate Client Imported