Feature: Verify Title

  @VerifyTitle
  Scenario: Verify Title after User Login
    Given User able to access Application
    When User Login with EmailAddress and Password
    Then User able to verify the Page Title successfully