package cognine.chorus.automation.lnd.utils;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;

import cognine.chorus.automation.lnd.base.baseTest;

public class ExtentReportListener extends baseTest implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		//Create an html report for the suite that is executed
		report = new ExtentReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
	/*
	 * @Override public void onTestStart(ITestResult result) { logger =
	 * report.startTest(result.getMethod().getMethodName());
	 * logger.log(LogStatus.INFO, "Executing test: " +
	 * result.getMethod().getMethodName());
	 *
	 * }
	 *
	 * @Override public void onTestSuccess(ITestResult result) {
	 * logger.log(LogStatus.INFO, "Finished executing test"); }
	 *
	 *
	 * @Override public void onTestFailure(ITestResult result) { String fileName =
	 * String.format("Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
	 * WebDriver driver =
	 * (WebDriver)result.getTestContext().getAttribute("WebDriver"); //use string
	 * from setAttribute from BasePage File srcFile =
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); File destFile =
	 * new File("./screenshots/" + fileName); try { FileUtils.copyFile(srcFile,
	 * destFile);
	 * System.out.println("Screenshot taken, saved in screenshots folder"); }
	 * catch(IOException e) { System.out.println("Failed to take screenshot"); }
	 * logger.log(LogStatus.FAIL,
	 * "Test failed, attaching screenshot in screenshots folder"); }
	 *
	 * @Override public void onTestSkipped(ITestResult result) {
	 * logger.log(LogStatus.SKIP, "Test skipped"); }
	 */

}

