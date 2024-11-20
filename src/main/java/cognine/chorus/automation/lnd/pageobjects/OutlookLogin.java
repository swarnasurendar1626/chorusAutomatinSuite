package cognine.chorus.automation.lnd.pageobjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import cognine.chorus.automation.lnd.utils.baseClass;

public class OutlookLogin extends baseClass {

	WebDriver driver;
	Properties prop;
	public int TimeoutValue = 10;
	final String TimeOutValue = "10";

	@FindBy(id = "i0116")
	public WebElement email;

	@FindBy(id = "i0118")
	public WebElement password;

	@FindBy(id = "idSIButton9")
	public WebElement nextButton;

	@FindBy(xpath = "//*[@id='KmsiCheckboxField']")
	public WebElement checkBox;

	@FindBy(xpath = "//div[@class='ic-title' and contains(text(),'Learning and Development')]")
	public WebElement LnDIcon;

	/*
	 * By email=By.id("#i0116"); By nextButton = By.cssSelector("#idSIButton9"); By
	 * password = By.cssSelector("#i0118"); By checkBox =
	 * By.xpath("//*[@id='KmsiCheckboxField']"); By LnDIcon= By.
	 * xpath("//div[@class='ic-title' and contains(text(),'Learning and Development')]"
	 * );
	 */

	public OutlookLogin(WebDriver driver) throws IOException {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
		this.driver = driver;
		prop = getProperties("login_page.properties");

	}

	public void login() throws IOException, InterruptedException {
		// email.click();
		email.sendKeys(prop.getProperty("UserName"));
		nextButton.click();
		password.sendKeys((prop.getProperty("Password")));
		nextButton.click();
		checkBox.click();
		nextButton.click();
		LnDIcon.click();

		/*
		 * waitForElementToAppear(nextButton); waitForElementToAppear(password);
		 * waitForElementToAppear(nextButton); waitForElementToAppear(checkBox);
		 *
		 *
		 */
	}

}
