Feature: Login into Capium Application
 
  Scenario: 365 User login
    Given Launch the browser
    And User need to enter the Application Url
    And Click on Capium365 Client login
    When User Enter username
    Then User Click on next button
    And User enter OTP
    And Click on verify account
    And Redirect to365 client
    
    @Login
    Scenario: Client Portal user login
    Given Launch the browser
    And User need to enter the Application Url
    And Click on Accountant login
    When Enter username and password 
    And click on Login Button
    Then Navigate to capium365 module
    