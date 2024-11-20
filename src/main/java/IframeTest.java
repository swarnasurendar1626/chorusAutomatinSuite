 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
//import io.github.bonigarcia.wdm.WebDriverManager;
 
public class IframeTest {
 
	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://chorusqa.cogninelabs.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("lohith.pakkiru@cognine.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("Reddy@566");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class=\"cr-ic\"])[1]")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div[2]/main/div[2]/div[1]/div[1]/div/div[1]/label")).getText());
		
		
		
		
 
	}
 
}