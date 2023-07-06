package stepDefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class steps {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	List<HashMap<String,String>> datamap;
	Logger logger; ///for loggin
	ResourceBundle rb; //reading properties file
	String br;
	
	@Before
	public void setup()
	{
		//for loggin
		logger=LogManager.getLogger(this.getClass());
		//reading properties
		rb=ResourceBundle.getBundle("config");
		br=rb.getString("browser");
	}
	@After
	public void tearDown(Scenario scenario)
	{
		System.out.println("Scenario status =====>"+ scenario.getStatus());
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		driver.quit();
	}
	
	
	@Given("User Launch browser")
	public void user_launch_browser() {
	 if(br.equalsIgnoreCase("chrome"))
	 {
		 driver=new ChromeDriver();
	 }
	 else if(br.equalsIgnoreCase("edge"))
	 {
		 driver=new EdgeDriver();
	 }
	 else
	 {
		 driver=new FirefoxDriver();
	 }
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("opens URL {string}")
	public void opens_url(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User navigate to MyAccount menu")
	public void user_navigate_to_my_account_menu() {
	    hp=new HomePage(driver);
	    hp.clickMyAccount();
	    logger.info("*** click on the myaccount ***");
	    
	}

	@When("click on Login")
	public void click_on_login() {
	    hp.clickLoginLink();
	    logger.info("** User able to click on the loging button which is available into the myaccount page *");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
	 lp=new LoginPage(driver);
	 lp.EmailinputBox(email);
	 lp.PasswordInputBox(pwd);
	 logger.info("** user enter the email id and password **");
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		lp.LoginButton();
		logger.info("** user click on the login button ***");
	}

	@Then("User navigates to MyAccount Page")
	public void user_navigates_to_my_account_page() {
	   macc=new MyAccountPage(driver);
	 boolean account=  macc.myAccountExist();
	 if(account)
	 {
		 Assert.assertTrue(true);
	 }
	 else
		 Assert.assertTrue(false);
	}


}
