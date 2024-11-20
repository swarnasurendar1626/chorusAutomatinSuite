package cognine.chorus.automation.lnd.listeners;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReportListener implements ITestListener, ISuiteListener {
	public static ExtentReports report;
	public static ExtentTest logger;

	public ExtentReportListener(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onStart(ISuite suite) {
		// Create an html report for the suite that is executed
		report = new ExtentReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger = report.createTest(result.getMethod().getMethodName());
		logger.log(Status.INFO, "Executing test: " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.log(Status.INFO, "Finished executing test");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String fileName = String.format("Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
		Object driver = result.getTestContext().getAttribute("WebDriver"); // use string from setAttribute from BasePage
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/" + fileName);
		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot taken, saved in screenshots folder");
		} catch (IOException e) {
			System.out.println("Failed to take screenshot");
		}
		logger.log(Status.FAIL, "Test failed, attaching screenshot in screenshots folder");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.log(Status.SKIP, "Test skipped");
	}

}
