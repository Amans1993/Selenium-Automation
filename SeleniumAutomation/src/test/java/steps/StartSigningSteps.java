package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigLoader;

public class StartSigningSteps extends MasterSteps {

	@Given("user is at start signing page")
	public void user_is_at_start_signing_page() {
		Boolean isStartSigningDisplayed = appLib.page().startSigningPage().verifyStartSigningIsDisplayed();
		Assert.assertTrue(isStartSigningDisplayed);
	}

	@When("click to Start Signing Link")
	public void click_to_start_signing_link() {
		appLib.page().dashboardPage().clickOnStartSigningLink();
	}

	@Then("user should redirect to start signing page")
	public void user_should_redirect_to_start_signing_page() {
		Boolean isStartSigningDisplayed = appLib.page().startSigningPage().verifyStartSigningIsDisplayed();
		Assert.assertTrue(isStartSigningDisplayed);
	}

	@Given("user is click on template directory")
	public void user_is_click_on_template_directory() throws InterruptedException {
		appLib.page().startSigningPage().clickOnTemplateDirectory();

	}

	@And("user is able to select the template {string}")
	public void user_is_able_to_select_the_template(String templateName) throws InterruptedException {
		appLib.page().startSigningPage().selectTemplate(templateName);

	}

	@And("user is click on next button")
	public void user_is_click_on_next_button() {
		appLib.page().startSigningPage().clickOnNextButton();

	}

	@And("user enter the email and first name{string} for SDET 1")
	public void user_enter_the_email_and_first_name_for_SDET_1(String uname) throws InterruptedException {
		appLib.page().startSigningPage().enterDetailsForSingleUser(uname, ConfigLoader.getConfigValue("username"));

	}

	@And("user is click on second next button")
	public void user_is_click_on_second_next_button() {
		appLib.page().startSigningPage().clickOnSecondNextButton();

	}
	@And("user click on third next button after uploading the file")
	public void user_click_on_third_next_button_after_uploading_the_file() {
	    appLib.page().startSigningPage().clickOnThirdNxtBtnAftrFileUpload();
	}
	
	@And("user click on submit Button")
	public void user_click_on_submit_button() {
	   appLib.page().startSigningPage().clickOnSubmitBtn();
	}
	@And("click on ok button if proceed popup is displayed")
	public void click_on_ok_button_if_proceed_popup_is_displayed() {
		appLib.page().startSigningPage().clickOnOkBtnInProceedTab();
	}
	
	@Then("message popup should be displayed with message {string}")
	public void message_popup_should_be_displayed_with_message(String string) {
		Boolean isMsgPopUpDisplayedWithMsg = appLib.page().startSigningPage().verifyMessagePopup();
		Assert.assertTrue(isMsgPopUpDisplayedWithMsg);
	}
	@And("click on ok Button in message popup")
	public void click_on_ok_button_in_message_popup() {
		appLib.page().startSigningPage().clickOkBtn();
	}
	
	@Then("verify that page is redirected to {string} page")
	public void verify_that_page_is_redirected_to_page(String string) {
		Boolean isPageHeadingDisplayed = appLib.page().myDocumentsPage().verifyMyDocumentIsDisplayed(string);
		Assert.assertTrue(isPageHeadingDisplayed);
	}

	@Then("verify {string} file is displayed with {string} Message")
	public void verify_file_is_displayed_with_message(String string, String string2) throws InterruptedException {
		Boolean isFileDisplayedWithStatus = appLib.page().myDocumentsPage().verifyFileNameAndStatus(string, string2);
		Assert.assertTrue(isFileDisplayedWithStatus);
	}
	
	@Then("click on {string} Link for Open the File to Signature")
	public void click_on_link_for_open_the_file_to_signature(String string) {
		appLib.page().myDocumentsPage().clickOnSignDocLink(string);
	}

	@Then("page is redirected to document Page for Signature")
	public void page_is_redirected_to_document_page_for_signature() throws InterruptedException {
		appLib.page().documentSignPage().movingToDocPage();
	}

	@Then("Sign the Document at Signature Place")
	public void sign_the_document_at_signature_place() throws InterruptedException  {
		appLib.page().documentSignPage().signDocument();
	}

	@Then("Click on I agree Button and Verify {string} Message")
	public void click_on_i_agree_button_and_verify_message(String string) {
		Boolean isMsgDisplayedAftrBtnClick=appLib.page().documentSignPage().verifyMessageByclickOnIAgreeBtn(string);
		Assert.assertTrue(isMsgDisplayedAftrBtnClick);
	    
	}

	@Then("user click on {string} Link")
	public void user_click_on_link(String string) {
	   appLib.page().dashboardPage().clickOnMyDocumentLink();
	}

	@Then("click on close icon for delete")
	public void click_on_close_icon_for_delete() {
	   appLib.page().myDocumentsPage().clickCloseIconForDelete();
	}

	@Then("Verify that a popup with message {string} is displayed and click ok Button")
	public void verify_that_a_popup_with_message_is_displayed_and_click_ok_Button(String string) {
		 appLib.page().myDocumentsPage().verifyDeleteMsg(string);
	}
	
	@Then("Verify that a popup with message {string} is displayed")
	public void verify_that_a_popup_with_message_is_displayed(String string) throws InterruptedException {
		 appLib.page().myDocumentsPage().verifySuccesfullyDeleteMsg(string);
	}
	
	@When("user set the security question {string} and set the answer {string}")
	public void user_set_the_security_question_and_set_the_answer(String question, String answer)  {
		appLib.page().startSigningPage().setSecurityQuesAndAns(question,answer);
	}
	
	@Then("user enter the answer {string} of Security question")
	public void user_enter_the_answer_of_security_question(String string) throws InterruptedException {
		appLib.page().documentSignPage().answerSecurityQues(string);
	}

	


}
