package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import OpenCart.FunctionalLibrary.DriverActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC004_VerifyTitle {
	
	
	DriverActions action = new DriverActions();
	Properties p1, p2, p3, p4, p5 = new Properties();
	
	//Invoke Constructor
	public TC004_VerifyTitle() throws IOException {
		p1 = action.getPropertyFile("AppLink");
		p2 = action.getPropertyFile("TC001_RegisterAccount");
		p3 = action.getPropertyFile("TC003_Login");
		p4 = action.getPropertyFile("LoginCredientials");
		p5 = action.getPropertyFile("TC004_VerifyTitle");
	}
	
	@Given("^User able to access Application$")
	public void user_able_to_access_Application() throws Throwable {
		action.getBrowser("Chrome");
		action.getWebLink(p1.getProperty("getAppLink"));
	}

	@When("^User Login with EmailAddress and Password$")
	public void user_Login_with_EmailAddress_and_Password() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickMyAccount"));
		action.clickWebElement("xpath", p3.getProperty("clickLogin"));
		action.inputValues("xpath", p3.getProperty("inputEmailAddress"), p4.getProperty("EmailAddress"));
		action.inputValues("xpath", p3.getProperty("inputPassword"), p4.getProperty("Password"));
		action.clickWebElement("xpath", p3.getProperty("clickLoginButton"));
	}

	@Then("^User able to verify the Page Title successfully$")
	public void user_able_to_verify_the_Page_Title_successfully() throws Throwable {
		action.getWindowTitle(p5.getProperty("TitleName"));
		action.Quit();
	}
}
