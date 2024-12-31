package esignly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

	private final By forgotPasswordText = By.xpath("//h1[text()='FORGOT PASSWORD']");

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	public boolean forgotPasswordIsVisible() {
		String text = getElement(forgotPasswordText).getText();

		if (text.contains("FORGOT PASSWORD")) {

			return true;
		} else {
			return false;
		}
	}

}
