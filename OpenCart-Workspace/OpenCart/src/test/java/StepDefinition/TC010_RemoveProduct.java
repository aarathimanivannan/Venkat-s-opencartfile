package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import OpenCart.FunctionalLibrary.DriverActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC010_RemoveProduct {
	
	DriverActions action = new DriverActions();
	Properties p1, p2, p3, p4, p5, p6 = new Properties();
	
	//Invoke Constructor
	public TC010_RemoveProduct() throws IOException {
		p1 = action.getPropertyFile("AppLink");
		p2 = action.getPropertyFile("TC001_RegisterAccount");
		p3 = action.getPropertyFile("TC003_Login");
		p4 = action.getPropertyFile("LoginCredientials");
		p5 = action.getPropertyFile("TC006_PlaceOrderGuestCheckout");
		p6 = action.getPropertyFile("TC010_RemoveProduct");
	}
	
	@Given("^User has able to access and login to Application with Login Details$")
	public void user_has_able_to_access_and_login_to_Application_with_Login_Details() throws Throwable {
		action.getBrowser("Chrome");
		action.getWebLink(p1.getProperty("getAppLink"));
		action.clickWebElement("xpath", p2.getProperty("clickMyAccount"));
		action.clickWebElement("xpath", p3.getProperty("clickLogin"));
		action.inputValues("xpath", p3.getProperty("inputEmailAddress"), p4.getProperty("EmailAddress"));
		action.inputValues("xpath", p3.getProperty("inputPassword"), p4.getProperty("Password"));
		action.clickWebElement("xpath", p3.getProperty("clickLoginButton"));
	}

	@When("^User click on Laptop & Notebook$")
	public void user_click_on_Laptop_Notebook() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickLaptopsandNotebooks"));
	}

	@When("^User select show all Option$")
	public void user_select_show_all_Option() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickShowAll"));
	}

	@When("^User select the Product and click Add to Cart Button$")
	public void user_select_the_Product_and_click_Add_to_Cart_Button() throws Throwable {
		action.clickWebElement("xpath", p6.getProperty("clickProduct"));
		action.clickWebElement("xpath", p6.getProperty("clickAddtoCart"));
	}

	@When("^User navigate to Shopping cart and click the Shopping Cart$")
	public void user_navigate_to_Shopping_cart_and_click_the_Shopping_Cart() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickShoppingCart"));
	}

	@When("^User remove the item from the cart and click continue$")
	public void user_remove_the_item_from_the_cart_and_click_continue() throws Throwable {
		action.Wait();
		action.TakeScreenShot("TC010-01-BeforeRemoveProduct");
	    action.clickWebElement("xpath", p6.getProperty("clickRemove"));
	    action.Wait();
	    action.TakeScreenShot("TC010-02-AfterProductRemoval");	
	    action.clickWebElement("xpath", p6.getProperty("clickContinue"));
	}

	@Then("^User able to remove the product from cart Successfully$")
	public void user_able_to_remove_the_product_from_cart_Successfully() throws Throwable {
		System.out.println("Product Removed Successfully");
		action.Quit();
	}
}
