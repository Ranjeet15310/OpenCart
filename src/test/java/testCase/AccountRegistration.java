package testCase;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class AccountRegistration extends BaseClass{
	public HomePage hp;
	public AccountRegistrationPage accountResister;

	@Test(priority=1)
	void clickMyAcc() throws InterruptedException
	{
		hp=new HomePage(driver);
		Thread.sleep(2000);
		hp.clickMyAccount();
	}
	@Test(priority=2)
	void clickRegistrationButton()
	{
		hp.clickRegister();
	}
	@Test(priority=3)
	void EnterFirstName()
	{
		accountResister = new AccountRegistrationPage(driver);
		accountResister.setFirstName("Ranjeet");
	}
	@Test(priority=4)
	void EnterLastName()
	{
		accountResister.setLastName("Kumar");
	}
	@Test(priority=5)
	void EnterEmail()
	{
		accountResister.setEmail("Ranjeet@gmail.com");
	}
	@Test(priority=5)
	void EnterPassword()
	{
		accountResister.setPassword("Ranjeet@132");
	} 
	@Test(priority=5)
	void ClickPolicyButton()
	{
		accountResister.setPrivacyPolicy();
	}

}
