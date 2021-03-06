package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;

import OpenCart.FunctionalLibrary.DriverActions;
import OpenCart.Logs.Log;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC002_RegisterAccountFailure {
	
	DriverActions action = new DriverActions();
	Properties p1, p2 = new Properties();
	
	//Invoke Constructor
	public TC002_RegisterAccountFailure() throws IOException {
		p1 = action.getPropertyFile("AppLink");
		p2 = action.getPropertyFile("TC001_RegisterAccount");
		DOMConfigurator.configure("Logger\\Log4j.xml");
	}
	
	
	@Given("^User able to access Application Link$")
	public void user_able_to_access_Application_Link() throws Throwable {
		action.getBrowser("Chrome");
		action.getWebLink(p1.getProperty("getAppLink"));
	}

	@When("^User should click My Account and Register$")
	public void user_should_click_My_Account_and_Register() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickMyAccount"));
		action.clickWebElement("xpath", p2.getProperty("clickRegister"));
	}

	@When("^User should enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" "
			+ "and \"([^\"]*)\" and \"([^\"]*)\" by Missing any Required Field$")
	public void user_should_enter_and_and_and_and_and_by_Missing_any_Required_Field(String FirstName, 
			String LastName, String Email, String Telephone, String Password, String PasswordConfirm) 
					throws Throwable {
		action.inputValues("xpath", p2.getProperty("inputFirstName"), FirstName);
		action.inputValues("xpath", p2.getProperty("inputLastName"), LastName);
		action.inputValues("xpath", p2.getProperty("inputEmail"), Email);
		action.inputValues("xpath", p2.getProperty("inputTelephone"), Telephone);
		action.inputValues("xpath", p2.getProperty("inputPassword"), Password);
		action.inputValues("xpath", p2.getProperty("inputPasswordConfirm"), PasswordConfirm);
	}

	@When("^User should check Privacy Policy and click Continue$")
	public void user_should_check_Privacy_Policy_and_click_Continue() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickPrivacyPolicy"));
		action.clickWebElement("xpath", p2.getProperty("clickContinue"));
	}

	@Then("^User should able to capture the Error Message$")
	public void user_should_able_to_capture_the_Error_Message() throws Throwable {
		String getErrorMessage = action.getStoreValue("xpath", p2.getProperty("getErrorMessage"));
		Log.warn(getErrorMessage);
		action.TakeScreenShot("TC002-01-ErrorMessage");
		action.Quit();
	}
}
