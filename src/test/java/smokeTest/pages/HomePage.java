package smokeTest.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends DefaultPage{
	@FindBy(xpath = "//a[contains(@class, 'navbar-brand')]")
	WebElement homePageLink;
	
	@FindBy(xpath = "//a[@id='navCategory1']")
	WebElement womenShoesLink;
	
	@FindBy(xpath = "//a[@id='navCategory2']")
	WebElement menShoesLink;
	
	@FindBy(xpath = "//a[@id='navCategory3']")
	WebElement kidsShoesLink;
	
	@FindBy(xpath = "//a[@id='navCategory4']")
	WebElement sportsShoesLink;
	
	@FindBy(xpath = "//a[@href='/login']")
	WebElement loginLink;
	
	@FindBy(xpath = "//a[@href='/signup']")
	WebElement registerLink;
	
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
		wait.until(ExpectedConditions.elementToBeClickable(loginLink));
		
		return loginLink;
	}

	public WebElement getRegisterLink() {
		wait.until(ExpectedConditions.elementToBeClickable(registerLink));
		
		return registerLink;
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
		wait.until(ExpectedConditions.elementToBeClickable(womenShoesLink));
		
		return womenShoesLink;
	}

	public WebElement getMenShoesLink() {
		wait.until(ExpectedConditions.elementToBeClickable(menShoesLink));
		
		return menShoesLink;
	}

	public WebElement getKidsShoesLink() {
		wait.until(ExpectedConditions.elementToBeClickable(kidsShoesLink));
		
		return kidsShoesLink;
	}

	public WebElement getSportsShoesLink() {
		wait.until(ExpectedConditions.elementToBeClickable(sportsShoesLink));
		
		return sportsShoesLink;
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
