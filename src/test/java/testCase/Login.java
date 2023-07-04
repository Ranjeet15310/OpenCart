package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
public class Login extends BaseClass{
	public HomePage hp;
	public LoginPage Login;
	public MyAccountPage ap;
	
	@Test(priority=1)
	public void clickMyAccount()
	{
		logger.info("** Click on myAccount link ***");
		hp=new HomePage(driver);
		hp.clickMyAccount();
	}
	@Test(priority=2)
	public void ClickOnTheLoginLink()
	{
		logger.info("** Click on the Login link button ***");
		hp.clickLoginLink();
	}
	@Test(priority=3)
	public void EnterTheEmailID()
	{
		logger.info("** Enter email ***");
		Login=new LoginPage(driver);
		Login.EmailinputBox(rb.getString("email"));
	}
	@Test(priority=4)
	public void EmailIsDisplayed()
	{	logger.info("** Email input box is displayed **");
		Login.EmailDisplay();
	}
	@Test(priority=5)
	public void EmailIsEnabled()
	{	
		logger.info("** Email input box is enabled");
		Login.EmailEnable();
	}
	@Test(priority=6)
	public void EmailIsSelected()
	{
		Login.EmailSelected();
	}
	@Test(priority=7)
	public void EnterThePassword()
	{
		Login.PasswordInputBox(rb.getString("password"));
	}
	@Test(priority=8)
	public void ClickOnLoginButton()
	{
		Login.LoginButton();
	}
	@Test(priority=9)
	public void verifyMyAccount()
	{
		try {
		ap=new MyAccountPage(driver);
		boolean target=ap.myAccountExist();
		Assert.assertEquals(target, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("** not login my account");
	}
}
