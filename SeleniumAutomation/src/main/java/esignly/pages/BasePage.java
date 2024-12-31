package esignly.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumUtils;

public abstract class BasePage {

	protected WebDriver driver;
	protected Actions act;
	protected JavascriptExecutor jse;
	protected Alert alert;
	protected SeleniumUtils seleniumUtils;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		seleniumUtils = new SeleniumUtils(driver);

	}

	// reusable selenium methods

	protected WebElement getElement(By by) {

		return driver.findElement(by);
	}

	protected void clickAction(By by) {
		getElement(by).click();
	}

	protected void DoubleClickAction(By by) {
		act = new Actions(driver);
		act.doubleClick(getElement(by)).perform();
	}

	protected void sendText(By by, String text) {
		getElement(by).sendKeys(text);
	}

	protected void selectValueFromDropdown(By ele, String value) {
		WebElement element = getElement(ele);
		Select s = new Select(element);
		s.selectByValue(value);
	}

	protected WebElement waitToVisibleElement(By by, int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;

	}

	protected void waitAndClick(By by, int i) {
		(new WebDriverWait(driver, Duration.ofSeconds(i))).until(ExpectedConditions.elementToBeClickable(by)).click();

	}

	protected void waitAndJavaScriptClick(By by, int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	protected void waitAndActionDoubleClick(By by, int i) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			Actions a = new Actions(driver);
			a.doubleClick(element).perform();
			System.out.println("Element Click");

		} catch (Exception e) {

		}

	}

	protected WebElement waitElementToVisible(By by, int i) {
		WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(i)))
				.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}

	protected void alertAccept() {
		alert = driver.switchTo().alert();
		alert.accept();

	}

	/*
	 * This method wats for the element to be visible and get element text
	 */
	protected String waitAndGetText(By by, int timeOut) {
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

	public void oneChildHandle() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			
			if (!handle.equals(parentWindow)) {
				// Switch to the new window context

				driver.switchTo().window(handle);

			}

		}

	}

	public void switchToFrameByName(By by) {
		driver.switchTo().frame(getElement(by));
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

}
