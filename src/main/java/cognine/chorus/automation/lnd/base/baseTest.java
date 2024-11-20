package cognine.chorus.automation.lnd.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class baseTest extends driverSetup{
	public static WebDriver driver;
	String url = "https://www.oculus.com/";
	public static ExtentTest logger;
	public static ExtentReports report;

	@BeforeClass(alwaysRun = true)
	public void setup(ITestContext context) throws Exception {
		driver = setupDriver();
		launchApplication(url);
		context.setAttribute("WebDriver", driver);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
