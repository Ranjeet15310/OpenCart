package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentReport;
public class LoginPage extends BasePage {
	public ExtentReports extent;
	public static ExtentTest test;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}


	//Locator
	@FindBy(name="email") WebElement EmailLink;
	@FindBy(name="password") WebElement PasswordLink;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement LoginLink;


	//Methods
	public void EmailinputBox(String email)
	{
		extent=new ExtentReports();
	    test=extent.createTest("Hellow");
		EmailLink.sendKeys(email);
	}
	public void EmailDisplay()
	{
		EmailLink.isDisplayed();
	}
	public void EmailEnable()
	{
		EmailLink.isEnabled();
	}
	public void EmailSelected()
	{
		EmailLink.isSelected();
	}
	public void PasswordInputBox(String Pwd)
	{
		PasswordLink.sendKeys(Pwd);
	}
	public void LoginButton()
	{
		LoginLink.click();
	}
}
