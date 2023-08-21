package PracticeOnly;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatiWebTables {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		int cols=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		//System.out.println(rows.size());
	/*	String S=driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td[2]")).getText();
		String S1=driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td[4]")).getText();
		if(S.equals("Animesh") && S1.equals("300"))
		{
			WebElement S2=driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td[1]"));
			System.out.println(S2.getText());
		}*/
		
		//Read dynamic
		for(int i=2;i<=rows;i++)
		{
			//System.out.print("{");
			for(int j=1;j<=cols;j++)
			{
				String s=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
				System.out.print(s);
				
				
			}
			System.out.println("");
		}
		for(int i=2;i<=rows;i++)
		{
			String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
			//System.out.println(author);
			if(author.equals("Amit"))
			{
				String bk=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
				System.out.println(author+ "  "+bk);
			}
		}
		driver.close();
	}

}
