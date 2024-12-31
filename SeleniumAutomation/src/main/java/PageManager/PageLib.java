package PageManager;

import org.openqa.selenium.WebDriver;

import esignly.pages.DashboardPage;
import esignly.pages.DocumentSignPage;
import esignly.pages.ForgotPasswordPage;
import esignly.pages.LoginPage;
import esignly.pages.MyDocumentsPage;
import esignly.pages.SignUpPage;
import esignly.pages.StartSigningPage;


public class PageLib {

	private WebDriver driver;
	private LoginPage loginPage;
	private SignUpPage signUpPage;
	private ForgotPasswordPage forgotPasswordPage;
    private DashboardPage dashboardPage;
    private StartSigningPage startSigningPage;
    private MyDocumentsPage myDocumentsPage;
    private DocumentSignPage documentSignPage;

	public PageLib(WebDriver driver) {
		this.driver = driver;
		loginPage = new LoginPage(this.driver);
		dashboardPage = new DashboardPage(this.driver);
		signUpPage = new SignUpPage(this.driver);
		forgotPasswordPage = new ForgotPasswordPage(this.driver);
		startSigningPage = new StartSigningPage(this.driver); 
		myDocumentsPage = new MyDocumentsPage(this.driver);
		documentSignPage = new DocumentSignPage(this.driver);
	}

	public LoginPage loginPage() {
		return loginPage;
	}

	public DashboardPage dashboardPage() {
		return dashboardPage;
	}
	
	public SignUpPage signUpPage() {
		return signUpPage;
	}
	
	public ForgotPasswordPage forgotPasswordPage() {
		return forgotPasswordPage;
	}
	
	public StartSigningPage startSigningPage() {
		return startSigningPage;
	}
	
	public MyDocumentsPage myDocumentsPage() {
		return myDocumentsPage;
	}
	
	public DocumentSignPage documentSignPage() {
		return documentSignPage;
	}

}
