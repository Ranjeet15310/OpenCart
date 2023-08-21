Feature: Login with Valid Credentials

@sanity
  Scenario: Successful Login with Valid Credentials
    Given User Launch browser
    And opens URL "http://localhost/opencartdemo/"
    When User navigate to MyAccount menu
    And click on Login
    And User enters Email as "testdemo@123gmail.com" and Password as "Test@123"
    And Click on Login button
    Then User navigates to MyAccount Page
    
 @regression @sanity
  Scenario:Login with inValid Credentials
    Given User Launch browser
    And opens URL "http://localhost/opencartdemo/"
    When User navigate to MyAccount menu
    And click on Login
    And User enters Email as "testdemo@123gmail.com" and Password as "Testd@123"
    And Click on Login button
    Then User navigates to MyAccount Page   
