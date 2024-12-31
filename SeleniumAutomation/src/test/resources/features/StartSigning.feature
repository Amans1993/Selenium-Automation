Feature: Start Signing Functionality

  Background: User is Logged in and move to Start Signing Page
    Given user is at login page
    When user enter valid username
    And enter valid password
    And click login button
    And click to Start Signing Link
    Then user should redirect to start signing page

  Scenario: Validate that Start Signing Functionality for Just me with Add a Title and Custom Message
    Given user is at start signing page
    And user is click on template directory
    When user is able to select the template "Automation01"
    And user is click on next button
    And user enter the email and first name"CIS QA" for SDET 1 
    And user is click on second next button
    And user click on third next button after uploading the file
    And user click on submit Button
    And click on ok button if proceed popup is displayed
    Then message popup should be displayed with message "Signing request created successfully."
    And click on ok Button in message popup
    Then verify that page is redirected to "My Documents" page
    And  verify "Automation01" file is displayed with "Awaiting Response" Message
    And click on "Sign Document" Link for Open the File to Signature
    And page is redirected to document Page for Signature
    And Sign the Document at Signature Place
    Then Click on I agree Button and Verify "Signing Process Completed.." Message
    And  verify that page is redirected to "Dashboard" page
    And user click on "My Documents" Link
    Then verify "Automation01" file is displayed with "Completed" Message
    And click on close icon for delete
    Then Verify that a popup with message "Are you sure want to Delete ? Once deleted it will no longer access" is displayed and click ok Button
    Then Verify that a popup with message "Assignment request deleted successfully" is displayed
    
  Scenario: Validate that Start Signing Functionality for Just me with Add security document as Personal Question
    Given user is at start signing page
    And user is click on template directory
    When user is able to select the template "Automation01"
    And user is click on next button
    And user enter the email and first name"CIS QA" for SDET 1 
    And user is click on second next button
    And user click on third next button after uploading the file 
    And user set the security question "Tech Name" and set the answer "Automation Tester"
    And user click on submit Button
    And click on ok button if proceed popup is displayed
    Then message popup should be displayed with message "Signing request created successfully."
    And click on ok Button in message popup
    Then verify that page is redirected to "My Documents" page
    And  verify "Automation01" file is displayed with "Awaiting Response" Message
    And click on "Sign Document" Link for Open the File to Signature
    And user enter the answer "Automation Tester" of Security question
    And Sign the Document at Signature Place
    Then Click on I agree Button and Verify "Signing Process Completed.." Message
    And  verify that page is redirected to "Dashboard" page
    And user click on "My Documents" Link
    Then verify "Automation01" file is displayed with "Completed" Message
    And click on close icon for delete
    Then Verify that a popup with message "Are you sure want to Delete ? Once deleted it will no longer access" is displayed and click ok Button
    Then Verify that a popup with message "Assignment request deleted successfully" is displayed
    
    
