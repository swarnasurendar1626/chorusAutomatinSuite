package cognine.chorus.automation.lnd.pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import cognine.chorus.automation.lnd.utils.baseClass;

public class myLearningsPage extends baseClass {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	int TimeoutValue = 5000;
	List<WebElement> topicsList;
	SoftAssert softAssert = new SoftAssert();

	public myLearningsPage(WebDriver driver) {
		this.driver = driver;
		try {
			prop = baseClass.getProperties("myLearnings_page.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}

	By myLearningButton = By.className("menu-links");
	By learningsIcon = By.xpath("//a[@title='My Learnings']");

	//@FindBy(xpath = "//a[@title='My Learnings']") WebElement learningsIcon;

	By ongoingButton = By.id("ongoing-button");
	By plannedButton = By.id("backlog-button");
	By completedButton = By.id("complete-button");
	By learningsTitle = By.xpath("//span[@class='px-3']");
	By skillsetCard = By.xpath("//h3[@class='skillset' and contains(text(), 'Selenium')]");
	By assignedHours = By
			.xpath("//h3[@class='skillset' and contains(text(), 'Selenium')]/parent::div/preceding-sibling::div/span");
	By practiceLabel = By.xpath("//label[@class='fixed-width']");
	By practiceText = By.xpath("//label[@class='fixed-width']//following-sibling::span");
	By startDate = By.xpath("//label[@class='fixed-width' and contains(text(),'Start Date')]//following-sibling::span");
	By endDate = By.xpath("//label[@class='fixed-width' and contains(text(),'End Date')]//following-sibling::span");
	By currentLevel = By
			.xpath("//label[@class='fixed-width' and contains(text(),'Current Level:')]//following-sibling::span");
	By learningStatus = By
			.xpath("//h3[@class='skillset' and contains(text(), 'Selenium')]/parent::div/following-sibling::div/div");
	// By topics = By.xpath("//div[@col-id='currentTopicName' and
	// @role='gridcell']");
	By logHours = By.xpath("//a[@title='Log Hours']");
	By logHoursPopup = By.xpath("//div[@aria-describedby='EditModalDialog']");
	By hoursTextBox = By.xpath("//input[@id='hours']");
	By workNotes = By.xpath("//textarea[@id='comments']");
	By saveButton = By.xpath("//button[@id='SaveData']");

	@FindBy(xpath = "//div[@col-id='currentTopicName' and @role='gridcell']")
	private List<WebElement> topics;

	public void navigateToMyLearnings() throws InterruptedException {
		mouseHoverAction(getWebElementByLocator(myLearningButton));
	}

	public void checkSkillsetDetails() {
		softAssert.assertEquals(getWebElementByLocator(skillsetCard).getText(), prop.getProperty("SkillSet"));
	}

	public void checkCurrentLevel() {
		softAssert.assertEquals(getWebElementByLocator(currentLevel).getText(), prop.getProperty("CurrentLevel"));
	}

	public void checkPracticeDetails() {
		softAssert.assertEquals(getWebElementByLocator(practiceText).getText(), prop.getProperty("Practice"));
	}

	public void expectedDates() {
		softAssert.assertEquals(getWebElementByLocator(startDate).getText(), prop.getProperty("StartDate"));
		softAssert.assertEquals(getWebElementByLocator(endDate).getText(), prop.getProperty("EndDate"));
	}

	public void checkAssignedHours() {
		softAssert.assertEquals(getWebElementByLocator(assignedHours).getText(), prop.getProperty("Hours"));
	}

	public void checkLearningStatus() {
		softAssert.assertEquals(getWebElementByLocator(learningStatus).getText(), prop.getProperty("learningStatus"));
	}
	public void checkLearningsTitle() {
		softAssert.assertEquals(getWebElementByLocator(learningsTitle).getText(), prop.getProperty("Title"));
	}

	public void listOfTopics() throws InterruptedException {

		List<WebElement> topicsList = topics;
		System.out.println(topicsList);
		for (WebElement topic : topicsList) {
			System.out.println(topic.getText());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement logAllTopics = (driver
					.findElement(By.xpath("//div[@col-id='currentTopicName' and @role='gridcell' and contains(text(),'"
							+ topic.getText() + "')]//following-sibling::*[5]/span/a[@title='Log Hours']")));
			js.executeScript("arguments[0].scrollIntoView();", logAllTopics);
			logAllTopics.click();
			getWebElementByLocator(hoursTextBox).clear();
			getWebElementByLocator(hoursTextBox).sendKeys("0.2");
			getWebElementByLocator(workNotes).sendKeys("Testing by L&D Automation Script");
			getWebElementByLocator(saveButton).click();
			break;
		}
	}

	public void countOfTopics() {
		// List<WebElement> topicsList = topics;
		System.out.println(topics.size());
		assertCount(topics.size(), 9);
	}

	public WebElement getMyLearningsIcon() {
		WebElement ele =getWebElementByLocator(learningsIcon);
		return ele;
	}
	public WebElement getSkillsetCard() {
		WebElement ele =waitForElementTobeClickable(skillsetCard);
		return ele;
	}
}
