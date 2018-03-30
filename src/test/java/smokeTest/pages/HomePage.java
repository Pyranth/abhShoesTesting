package smokeTest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends DefaultPage{
	@FindBy(xpath = "//a[contains(@class, 'navbar-brand')]")
	WebElement homePageLink;
	
	WebElement womenShoesLink;
	By womenShoesLinkPath = By.xpath("//a[@id='navCategory1']");
	
	WebElement menShoesLink;
	By menShoesLinkPath = By.xpath("//a[@id='navCategory2']");
	
	WebElement kidsShoesLink;
	By kidsShoesLinkPath = By.xpath("//a[@id='navCategory3']");
	
	WebElement sportsShoesLink;
	By sportsShoesLinkPath = By.xpath("//a[@id='navCategory4']");
	
	WebElement loginLink;
	By loginLinkPath = By.xpath("//a[@href='/login']");
	
	WebElement registerLink;
	By registerLinkPath = By.xpath("//a[@href='/signup']");
	
	@FindBy(xpath = "//select[@id='indexBrandSelect']")
	WebElement featuredProductsList;
	
	@FindBy(xpath = "//div[contains(@class, 'shoeData')]")
	List<WebElement> featuredProductItemList;
	
	@FindBy(xpath = "//p[contains(@class, 'navbar-brand-static')]")
	WebElement currentUser;
	
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logoutLink;
	
	@FindBy(xpath = "//a[@href='/cart']")
	WebElement cartLink;
	
	public HomePage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginLink() {
		return driver.findElement(loginLinkPath);
	}

	public WebElement getRegisterLink() {
		return driver.findElement(registerLinkPath);
	}
	
	public boolean isFeaturedProductsListEmpty() {
		Select select = new Select(featuredProductsList);
		
		return select.getOptions().isEmpty();
	}
	
	public boolean isFeaturedProductsItemListEmpty() {
		return featuredProductItemList.isEmpty();
	}

	public WebElement getHomePageLink() {
		wait.until(ExpectedConditions.elementToBeClickable(homePageLink));
		
		return homePageLink;
	}

	public WebElement getWomenShoesLink() {
		return driver.findElement(womenShoesLinkPath);
	}

	public WebElement getMenShoesLink() {
		return driver.findElement(menShoesLinkPath);
	}

	public WebElement getKidsShoesLink() {
		return driver.findElement(kidsShoesLinkPath);
	}

	public WebElement getSportsShoesLink() {
		return driver.findElement(sportsShoesLinkPath);
	}

	public WebElement getCurrentUser() {
		wait.until(ExpectedConditions.visibilityOf(currentUser));
		
		return currentUser;
	}

	public WebElement getLogoutLink() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
		
		return logoutLink;
	}

	public WebElement getCartLink() {
		return cartLink;
	}
}
