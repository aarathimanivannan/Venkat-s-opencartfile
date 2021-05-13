Feature: Application Login

  @ApplicationLogin
  Scenario: Application Login
    Given User should able to access the Application Link
    When User click My Account and Login
    And User enter EmailAddress and Password
    And User click on Login Button
    Then User should able to Login successfully