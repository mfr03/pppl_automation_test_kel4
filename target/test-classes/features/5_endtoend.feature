Feature: End to End Feature
  Scenario: End to End

    Given User is on the register page
    When User submits their account credentials
    Then User should be redirected to login page without quitting

    Given User is on login page
    When User submits their registered account
    Then User should be redirected to dashboard page without quitting

    Given User is on dashboard page
    When User chose their drill
    Then User should be redirected shown that drill realtime data

