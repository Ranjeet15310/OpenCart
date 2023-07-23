package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {

	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;
	public static WebDriver driver; 

	@BeforeSuite
	public void setExtent() {
		htmlReporter = new ExtentSparkReporter("C:\\Users\\rk604\\eclipse-workspace\\OpenCart\\CreateTestReport");
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config()
				.setReportName("CCMAAS APPLICATION (Job & Status terminated section)) Automation Test Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Host name", "Dell PC");
		extent.setSystemInfo("Project name", "CCMAAS");
		extent.setSystemInfo("Tester name", "Abhishek chaudhary");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");

	}

	@AfterMethod
	public void methodsResult(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed Method Is :       " + result.getName());
			test.log(Status.FAIL, "Test Failed Method Exception Is :         " + result.getThrowable());
			String path = FailedMethods(result.getName());
			test.addScreenCaptureFromPath(path);
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Skipped Method Is :        " + result.getName());
			String path = ExtentReport.FailedMethods(result.getName());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Passed Method Is :         " + result.getName());
		}

	}

	public static String FailedMethods(String screenShotName) throws IOException {
		LocalDateTime timeNow = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MM yyyy hh mm ss");
		String time = timeNow.format(dateFormat);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = "C:\\Users\\rk604\\eclipse-workspace\\OpenCart" + screenShotName + time + ".jpg";
		File target = new File(destination);
		FileUtils.copyFile(source, target);
		return target.getAbsolutePath();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}
