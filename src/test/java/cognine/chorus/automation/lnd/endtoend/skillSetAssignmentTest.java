package cognine.chorus.automation.lnd.endtoend;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import cognine.chorus.automation.lnd.pageobjects.LoginPageEvents;
import cognine.chorus.automation.lnd.pageobjects.employeeSkillsetMapping;
import cognine.chorus.automation.lnd.utils.baseClass;

@Listeners(cognine.chorus.automation.lnd.listeners.ExtentReportListener.class)

public class skillSetAssignmentTest extends baseClass {

	WebDriver driver;
	private employeeSkillsetMapping esm;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter er;
	ExtentTest test;

	@BeforeTest
	public void driverSetup() throws Exception {
		driver = setupDriver();
	}

	@Test
	public void chorusLogin() throws IOException, InterruptedException {
		LoginPageEvents loginPage = new LoginPageEvents(driver);
		loginPage.login();
		loginPage.clickLogo();
		loginPage.checkLearningsTitle();
	}

	@Test(priority = 1)
	public void skillsetStart() throws IOException, InterruptedException {
		employeeSkillsetMapping esm = new employeeSkillsetMapping(driver);
		esm.mouseHover();
		esm.getEmployeeSkillSetIcon().click();
		esm.getPracticeDropdown().click();
		esm.getPracticeName().click();
		esm.getEmployeeDropdown().click();
		esm.getEmployeeName().click();
		esm.clickPracticeSkillset().click();
		esm.getSkillSearch().sendKeys("SQL");
		esm.getStartButton().click();
		esm.getYesButton().click();
		esm.getSaveCloseButton().click();

	}

	@Test(priority = 2, dependsOnMethods = { "skillsetStart" })
	public void closeSkillset() {
		employeeSkillsetMapping esm = new employeeSkillsetMapping(driver);
		esm.getSkillSearch().clear();
		esm.getSkillSearch().sendKeys("SQL");
		esm.getPauseButton().click();
		// esm.getPauseComments().sendKeys("Test by Lohith");
	}

	@AfterTest
	public void driverQuit() throws Exception {
		driver.quit();

	}
}
