Feature: User Login to Dashboard
  Scenario: Successful login with valid credentials
    Given User is on login page
    When User submits their registered account
    Then User should be redirected to dashboard page

  Scenario: Failed login with invalid credentials
    Given User is on login page
    When User submits unregistered account with invalid credentials
    Then User should be redirected to login page with error message
