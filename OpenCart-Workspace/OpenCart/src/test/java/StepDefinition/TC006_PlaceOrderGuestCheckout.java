package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import OpenCart.FunctionalLibrary.DriverActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC006_PlaceOrderGuestCheckout {
	
	DriverActions action = new DriverActions();
	Properties p1, p2, p3, p4, p5, p6 = new Properties();
	
	//Invoke Constructor
	public TC006_PlaceOrderGuestCheckout() throws IOException {
		p1 = action.getPropertyFile("AppLink");
		p2 = action.getPropertyFile("TC006_PlaceOrderGuestCheckout");
	}
	
	@Given("^User should able to access OpenCart Application$")
	public void user_should_able_to_access_OpenCart_Application() throws Throwable {
		action.getBrowser("Chrome");
		action.getWebLink(p1.getProperty("getAppLink"));
	}

	@When("^User click Laptops and Notebooks tab$")
	public void user_click_Laptops_and_Notebooks_tab() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickLaptopsandNotebooks"));
	}

	@When("^User click on Show all Laptops and Notebooks option$")
	public void user_click_on_Show_all_Laptops_and_Notebooks_option() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickShowAll"));
	}

	@When("^User select Laptop Type from List$")
	public void user_select_Laptop_Type_from_List() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("selectLaptop"));
	}

	@When("^User change \"([^\"]*)\" to future date$")
	public void user_change_to_future_date(String DeliveryDate) throws Throwable {
		action.clearTextArea("xpath", p2.getProperty("inputDeliveryDate"));
		action.inputValues("xpath", p2.getProperty("inputDeliveryDate"), DeliveryDate);
	}

	@When("^User click on Add to Cart$")
	public void user_click_on_Add_to_Cart() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickAddtoCart"));
	}
	
	@When("^User click on Items Basket Icon$")
	public void user_click_on_Items_Basket() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickShoppingCart"));
	}

	@When("^User click on Check Out$")
	public void user_click_on_Check_Out() throws Throwable {
		action.ExplicitWait(p2.getProperty("clickCheckout"));
		action.clickWebElement("xpath", p2.getProperty("clickCheckout"));
	}

	@When("^User click on Guest Checkout Button and click Continue$")
	public void user_click_on_Guest_Checkout_Button_and_click_Continue() throws Throwable {
		action.ExplicitWait(p2.getProperty("clickGuestCheckout"));
		action.clickWebElement("xpath", p2.getProperty("clickGuestCheckout"));
		action.clickWebElement("xpath", p2.getProperty("clickGuestContinue"));
	}

	@When("^User enter the Mandatory Fields \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" "
			+ "and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_the_Mandatory_Fields_and_and_and_and_and_and_and_and_and(String FirstName, 
			String LastName, String Email, String Telephone, String Address, String City, String PostalCode, 
			String Country, String RegionState) throws Throwable {
		action.ExplicitWait(p2.getProperty("inputFirstName"));
		action.inputValues("xpath", p2.getProperty("inputFirstName"), FirstName);
		action.inputValues("xpath", p2.getProperty("inputLastName"), LastName);
		action.inputValues("xpath", p2.getProperty("inputEmail"), Email);
		action.inputValues("xpath", p2.getProperty("inputTelephone"), Telephone);
		action.inputValues("xpath", p2.getProperty("inputAddress"), Address);
		action.inputValues("xpath", p2.getProperty("inputCity"), City);
		action.inputValues("xpath", p2.getProperty("inputPostalCode"), PostalCode);
		action.SelList("xpath", p2.getProperty("selectCountry"), Country);
		action.Wait();
		action.SelList("xpath", p2.getProperty("selectRegion/State"), RegionState);
	}

	@When("^User click Continue Button$")
	public void user_click_Continue_Button() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickGuestContinue1"));
	}

	@When("^User \"([^\"]*)\" under Delivery Method and click Continue Button$")
	public void user_under_Delivery_Method_and_click_Continue_Button(String AddComments) throws Throwable {
		action.ExplicitWait(p2.getProperty("inputComment"));
		action.inputValues("xpath", p2.getProperty("inputComment"), AddComments);
	}

	@When("^User check in Terms and Conditions and click Continue Button$")
	public void user_check_in_Terms_and_Conditions_and_click_Continue_Button() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickContinue3"));
		action.ExplicitWait(p2.getProperty("clickTerms"));
		action.clickWebElement("xpath", p2.getProperty("clickTerms"));
		action.clickWebElement("xpath", p2.getProperty("clickContinue4"));
	}

	@When("^User click on Confirm Order Button$")
	public void user_click_on_Confirm_Order_Button() throws Throwable {
		action.ExplicitWait(p2.getProperty("clickConfirmOrder"));
		action.clickWebElement("xpath", p2.getProperty("clickConfirmOrder"));
	}

	@Then("^Order should Placed Successfully and Log it$")
	public void order_should_Placed_Successfully_and_Log_it() throws Throwable {
		action.Wait();
		action.TakeScreenShot("TC006-01-OrderConfirmation");
		action.Quit();
	}
}
