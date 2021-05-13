Feature: Select Desktop

  @SelectDesktop
  Scenario: Select Desktop
    Given User able to Login the Application
    When User mouseover on desktop
    And User click Mac from the dropdown
    And User click Add to Cart
    Then User should able to log Success Message successfully
