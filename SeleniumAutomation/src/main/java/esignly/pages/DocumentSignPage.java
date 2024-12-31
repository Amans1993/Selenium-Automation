package esignly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocumentSignPage extends BasePage{
	
	private final By signBox = By.xpath("//p[@title='Click to sign']");
	private final By fileNameText = By.xpath("//h4");
	private final By insertSignBtn = By.xpath("//button[@id='insert_signature']");
	private final By iAgreeBtn = By.id("iAgreeButton");
	private final By signCompMsg = By.xpath("//div[@class='bootbox-body']");
	private final By iframe  = By.xpath("//iframe[@class='cboxIframe']");
	private final By okBtn = By.xpath("//button[@class='btn btn-primary']");
	private final By ansField = By.id("a1");
	private final By procBtn = By.id("btn-proceed");

	public DocumentSignPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void movingToDocPage() throws InterruptedException {
		oneChildHandle();
		Thread.sleep(10000);
		String text = getText(fileNameText);
		System.out.println(text);
	}
	
	public void answerSecurityQues(String answer) throws InterruptedException {
		oneChildHandle();
		sendText(ansField, answer);
		Thread.sleep(2000);
		clickAction(procBtn);
		Thread.sleep(5000);
		
	}

	public void signDocument() throws InterruptedException  {
		Thread.sleep(20000);
		waitAndJavaScriptClick(signBox, 10);
		switchToFrameByName(iframe);
		waitAndClick(insertSignBtn, 20);
		oneChildHandle();
		
	}
	
	public boolean verifyMessageByclickOnIAgreeBtn(String expectedMsg) {
		oneChildHandle();
		waitAndJavaScriptClick(iAgreeBtn, 10);
		String actualMsg = waitAndGetText(signCompMsg, 20);
		System.out.println(actualMsg);
		if(actualMsg.equals(expectedMsg)) {
			clickAction(okBtn);
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	 
}
