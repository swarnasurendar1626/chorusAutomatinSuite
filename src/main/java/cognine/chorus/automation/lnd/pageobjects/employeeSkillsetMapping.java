package cognine.chorus.automation.lnd.pageobjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cognine.chorus.automation.lnd.utils.baseClass;

public class employeeSkillsetMapping extends baseClass {

	int TimeoutValue = 5000;
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "//a[@title='Employee Skillset Mapping']")
	WebElement employeeSkillsetIcon;

	/*
	 * @FindBy (xpath="//a[@title='Employee Skillset Mapping']") WebElement
	 * myLearningButton;
	 */

	By myLearningButton = By.className("menu-links");

	@FindBy(xpath = "//div[@id='PracticeDropDown_chosen']")
	WebElement practiceDropdown;

	@FindBy(xpath = "//div[@id='PracticeDropDown_chosen']/descendant::li[contains(text(),'QA')]")
	WebElement practiceName;

	@FindBy(xpath = "//div[@id='EmployeeDropDown_chosen']")
	WebElement employeeDropdown;

	@FindBy(xpath = "//input[@id='skillsetMapping-text-box']")
	WebElement skillSearch;

	@FindBy(xpath = "//div[@id='EmployeeDropDown_chosen']/descendant::li[contains(text(), 'Ganesh Sunkara')]")
	WebElement employeeName;

	@FindBy(xpath = "//*[@id='flush-headingOne']/descendant::button[contains(text(),'Practice Skillset')]")
	WebElement practiceSkillset;

	@FindBy(xpath = "//div[@role='gridcell' and @col-id='skillsetName' and contains(text(), 'SQL')]//following-sibling::div[@col-id='proficiencyHistory']/descendant::a[@title='Start']")
	WebElement startButton;

	@FindBy(xpath = "//div[@role='gridcell' and @col-id='skillsetName' and contains(text(), 'SQL')]//following-sibling::div[@col-id='proficiencyHistory']/descendant::a[@title='Close Skillset Learning']")
	WebElement pauseButton;

	@FindBy(xpath = "//div[@id='inprogressSkillset']/preceding-sibling::div/button[@aria-label='Close']")
	WebElement saveCloseButton;

	@FindBy(xpath = "//textarea[@id='ReviewComments']")
	WebElement pauseComments;

	@FindBy(id = "startSaveYesbtn")
	WebElement yesButton;

	public employeeSkillsetMapping(WebDriver driver) {
		this.driver = driver;
		try {
			prop = baseClass.getProperties("myLearnings_page.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}

	public void pauseSkillsetForEmployee() throws InterruptedException {
		skillSearch.clear();
		skillSearch.sendKeys("Rest");
		pauseButton.click();
		pauseComments.sendKeys("Test by Lohith");
	}

	public WebElement getSkillsetaccordion() {
		wait.until(ExpectedConditions.elementToBeClickable(practiceSkillset));
		return practiceSkillset;
	}

	public WebElement getYesButton() {
		wait.until(ExpectedConditions.elementToBeClickable(yesButton));
		return yesButton;
	}

	public WebElement getEmployeeSkillSetIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(employeeSkillsetIcon));
		return employeeSkillsetIcon;
	}

	public WebElement getSkillSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(skillSearch));
		return skillSearch;
	}

	public WebElement getPracticeDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(practiceDropdown));
		return practiceDropdown;
	}

	public WebElement getPracticeName() {
		wait.until(ExpectedConditions.elementToBeClickable(practiceName));
		return practiceName;
	}

	public WebElement getEmployeeDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(employeeDropdown));
		return employeeDropdown;
	}

	public WebElement getEmployeeName() {
		wait.until(ExpectedConditions.elementToBeClickable(employeeName));
		return employeeName;
	}

	public WebElement getPauseButton() {
		wait.until(ExpectedConditions.elementToBeClickable(pauseButton));
		return pauseButton;
	}

	public WebElement clickPracticeSkillset() {
		wait.until(ExpectedConditions.elementToBeClickable(practiceSkillset));
		return practiceSkillset;
	}

	public WebElement getSaveCloseButton() {
		wait.until(ExpectedConditions.elementToBeClickable(saveCloseButton));
		return saveCloseButton;
	}

	public WebElement getPauseComments() {
		wait.until(ExpectedConditions.elementToBeClickable(pauseComments));
		return pauseComments;
	}

	public WebElement getStartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(startButton));
		return startButton;
	}

	public void mouseHover() {
		mouseHoverAction(getWebElementByLocator(myLearningButton));
	}

}
