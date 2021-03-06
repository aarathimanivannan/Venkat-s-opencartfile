Feature: Place Order with RegisterAccount Checkout

  @RegisterAccountCheckout
  Scenario Outline: Order Placement with RegisterAccount Checkout
    Given User should able to Login with User Credentials
    When User click Laptops and Notebooks
    And User click on Show all Laptops and Notebooks
    And User select Laptop Type
    And User change <DeliveryDate> to future
    And User click on Add to Cart Button
    And User click on Items Basket
    And User click on Check Out Button
    And User click on Register Account Checkout Button and click Continue
    And User enter the Mandatory Fields <FirstName> and <LastName> and <Email> and <Telephone> and <Password> and <ConfirmPassword> and <Address> and <City> and <PostalCode> and <Country> and <Region/State>
    And User click on Privacy Policy and click Continue
    And User <Addcomments> under Delivery Method and click Continue
    And User check in Terms and Conditions and click Continue
    And User click on Confirm Order 
    Then Order should Placed Successfully

    Examples: 
      | FirstName | LastName | Email          | Telephone | Password   | ConfirmPassword | Address      | City      | PostalCode | Country | Region/State | DeliveryDate | Addcomments     |
      | "get"     | "ven"    | "teg@test.com" | "2234434" | "Test@123" | "Test@123"      | "LIG Colony" | "Madurai" | "625020"   | "India" | "Tamil Nadu" | "2021-04-22" | "Fast Shipping" |
