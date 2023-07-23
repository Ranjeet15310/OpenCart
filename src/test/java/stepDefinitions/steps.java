package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
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
import utilities.DataReader;

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
	public void setup() throws IOException
	{
		//for loggin
		logger=LogManager.getLogger(this.getClass());
		//reading properties
		rb=ResourceBundle.getBundle("config");
		br=rb.getString("browser");
		
	/*	// other method to get properties from config properties
		File src=new File(".\\resources\\config.properties");
		FileInputStream fis=new FileInputStream(src);
		Properties pro=new Properties();
		pro.load(fis);
		br=pro.getProperty("browser");*/
		
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
	public void click_on_login() 
	{
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
	
	//*******   Data Driven test method    **************
    @Then("check User navigates to MyAccount Page by passing Email and Password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
    {
        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(driver);
        lp.EmailinputBox(email);
        lp.PasswordInputBox(pwd);

        lp.LoginButton();
        try
        {
            boolean targetpage=macc.myAccountExist();
        	Thread.sleep(5000);

            if(exp_res.equals("Valid"))
            {
                if(targetpage==true)
                {
                	Thread.sleep(5000);
                     macc=new MyAccountPage(driver);
                     macc.clickLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equals("Invalid"))
            {
                if(targetpage==true)
                {
                    macc.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
        driver.close();
    }



}
