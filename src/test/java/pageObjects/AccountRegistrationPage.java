package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	//Constructor to invoke base page
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Elements or locator
		@FindBy(name = "firstname")
		WebElement txtFirstname;

		@FindBy(name = "lastname")
		WebElement txtLasttname;

		@FindBy(name = "email")
		WebElement txtEmail;

		@FindBy(name = "telephone")
		WebElement txtTelephone;

		@FindBy(name = "password")
		WebElement txtPassword;

		@FindBy(name = "confirm")
		WebElement txtConfirmPassword;

		@FindBy(name = "agree")
		WebElement chkdPolicy;

		@FindBy(xpath = "//button[normalize-space()='Continue']")
		WebElement btnContinue;
		//get confirmation message
		@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement msgConfirmation;
		//get already created account of this credential
		//@FindBy(xpath="")
		
		// Methods
		public void setFirstName(String fname) {
			txtFirstname.sendKeys(fname);

		}

		public void setLastName(String lname) {
			txtLasttname.sendKeys(lname);

		}

		public void setEmail(String email) {
			txtEmail.sendKeys(email);

		}

		public void setTelephone(String tel) {
			txtTelephone.sendKeys(tel);

		}

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);

		}

		public void setConfirmPassword(String pwd) {
			txtConfirmPassword.sendKeys(pwd);

		}

		public void setPrivacyPolicy() {
			chkdPolicy.click();

		}

		public void clickContinue() {
			//sol1 
			btnContinue.click();
			
			//sol2 
			//btnContinue.submit();
			
			//sol3
			//Actions act=new Actions(driver);
			//act.moveToElement(btnContinue).click().perform();
						
			//sol4
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", btnContinue);
			
			//Sol 5
			//btnContinue.sendKeys(Keys.RETURN);
			
			//Sol6  
			//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
			
		}
		public String getConfirmationMsg() {
			try {
				return (msgConfirmation.getText());
			} catch (Exception e) {
				return (e.getMessage());

			}

		}
}