package cognine.chorus.automation.lnd.base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

import cognine.chorus.automation.lnd.utils.baseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class driverSetup {

	public static  WebDriver driver;
	public static Properties prop;
	static baseClass baseclass;
	public static volatile driverSetup instance;
	static {
		try {
			// Load properties file
			prop = baseClass.getProperties("driverSetup.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * static String Browser=prop.getProperty("Browser"); static String
	 * URL=prop.getProperty("URL");
	 */
	public static WebDriver createDriver(String Browser) throws Exception {

		System.out.println(Browser);
		// prop = baseClass.getProperties("driverSetup.properties");
		switch (Browser.toUpperCase()) {

		case "CHROME": {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--allow-running-insecure-content");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			break;
		}
		case "FIREFOX": {
			FirefoxOptions Options = new FirefoxOptions();
			Options.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver();
			break;
		}
		case "EDGE": {
			InternetExplorerOptions Options1 = new InternetExplorerOptions();
			Options1.setAcceptInsecureCerts(true);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		}
		default: {
			throw new Exception("Incorrect Browser" + Browser);
		}

		}
		return driver;

	}

	public static WebDriver setupDriver() throws Exception {
		createDriver(prop.getProperty("Browser"));
		launchApplication(prop.getProperty("URL"));
		return driver;

	}

	public static  void launchApplication(String URL) {

		driver.get(URL);

	}

	/*public static void getInstance(String Browser) {
		if (instance == null) {
			synchronized (driverSetup.class) {
				if (instance == null) {
					instance = new driverSetup();
				}
			}
		}
		}
	 */

}
