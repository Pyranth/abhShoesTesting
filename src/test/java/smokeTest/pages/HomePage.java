package smokeTest.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	public HomePage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}
	
	public boolean isFeaturedProductsListEmpty()
	{
		Select select = new Select(featuredProductsList);
		
		return select.getOptions().isEmpty();
	}
	
	public boolean isFeaturedProductsItemListEmpty()
	{
		return featuredProductItemList.isEmpty();
	}

	public WebElement getHomePageLink() {
		return homePageLink;
	}

	public WebElement getWomenShoesLink() {
		return womenShoesLink;
	}

	public WebElement getMenShoesLink() {
		return menShoesLink;
	}

	public WebElement getKidsShoesLink() {
		return kidsShoesLink;
	}

	public WebElement getSportsShoesLink() {
		return sportsShoesLink;
	}
}
