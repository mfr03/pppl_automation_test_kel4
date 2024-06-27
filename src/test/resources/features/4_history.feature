Feature: User is Looking at History Chart

  Background:
    Given User is on login page
    When User submits their registered account
    Then User should be redirected to dashboard page without quitting

  Scenario: User is Looking at specific drill's historical data
    Given User is on history page
    When User chose their chosen drill
    When User enters range for the historical data
    Then User should be shown the historical data