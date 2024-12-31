package esignly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyDocumentsPage extends BasePage {

	private final By headingText = By.xpath("//h1");
	private final By fileText = By.xpath("(//h3)[1]");
	private final By docStatus = By.xpath("(//div[@class='template-btn-row grid-btn-row flex-box-new']//span[2])[1]");
	private final By signTextLink = By.xpath("(//a[@class='sign-text'])[1]");
	private final By closeIcon = By.xpath("(//a[@class='grid-delete icon-bg'])[1]");
	private final By delPopupHeader = By.id("confirmation_label");
	private final By deleteMsg = By.id("confirmMessage");
	private final By okBtn = By.id("confirmYes");
	private final By delMsgPopupLabel =By.xpath("//h4[text()='Message']"); 
	private final By delSuccessMsg = By.id("dialogMessage");
	private final By okBtn2 = By.id("aRedirectUrl");

	public MyDocumentsPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyMyDocumentIsDisplayed(String pageHeading) {
		String text = getElement(headingText).getText();
		if (text.contains(pageHeading)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyFileNameAndStatus(String fname, String status) throws InterruptedException {
		Thread.sleep(10000);
		String fileName = getElement(fileText).getText();
		if (fileName.equals(fname)) {
			String stats = getElement(docStatus).getText();
			if (stats.equals(status)) {
				return true;
			}
		}
		return false;
	}

	public void clickOnSignDocLink(String sdoc) {
		String text = getElement(signTextLink).getText();
		if (text.equals(sdoc)) {
			clickAction(signTextLink);
		}
	}

	public void clickCloseIconForDelete() {
		waitAndClick(closeIcon, 20);;

	}

	public boolean verifyDeleteMsg(String expMsg) {
		boolean ele = getElement(delPopupHeader).isDisplayed();
		if (ele == true) {
			String actMsg = getText(deleteMsg);
			System.out.println(actMsg);
			if (actMsg.equals(expMsg)) {
				clickAction(okBtn);
				return true;
			}
		}

		return false;
	}
	
	public boolean verifySuccesfullyDeleteMsg(String expMsg) throws InterruptedException {
		boolean ele = getElement(delMsgPopupLabel).isDisplayed();
		if (ele == true) {
			String actMsg = getText(delSuccessMsg);
			System.out.println(actMsg);
			if (actMsg.equals(expMsg)) {
				Thread.sleep(5000);
				waitAndClick(okBtn2, 5);
				return true;
			}
		}

		return false;
	}
}
