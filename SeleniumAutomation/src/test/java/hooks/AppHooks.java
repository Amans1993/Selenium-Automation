package hooks;

import org.openqa.selenium.WebDriver;

import esignly.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.AppConstant;
import utils.ConfigLoader;

public class AppHooks {

	protected static WebDriver driver;
	protected DriverFactory driverFactory;
	
	@Before(order = 0)
	public void beforeAll() {
		ConfigLoader.readMasterFile(AppConstant.GET_MASTER_CONFIG_FILE_PATH());
		ConfigLoader.readConfigFile();
	}

	@Before(order = 1)
	public void setUp() {
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(ConfigLoader.getConfigValue("browser"),
				Boolean.parseBoolean(ConfigLoader.getConfigValue("incognito")));
		getURL();

	}

	@After
//	public void tearDown() {
//
//		if (driver != null) {
//			driver.quit();
//		}
//
//	}

	private void getURL() {
		driver.get(ConfigLoader.getConfigValue("url"));
	}

	public WebDriver getWebDriver() {
		return driver;
	}

}
