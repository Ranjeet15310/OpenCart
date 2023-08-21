package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Table extends BasePage {

	public Table(WebDriver driver) 
	{
		super(driver);
	}
	int i,j;
	
	// Element
	int rows=driver.findElements(By.xpath("//div[@class='mx-2 flex-1']")).size();
	int cols=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
	@FindBy(xpath="//a[normalize-space()='2']") WebElement submitbtn;
	//@FindBy(xpath="//table[@name='BookTable']//tr") WebElement row;
	
	// Methods
	public void m1()
	{
		System.out.println("Hello");
		for(i=2;i<=rows;i++)
		{
			System.out.println(rows);
			for(j=1;j<=cols;j++)
			{
			String s=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
			System.out.print(s);
			}
			System.out.println();
		}
	}
		public void m2()
		{
			for(int i=2;i<=rows;i++)
			{
				String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
			    System.out.println(author);
				if(author.equals("Amit"))
				{
					String bk=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
					System.out.println(author+ "  "+bk);
					submitbtn.click();
			}
		}
	}
}
