package esignly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	// Page locator
	private final By email = By.xpath("//input[@id='LoginForm_email']");
	private final By password = By.xpath("//input[@id='LoginForm_password']");
	private final By loginButton = By.xpath("//button[@type='submit' and text()='Log In']");
	private final By loginHeading = By.xpath("//*[text()='Log in to Esignly']");
	private final By signupLink = By.xpath("//p/a[text()='Sign Up'] ");
	private final By forgotPasswordLink = By.xpath("//a[text()='Forgot Password']");
	private final By invalidLoginMsg = By.xpath("//form[@id='signin-form']//span[text()='Invalid Email id or Password.']");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public void enterUsername(String uname) {
		sendText(email, uname);

	}

	public void enterPassword(String pwd) {
		sendText(password, pwd);

	}

	public void clickLoginBtn() {
		clickAction(loginButton);
	}

	public void login(String uname, String pwd) {
		sendText(email, uname);
		sendText(password, pwd);
		clickAction(loginButton);

	}

	public boolean verifyLoginPage() {

		if (getElement(loginHeading).isDisplayed()) {

			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifyInvalidLoginText() {

		if (getElement(invalidLoginMsg).isDisplayed()) {

			return true;
		} else {
			return false;
		}
	}
	
	public void clickSignUpLink() {
		clickAction(signupLink);
	}
	
	public void clickForgotPassLink() {
		clickAction(forgotPasswordLink);
	}

}
