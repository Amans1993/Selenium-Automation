package esignly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartSigningPage extends BasePage {
	
	private final By headingText = By.xpath("//h1");
	private final By templateDirectoryEle = By.xpath("//p[text()='Template Directory']");
	private final By templateNameSearchField = By.id("searchTitleTemplate_CS");
	private final By chooseTemplateHeading = By.xpath("(//h4[text()='Choose Template'])[1]");
	private final By nextButton = By.xpath("//a[@class='next-btn btn']");
	private final By nextButton2 = By.xpath("(//a[@class='next-btn btn'])[2]");
	private final By nextButton3 = By.xpath("(//a[@class='next-btn btn'])[3]");
	private final By fNameField = By.xpath("//input[@id='recep_txt_name_6143']");
	private final By emailField = By.xpath("//input[@id='recep_txt_email_6143']");
	private final By uploadedFile = By.xpath("//img[@id='doc_img_0']");
	private final By submitBtn = By.xpath("//a[@class='submit-btn btn btn_save_assignment ']");
	private final By proceedPopupHeading = By.xpath("//h4[@id='confirmation_label']");
	private final By okBtnOfProceedPopup = By.xpath("//input[@id='confirmYes']");
	private final By msgPopupHeading = By.xpath("//h4[text()='Message']");
	private final By msgPopupTxt = By.xpath("//div[@id='dialogMessage']");
	private final By okBtnMsgPopup = By.xpath("//a[@id='aRedirectUrl']");
	private final By addSecuritytoDocLink = By.id("add_security");
	private final By radioBtnPQuest = By.xpath("//label[@for='security2']");
	private final By quesField = By.id("q_box_1");
	private final By ansField = By.id("a_box_1");
	//private final By pvtMsgLink = By.xpath("//li[@class='send_private_message ']");
	

	public StartSigningPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void setSecurityQuesAndAns(String ques, String ans)  {
		waitAndClick(addSecuritytoDocLink, 5);
		waitAndJavaScriptClick(radioBtnPQuest, 10);
		sendText(quesField, ques);
		sendText(ansField, ans);
	}
	
	public boolean verifyStartSigningIsDisplayed() {
		String text = getElement(headingText).getText();
		System.out.println(text);
		if(text.contains("Start Signing")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickOnTemplateDirectory() throws InterruptedException {
		Thread.sleep(5000);
		waitAndActionDoubleClick(templateDirectoryEle,5);
	}
	
	public void selectTemplate(String templateName) throws InterruptedException {
		waitElementToVisible(chooseTemplateHeading, 10);
		sendText(templateNameSearchField, templateName);
		Thread.sleep(5000);
		waitAndActionDoubleClick(By.xpath("//h3[@id='assignname']"),5);
	}
	public void clickOnNextButton() {
          waitAndClick(nextButton, 5);
	}
	
	public void clickOnSecondNextButton() {
        waitAndClick(nextButton2, 5);
	}
 
	public void enterDetailsForSingleUser(String username, String email) throws InterruptedException {
		sendText(fNameField, username);
		sendText(emailField, email);
		Thread.sleep(5000);
	}
	
	public void clickOnThirdNxtBtnAftrFileUpload() {
		waitToVisibleElement(uploadedFile, 20);
		Boolean ele =getElement(uploadedFile).isDisplayed();
		if(ele == true) {
			waitAndClick(nextButton3, 10);
		}
	}
	public void clickOnSubmitBtn() {
		waitAndClick(submitBtn, 5);
	}
	
	public void clickOnOkBtnInProceedTab() {
		waitToVisibleElement(proceedPopupHeading, 10);
		Boolean ele =getElement(proceedPopupHeading).isDisplayed();
		if(ele == true) {
			waitAndClick(okBtnOfProceedPopup,5);
		}
	}
	
	public boolean verifyMessagePopup() {
		waitToVisibleElement(msgPopupHeading, 10);
		Boolean ele =getElement(msgPopupHeading).isDisplayed();
		if (ele == true) {
			String txt = getElement(msgPopupTxt).getText();
			if (txt.equals("Signing request created successfully.")){
				return true;
			}
			
		}
		return false;
		
	}
	
	public void clickOkBtn() {
		waitAndClick(okBtnMsgPopup,5);
	}
	
	
	 
}
