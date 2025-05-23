package cognine.chorus.automation.lnd.pageobjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import cognine.chorus.automation.lnd.utils.baseClass;

public class LoginPageEvents extends baseClass {

	WebDriver driver;
	Properties prop;
	public WebElement ele;

	By email = By.cssSelector("#i0116");
	By nextButton = By.cssSelector("#idSIButton9");
	By password = By.cssSelector("#i0118");
	By checkBox = By.xpath("//*[@id='KmsiCheckboxField']");
	By LnDIcon = By.xpath("//div[@class='ic-title' and contains(text(),'Learning and Development')]");
	By iFrame = By.id("#undefined");
	By learningsTitle = By.xpath("//span[@class='px-3']");

	/*
	 * @FindBy(id="i0116") WebElement email;
	 *
	 * @FindBy(id="idSIButton9") WebElement nextButton;
	 *
	 * @FindBy (id="i0118") WebElement password;
	 *
	 * @FindBy(xpath="//*[@id='KmsiCheckboxField']") WebElement checkBox;
	 *
	 * @FindBy(xpath
	 * ="//div[@class='ic-title' and contains(text(),'Learning and Development')]")
	 * WebElement LnDIcon;
	 */

	public LoginPageEvents(WebDriver driver) {
		this.driver = driver;
		System.out.println(driver + "Login Page");
		try {
			prop = baseClass.getProperties("login_page.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5000), this);

	}

	public void login() throws IOException, InterruptedException {
		getWebElementByLocator(email).sendKeys("lohith.pakkiru@cognine.com");
		getWebElementByLocator(nextButton).click();
		getWebElementByLocator(password).sendKeys(("Reddy@566"));
		getWebElementByLocator(nextButton).click();
		getWebElementByLocator(checkBox).click();
		getWebElementByLocator(nextButton).click();

	}

	public void assertLnDIcon() throws InterruptedException {
		// Assert.assertEquals(getWebElement(prop.getProperty("LnDIcon"),"xpath").getText(),
		// "Learning and Development");
		// getWebElement(prop.getProperty("LnDIcon"),"xpath").click();
		getWebElementByLocator(LnDIcon).click();
	}

	public void clickLogo() throws InterruptedException {
		assertLnDIcon();
		// switchToIframe(getWebElementByLocator(iFrame));
		driver.switchTo().frame("applicationId");
		System.out.println("Inside the Iframe");
	}

	public boolean checkLearningsTitle() {
		boolean result = getWebElementByLocator(learningsTitle).getText().equalsIgnoreCase("My Learnings");
		return result;
	}

}
