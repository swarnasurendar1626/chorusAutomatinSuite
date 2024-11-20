package cognine.chorus.automation.lnd.endtoend;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cognine.chorus.automation.lnd.pageobjects.LoginPageEvents;
import cognine.chorus.automation.lnd.pageobjects.employeeSkillsetMapping;
import cognine.chorus.automation.lnd.utils.baseClass;

public class skillSetAssignmentTest extends baseClass {

	WebDriver driver;
	private employeeSkillsetMapping esm;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter er;
	ExtentTest test;

	@BeforeTest
	public void driverSetup() throws Exception {
		String reportName = "PracticeHeadRole"+System.currentTimeMillis()+".html";
		ExtentSparkReporter er = new ExtentSparkReporter("target/spark.html" + reportName);
		driver = setupDriver();
		er.config().setTheme(Theme.DARK);
		er.config().setDocumentTitle("Practice Head Test");
		extent.attachReporter(er);
	}

	@Test
	public void chorusLogin() throws IOException, InterruptedException {
		ExtentTest test = extent.createTest("Login Test Case");
		LoginPageEvents loginPage = new LoginPageEvents(driver);
		loginPage.login();
		loginPage.clickLogo();
		test.pass("Login Test Case Passed");
		test.fail("Failed");
	}

	@Test(priority = 1)
	public void skillsetStart() throws IOException, InterruptedException {
		employeeSkillsetMapping esm = new employeeSkillsetMapping(driver);
		ExtentTest test = extent.createTest("Start Skillset Testcase");
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
		test.pass("Passed");
		test.fail("Failed");

	}

	@Test(priority = 2, dependsOnMethods = { "skillsetStart" })
	public void closeSkillset() {
		employeeSkillsetMapping esm = new employeeSkillsetMapping(driver);
		ExtentTest test = extent.createTest("Close Skillset Testcase");
		esm.getSkillSearch().clear();
		esm.getSkillSearch().sendKeys("SQL");
		esm.getPauseButton().click();
		test.pass("Passed");
		test.fail("Failed");

		// esm.getPauseComments().sendKeys("Test by Lohith");
	}

	@AfterTest
	public void driverQuit() throws Exception {
		extent.flush();
		driver.quit();

	}
}
