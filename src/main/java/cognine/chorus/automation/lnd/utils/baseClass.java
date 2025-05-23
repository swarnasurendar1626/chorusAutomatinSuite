package cognine.chorus.automation.lnd.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import cognine.chorus.automation.lnd.base.driverSetup;

public class baseClass extends driverSetup {

	private static WebDriverWait wait;
	static WebElement ele;

	public static WebElement getWebElementByLocator(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return ele;

	}

	public void MethodsUsedForEntireApplication(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement waitForElementTobeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return ele;
	}

	public static WebElement getWebElement(String identifierValue, String identifierType) {

		System.out.println(identifierType + "" + identifierValue);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (driver == null) {
			System.out.println("Empty Driver");
			throw new IllegalStateException("Driver not initialized. Call setDriver() first.");
		}
		switch (identifierType.toUpperCase()) {
		case "XPATH":
			return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(identifierValue))));
		case "ID":
			return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(identifierValue))));
		case "CLASS":
			return wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className(identifierValue))));
		case "CSSSELECTOR":
			return wait.until(
					ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(identifierValue))));
		case "NAME":
			return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(identifierValue))));
		case "TAGNAME":
			return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName(identifierValue))));
		case "LINKTEXT":
			return wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(identifierValue))));
		default:
			return null;

		}
	}

	public static Properties getProperties(String propertiesFileName) throws IOException {
		Properties prop = new Properties();
		String filePath = System.getProperty("user.dir") + "/src/main/java/cognine/chorus/automation/lnd/configfiles/"
				+ propertiesFileName;
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		return prop;
	}

	public static String loadInputs(String inputKey) throws IOException {
		String value = null;
		FileInputStream fis;
		fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/cognine/chorus/automation/lnd/configfiles/");
		Properties p = new Properties();
		p.load(fis);
		value = p.getProperty(inputKey);
		return value;
	}

	public void switchToIframe(WebElement webElement) {
		driver.switchTo().frame(webElement);
	}

	public List<WebElement> getWebElementsbyLocator(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public boolean assertElement(WebElement element) {
		// TODO Auto-generated method stub
		return element.isDisplayed();

	}

	public void assertText(String expectedText, String actualText) {
		Assert.assertEquals(expectedText, actualText);
	}

	public void assertCount(int expectedCount, int actualCount) {
		Assert.assertEquals(expectedCount, actualCount);
	}

	public void mouseHoverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void extentReports() {
		ExtentReports reports = new ExtentReports();

		ExtentTest test = reports.createTest("LnD Test");
	}

}
