Feature: User is Looking at Realtime Chart

  Background:
    Given User is on login page
    When User submits their registered account
    Then User should be redirected to dashboard page without quitting

  Scenario: User is Looking at specific drill's realtime data
    Given User is on dashboard page
    When User chose their drill
    Then User should be redirected shown that drill realtime data
