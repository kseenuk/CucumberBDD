Feature: Send the Message using the ContactUS 
   User can sent the complaints or info using this screen

Scenario:  Provide all the required fields 
    Given  User navigates to the Contact Us screen in Webdriver university
      And  User enters the First Name
      And  User enters the Last Name
      And  User enters the email address 
      And  User enters the comments  
      When User clicks on submit button
      Then User should be taken to Thanks screen 