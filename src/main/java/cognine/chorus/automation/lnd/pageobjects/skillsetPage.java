package cognine.chorus.automation.lnd.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import cognine.chorus.automation.lnd.utils.baseClass;

public class skillsetPage extends baseClass {
	int TimeoutValue = 5000;

	public skillsetPage(WebDriver driver) {
		this.driver = driver;
		try {
			prop = baseClass.getProperties("skillset_page.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}

	By skillset = By.id("Skillset");
	By skillsetIcon = By.xpath("//a[@title='Configuration']");
	By skillsetTab = By.id("skillset-button");
	By topicsTab = By.id("topic-button");
	By uploadSkillsetTab = By.id("upload-button");
	By skillsetMappingTab = By.id("skillset-mapping-button");

	public void navigateToSkillset() throws InterruptedException {
		mouseHoverAction(getWebElement(prop.getProperty("skillset"), "xpath"));
		getWebElement(prop.getProperty("skillset"), "id").click();
	}

	public void skillSetTab() {
		getWebElement(prop.getProperty("skillsetTab"), "id").click();

	}

}
