package PageManager;

import org.openqa.selenium.WebDriver;

public class AppLib {

	private WebDriver driver;
	private PageLib page;

	public AppLib(WebDriver driver) {

		this.driver = driver;
		page = new PageLib(this.driver);

	}
	
	public PageLib page() {
		return page;
	}

}
