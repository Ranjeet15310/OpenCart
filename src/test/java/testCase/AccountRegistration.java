package testCase;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class AccountRegistration extends BaseClass{
	public HomePage hp;
	public AccountRegistrationPage accountResister;

	@Test(priority=1)
	void clickOnMyAccount()
	{
		hp=new HomePage(driver);
		hp.clickMyAccount();
	}
	@Test(priority=2)
	void clickOnRegistrationButton()
	{
		hp.clickRegister();
	}
	@Test(priority=3)
	void EnterTheFirstName()
	{
		accountResister = new AccountRegistrationPage(driver);
		accountResister.setFirstName("Ranjeet");
	}
	@Test(priority=4)
	void EnterTheLastName()
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
