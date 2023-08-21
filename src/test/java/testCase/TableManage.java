package testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.Table;
import testBase.BaseClass;

public class TableManage extends BaseClass {
	public Table tb;
	public ExtentReports extent=new ExtentReports();
	public ExtentTest test;
	//WebDriver driver;
	@Test(description="Tnis is ")
	public void Name()
	{
		test=extent.createTest("hgrjejk");
		tb=new Table(driver);
		tb.m1();
	}
	@Test
	public void Name1()
	{
		tb.m2();
	}

}
