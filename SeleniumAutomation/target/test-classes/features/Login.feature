Feature: eSignly Login, Signup and Forgot Password Functionality

  Scenario: Verify valid login
    Given user is at login page
    When user enter valid username
    And enter valid password
    And click login button
    Then user should login to the application successfully
    
  Scenario: Verify Invalid login
    Given user is at login page
    When user enter invalid username "dfndjfn@yopmail.com"
    And enter invalid password "GJKqwe@123"   
    And click login button
    Then user should be able to see "Invalid Email id or Password" message

  Scenario: Verify Signup Page
    Given user is at login page
    When user click at signup link
    Then user should be at signup page

  Scenario: Verify Forgot Password Page
    Given user is at login page
    When user click at Forgot Password Link
    Then user should be at Forgot Password Page
