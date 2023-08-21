package testBase;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
	public class Practice {
		public static void main(String[] args) throws InterruptedException{
			WebDriver driver = new ChromeDriver();
			
			//Launching sample website
			driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
			driver.manage().window().maximize();
			
			//Mouseover on submit button
			Actions action = new Actions(driver);
			WebElement btn = driver.findElement(By.xpath("//button[@class='dropbtn']"));
			action.moveToElement(btn).build().perform();
			WebElement buton=driver.findElement(By.xpath("//a[normalize-space()='Link 3']"));
			buton.click();
			//Thread.sleep just for user to notice the event
			Thread.sleep(3000);
			
			//Closing the driver instance
			driver.quit();
		
		
	}
}
