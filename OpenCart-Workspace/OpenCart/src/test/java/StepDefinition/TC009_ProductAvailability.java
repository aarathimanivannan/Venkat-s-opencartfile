package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import OpenCart.FunctionalLibrary.DriverActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC009_ProductAvailability {
	
	DriverActions action = new DriverActions();
	Properties p1, p2, p3, p4, p5 = new Properties();
	
	//Invoke Constructor
	public TC009_ProductAvailability() throws IOException {
		p1 = action.getPropertyFile("AppLink");
		p2 = action.getPropertyFile("TC001_RegisterAccount");
		p3 = action.getPropertyFile("TC003_Login");
		p4 = action.getPropertyFile("LoginCredientials");
		p5 = action.getPropertyFile("TC009_ProductAvailability");
	}
	
	
	@Given("^User able to access and login into application$")
	public void user_able_to_access_and_login_into_application() throws Throwable {
		action.getBrowser("Chrome");
		action.getWebLink(p1.getProperty("getAppLink"));
		action.clickWebElement("xpath", p2.getProperty("clickMyAccount"));
		action.clickWebElement("xpath", p3.getProperty("clickLogin"));
		action.inputValues("xpath", p3.getProperty("inputEmailAddress"), p4.getProperty("EmailAddress"));
		action.inputValues("xpath", p3.getProperty("inputPassword"), p4.getProperty("Password"));
		action.clickWebElement("xpath", p3.getProperty("clickLoginButton"));
	}

	@When("^User enter \"([^\"]*)\" in Search option$")
	public void user_enter_in_Search_option(String ProductName) throws Throwable {
		action.inputValues("xpath", p5.getProperty("inputSearch"), ProductName);
	}

	@When("^User click on Search button$")
	public void user_click_on_Search_button() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickSearchButton"));
	}

	@When("^User select the Product$")
	public void user_select_the_Product() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("selectProduct"));
	}

	@When("^User enter the \"([^\"]*)\"$")
	public void user_enter_the(String Quantity) throws Throwable {
		action.clearTextArea("xpath", p5.getProperty("inputQuantity"));
		action.inputValues("xpath", p5.getProperty("inputQuantity"), Quantity);
	}

	@When("^User click on Add to Cart buttion$")
	public void user_click_on_Add_to_Cart_buttion() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickAddtoCart"));
	}

	@When("^User select item cart on the Right Corner$")
	public void user_select_item_cart_on_the_Right_Corner() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickItemCart"));
	}

	@When("^User click on Checkout Option$")
	public void user_click_on_Checkout_Option() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickCheckout"));
	}

	@Then("^User able to see the Error Message successfully$")
	public void user_able_to_see_the_Error_Message_successfully() throws Throwable {
		action.Wait();
		action.TakeScreenShot("TC009-01-ErrorMessage");
		action.Quit();
	}

}
