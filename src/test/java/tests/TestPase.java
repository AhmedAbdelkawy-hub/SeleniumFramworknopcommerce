package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.beust.jcommander.Parameter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;

public class TestPase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;

	@BeforeTest
	@Parameters({ "Browser" })
	public void setup( @Optional("Chrome") String BrowserName) {
		if (BrowserName.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("Firfox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (BrowserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (BrowserName.equalsIgnoreCase("Chrome-headless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
		}


		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

	}
	
	// Take screenshot after test case fail and add it in screenshot folder
	@AfterMethod
	public void screenshotonfailuer(ITestResult Result) {
		if (Result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking screenshot....");
			Helper.captureScreenshot(driver, Result.getName());
		}
	}
//	@AfterTest
//	public void afterTest() {
//		driver.close();
//	}

//	@BeforeMethod
//	public void beforeMethod() {
//		driver.get("https://demo.nopcommerce.com/");
//	}

//	@AfterMethod
//	public void afterMethod() {
//		driver.quit();
//	}


}
