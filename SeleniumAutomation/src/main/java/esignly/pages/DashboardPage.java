package esignly.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends BasePage {

	private final By dashboardEle = By.xpath("//h1[@class='page-title']");
	private final By startSigningLink = By.linkText("Start Signing");
	private final By myDocumentLink = By.linkText("My Documents");


	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyDashBoardIsVisible() {
		String text = getElement(dashboardEle).getText();

		if (text.contains("Dashboard")) {

			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickOnStartSigningLink() {
		clickAction(startSigningLink);
	}
    
	public void clickOnMyDocumentLink() {
		clickAction(myDocumentLink);
	}
	
}
