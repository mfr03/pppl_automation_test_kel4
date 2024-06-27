Feature: User register an account
  Scenario: User sucessfully make an account that fits all the requirement
    Given User is on the register page
    When User submits their account credentials
    Then User should be redirected to login page

  Scenario: User makes an account that has been already registered
    Given User is on the register page
    When User submits already registered account
    Then User should be redirected to register page with error message