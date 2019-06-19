Feature: Login Feature
  Verify if user is able to Login in to the site

  Scenario: Login as a authenticated user
    Given user is  on homepage
    
    When user click on sign in button 
    And user enters username and Password
    Then user click on login button
    Then success message is displayed
    
    
   
