package smokeTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class SmokeTest {
	private WebDriver driver;
	
	@Test
	public void elementsDisplay() {
	}
	
	@Test
	public void register() {
	}
	
	@Test
	public void login() {
	}
	
	@Test
	public void logout() {
	}
	
	@Test
	public void search() {
	}
	
	@Test
	public void cartOptions() {
	}
	
	@BeforeTest(alwaysRun = true)
	@Parameters("browser")
	public void beforeTest(String browser) {
		//TODO: Logic to change browser							
		if (browser.equals("chrome"))
		{
			if (driver != null)
				driver.close();
				  
			driver = new ChromeDriver();
		}
		else
		{
			if (driver != null)
				driver.close();
			  
			driver = new FirefoxDriver();
		}
		  
		  																																																																																																																																																																																																																																																																										driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://morning-bastion-21932.herokuapp.com/");
	}

	@AfterTest	
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.gecko.driver", "/home/atlantbh/geckodriver");
	    System.setProperty("webdriver.chrome.driver", "/home/atlantbh/chromedriver");
	}

	@AfterSuite
	public void afterSuite() {
		if (driver != null)
			driver.close();
	}

}
