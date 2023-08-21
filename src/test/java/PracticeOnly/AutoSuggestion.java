package PracticeOnly;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium tutorial");
		Thread.sleep(2000);
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='OBMEnb']//li"));
		//Find the size
		System.out.println(list.size());
		//print suggestion 
	/*	for(int i=0;i<=list.size();i++)
		{
			String S=list.get(i).getText();
			System.out.println(S);
		}
		Thread.sleep(2000);*/
		// select from suggestion
		//for(int i=0;i<=list.size();i++)
			for(WebElement X:list)
		{
			//String A=list.get(i).getText();
			String A=X.getText();
			if(A.equalsIgnoreCase("selenium tutorial python"))
			{
				//list.get(i).click();
				X.click();
				break;
			}
		}
	}
	
}
