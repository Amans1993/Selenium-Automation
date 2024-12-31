package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigLoader;

public class LoginSteps extends MasterSteps {
	
	public LoginSteps() {
		super();
	}

	@Given("user is at login page")
	public void user_is_at_login_page() {
		Boolean isLoginPageVisible =  appLib.page().loginPage().verifyLoginPage();
		Assert.assertTrue(isLoginPageVisible);
		
	}

	@When("user enter valid username")
	public void user_enter_valid_username() {
		appLib.page().loginPage().enterUsername(ConfigLoader.getConfigValue("username"));
	}

	@And("enter valid password")
	public void enter_valid_password() {
	  appLib.page().loginPage().enterPassword(ConfigLoader.getConfigValue("password"));
	}

	@When("click login button")
	public void click_login_button() {
		appLib.page().loginPage().clickLoginBtn();
		
	}

	@Then("user should login to the application successfully")
	public void user_should_login_to_the_application_successfully() {
		Boolean isDasboardTextVisible = appLib.page().dashboardPage().verifyDashBoardIsVisible();
		Assert.assertTrue(isDasboardTextVisible);
		
	}
	
	@When("user click at signup link")
	public void user_click_at_signup_link() {
		appLib.page().loginPage().clickSignUpLink();
	}

	@Then("user should be at signup page")
	public void user_should_be_at_signup_page() {
		boolean isFreeTrialTextVisible =appLib.page().signUpPage().verifyFreeTrialSignupText();
		Assert.assertTrue(isFreeTrialTextVisible);
	}
	
	@When("user click at Forgot Password Link")
	public void user_click_at_forgot_password_link() {
		appLib.page().loginPage().clickForgotPassLink();
	}

	@Then("user should be at Forgot Password Page")
	public void user_should_be_at_forgot_password_page() {
		Boolean isForgotPassTextVisible = appLib.page().forgotPasswordPage().forgotPasswordIsVisible();
		Assert.assertTrue(isForgotPassTextVisible);
	}
	
	@When("user enter invalid username {string}")
	public void user_enter_invalid_username(String username) {
		appLib.page().loginPage().enterUsername(username);
	}

	@When("enter invalid password {string}")
	public void enter_invalid_password(String password) {
		appLib.page().loginPage().enterPassword(password);
	}

	@Then("user should be able to see {string} message")
	public void user_should_be_able_to_see_message(String string) {
		boolean isInvalidLoginText = appLib.page().loginPage().verifyInvalidLoginText();
		Assert.assertTrue(isInvalidLoginText);
	}

}
