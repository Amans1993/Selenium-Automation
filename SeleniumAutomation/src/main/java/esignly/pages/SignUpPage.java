package esignly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

	private final By freeTrialTxt = By.xpath("//h1[contains(text(),'Start your 30 days free trial')]");

	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyFreeTrialSignupText() {
		String text = getElement(freeTrialTxt).getText();

		if (text.contains("Start your 30 days free trial")) {

			return true;
		} else {
			return false;
		}
	}

}
