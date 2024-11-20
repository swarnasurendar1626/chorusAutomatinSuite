package cognine.chorus.automation.lnd.endtoend;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cognine.chorus.automation.lnd.pageobjects.LoginPageEvents;
import cognine.chorus.automation.lnd.utils.baseClass;

public class skillSetPageTest extends baseClass{
	WebDriver driver;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = setupDriver();

	}
	@Test
	public void f() throws IOException, InterruptedException {
		LoginPageEvents loginPage = new LoginPageEvents(driver);
		loginPage.login();
		//loginPage.clickLogo();
	}
	/*
	 * @Test public void skillsetDetails() throws InterruptedException {
	 * skillsetPage skill = new skillsetPage(driver); skill.navigateToSkillset();
	 * skill.skillSetTab(); }
	 */
}
