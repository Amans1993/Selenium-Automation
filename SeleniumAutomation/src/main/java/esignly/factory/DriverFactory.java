package esignly.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class DriverFactory {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This methods intialize driver
	 * 
	 * @param browser
	 * @return
	 * @return
	 */

	public WebDriver initDriver(String browserName, Boolean incoginito) {

		if (browserName.equalsIgnoreCase("chrome")) {
			if(incoginito) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--incognito");
				chromeOptions.addArguments("--disable-popup-blocking");
				chromeOptions.addArguments("--ignore-certificate-errors");
				tlDriver.set(new ChromeDriver(chromeOptions));
				System.out.println("Test Running in Incognito mode");
			}
			else if(! incoginito) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--ignore-certificate-errors");
				tlDriver.set(new ChromeDriver(chromeOptions));
			}
			else {
				System.out.println("OOPS ! invalid incognito");
			}
		
		} else if (browserName.equalsIgnoreCase("firefox")) {
			tlDriver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("safari")) {
			tlDriver.set(new SafariDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			tlDriver.set(new EdgeDriver());
		} else {
			System.out.println("Please pass the right browser name.." + browserName);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		return getDriver();

	}

	// get the local thread copy of the driver
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}

}
