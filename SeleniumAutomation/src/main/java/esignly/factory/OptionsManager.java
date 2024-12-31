package esignly.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;



public class OptionsManager {
 
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println(".....Running the test in Headless mode.......");
			co.addArguments("--headless=chrome");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			System.out.println(".....Running the test in Incognito mode.......");
			co.addArguments("--incognito");
		}
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println(".....Running the test in Headless mode.......");
			fo.addArguments("--headles");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			System.out.println(".....Running the test in Incognito mode.......");
			fo.addArguments("--incognito");
		}
		return fo;
	}

}
