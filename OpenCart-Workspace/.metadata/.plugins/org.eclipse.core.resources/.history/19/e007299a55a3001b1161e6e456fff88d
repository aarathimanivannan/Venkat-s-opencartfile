Feature: Checking Product Availability

  @ProductAvailability
  Scenario Outline: Checking for Product Availability
    Given User able to access and login into application
    When User enter <ProductName> in Search option
    And User click on Search button
    And User select the Product
    And User enter the <Quantity>
    And User click on Add to Cart buttion
    And User select item cart on the Right Corner
    And User click on Checkout Option
    Then User able to see the Error Message successfully

    Examples: 
      | ProductName | Quantity |
      | "iphone"    | "2"      |
