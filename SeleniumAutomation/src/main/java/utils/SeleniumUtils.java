package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	
	protected WebDriver driver;
	protected Actions act;
	protected JavascriptExecutor jse;
	protected Alert alert;
	protected SeleniumUtils seleniumUtils;
	
	
	public SeleniumUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	// reusable selenium methods
	
	public WebElement getElement(By by) {

		return driver.findElement(by);
	}

	public void clickAction(By by) {
		getElement(by).click();
	}

	public void DoubleClickAction(By by) {
		act = new Actions(driver);
		act.doubleClick(getElement(by)).perform();
	}

	public void sendText(By by, String text) {
		getElement(by).sendKeys(text);
	}

	public void selectValueFromDropdown(By ele, String value) {
		WebElement element = getElement(ele);
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void waitAndClick(By by, int i) {
		(new WebDriverWait(driver, Duration.ofSeconds(i))).until(ExpectedConditions.elementToBeClickable(by)).click();

	}

	public WebElement waitElementToVisible(By by, int i) {
		WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(i)))
				.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}

	public void addRemoveByJavaScriptExecutor() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript(
				"const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
		jse.executeScript("window.scrollBy(0,250)");
	}

	public void alertAccept() {
		alert = driver.switchTo().alert();
		alert.accept();

	}

	/*
	 * This method wats for the element to be visible and get element text
	 */
	public String waitAndGetText(By by, int timeOut) {
		String text = "";
		try {
			WebElement element = waitElementToVisible(by, timeOut);
			text = element.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;

	}

	/*
	 * This method returns element text
	 */
	public String getText(By by) {
		String text = "";
		try {
			text = getElement(by).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;

	}
	
	
	

}
