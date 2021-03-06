Feature: Place Order Guest Checkout

	@GuestCheckout
  Scenario Outline: Order Placement with Guest Checkout
    Given User should able to access OpenCart Application
    When User click Laptops and Notebooks tab
    And User click on Show all Laptops and Notebooks option
    And User select Laptop Type from List
    And User change <DeliveryDate> to future date
    And User click on Add to Cart
    And User click on Items Basket Icon
    And User click on Check Out 
    And User click on Guest Checkout Button and click Continue
    And User enter the Mandatory Fields <FirstName> and <LastName> and <Email> and <Telephone> and <Address> and <City> and <PostalCode> and <Country> and <Region/State>
    And User click Continue Button
    And User <AddComments> under Delivery Method and click Continue Button
    And User check in Terms and Conditions and click Continue Button
    And User click on Confirm Order Button 
    Then Order should Placed Successfully and Log it

    Examples: 
      | FirstName | LastName | Email          | Telephone | Address     | City      | PostalCode | Country | Region/State | DeliveryDate | AddComments     |
      | "wen"     | "ven"    | "nev@test.com" | "2234434" |"LIG Colony" | "Madurai" | "625020"   | "India" | "Tamil Nadu" | "2021-04-22" | "Fast Shipping" |
