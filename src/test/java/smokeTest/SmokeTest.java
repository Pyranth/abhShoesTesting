package smokeTest;

import org.testng.annotations.Test;

import smokeTest.pages.CartPage;
import smokeTest.pages.CategoryPage;
import smokeTest.pages.HomePage;
import smokeTest.pages.LoginPage;
import smokeTest.pages.RegisterPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class SmokeTest {
	private WebDriver driver;
	
	private HomePage homePage;
	private CategoryPage categoryPage;
	private RegisterPage registerPage;
	private LoginPage loginPage;
	private CartPage cartPage;
	
	@Test
	public void elementsDisplay() {
		homePage = new HomePage(driver);
		
		assertTrue(homePage.getHomePageLink().isDisplayed());
		assertTrue(homePage.getWomenShoesLink().isDisplayed());
		assertTrue(homePage.getMenShoesLink().isDisplayed());
		assertTrue(homePage.getKidsShoesLink().isDisplayed());
		assertTrue(homePage.getSportsShoesLink().isDisplayed());
		
		assertTrue(homePage.getLoginLink().isDisplayed());
		assertTrue(homePage.getRegisterLink().isDisplayed());
		
		assertFalse(homePage.isFeaturedProductsListEmpty());
		assertFalse(homePage.isFeaturedProductsItemListEmpty());
		
		homePage.getWomenShoesLink().click();
		testCategory();
		
		homePage.getMenShoesLink().click();
		testCategory();
		
		homePage.getKidsShoesLink().click();
		testCategory();
		
		homePage.getSportsShoesLink().click();
		testCategory();
	}
	
	private void testCategory()
	{
		categoryPage = new CategoryPage(driver);
		
		assertFalse(categoryPage.getShoeItems().isEmpty());
		assertTrue(categoryPage.getFilterForm().isDisplayed());
	}
	
	@Test
	public void register() {
		homePage = new HomePage(driver);
		
		homePage.getRegisterLink().click();
		
		registerPage = new RegisterPage(driver);
		
		registerPage.insertEmail("email@email.com");
		registerPage.insertPassword("testtest");
		registerPage.insertRepeatedPassword("testtest");
		registerPage.submitRegister();
		
		assertTrue(registerPage.getErrorMessage().isDisplayed());
	}
	
	@Test
	public void login() {
		homePage = new HomePage(driver);
		
		homePage.getLoginLink().click();
		
		loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("adminabh@abh.com");
		loginPage.insertPassword("adminpass");
		loginPage.submitLogin();
		
		assertTrue(homePage.getCurrentUser().getText().contains("Welcome adminabh@abh.com"));
	}
	
	@Test
	public void logout() {
		homePage = new HomePage(driver);
		
		homePage.getLogoutLink().click();
		
		assertTrue(homePage.getLoginLink().isDisplayed());
		assertTrue(homePage.getLoginLink().isDisplayed());
		
		loginPage = new LoginPage(driver);
		
		assertTrue(loginPage.getEmailField().isDisplayed());
		assertTrue(loginPage.getPasswordField().isDisplayed());
		assertTrue(loginPage.getButtonSubmit().isDisplayed());
	}
	
	@Test
	public void search() {
		homePage = new HomePage(driver);
		
		homePage.getWomenShoesLink().click();
		
		categoryPage = new CategoryPage(driver);
		
		categoryPage.getFilterForm();
		
		categoryPage.setBrand("Nike");
		categoryPage.setSize("6");
		categoryPage.setColor("Black");
		categoryPage.setStyle("Summer");
		categoryPage.setPriceRange("120KM - ...");
		categoryPage.getSearchButton().click();
		
		assertFalse(categoryPage.getShoeItems().isEmpty());
	}
	
	@Test
	public void cartOptions() {
		homePage = new HomePage(driver);
		
		homePage.getCartLink().click();
		
		cartPage = new CartPage(driver);
		
		assertTrue(cartPage.getReceiptData().isDisplayed());
		assertFalse(cartPage.getCartItems().isEmpty());
		assertTrue(cartPage.getContinueButton().isDisplayed());
		
		cartPage.getContinueButton().click();
		
		assertTrue(cartPage.getShipmentForm().isDisplayed());
		assertTrue(cartPage.getShipmentContinueButton().isDisplayed());
		
		cartPage.getShipmentContinueButton().click();
		
		assertTrue(cartPage.getAddressInfo().size() == 2);
		assertTrue(cartPage.getPayButton().isDisplayed());
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
