package cognine.chorus.automation.lnd.endtoend;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import cognine.chorus.automation.lnd.pageobjects.LoginPageEvents;
import cognine.chorus.automation.lnd.pageobjects.OutlookLogin;
import cognine.chorus.automation.lnd.pageobjects.myLearningsPage;
import cognine.chorus.automation.lnd.utils.baseClass;

@Listeners(cognine.chorus.automation.lnd.listeners.ExtentReportListener.class)
public class employeePageTest extends baseClass {
	WebDriver driver;
	OutlookLogin ol;
	myLearningsPage ep;

	@BeforeTest
	public void driverSetup() throws Exception {
		driver = setupDriver();
	}

	@Test
	public void employeeLogin() throws IOException, InterruptedException {
		LoginPageEvents loginPage = new LoginPageEvents(driver);
		loginPage.login();
		loginPage.clickLogo();
	}

	/*
	 * @Test public void myLearnings() throws InterruptedException { ep = new
	 * myLearningsPage(driver); ep.navigateToMyLearnings();
	 * ep.getMyLearningsIcon().click(); ep.getSkillsetCard().click();
	 * ep.checkSkillsetDetails(); ep.checkPracticeDetails(); ep.expectedDates();
	 * ep.checkAssignedHours(); ep.listOfTopics(); ep.countOfTopics(); }
	 */

}
