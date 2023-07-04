package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
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
