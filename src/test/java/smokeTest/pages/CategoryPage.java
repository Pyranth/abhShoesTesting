package smokeTest.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CategoryPage extends DefaultPage {
	@FindBy(xpath = "//div[contains(@class, 'shoeData')]")
	List<WebElement> shoeItems;
	
	@FindBy(xpath = "//div[@id='categoryShoeFilter']/form")
	WebElement filterForm;
	
	@FindBy(xpath = "//select[@id='brand']")
	WebElement brandSelect;
	
	@FindBy(xpath = "//select[@id='size']")
	WebElement sizeSelect;
	
	@FindBy(xpath = "//select[@id='color']")
	WebElement colorSelect;
	
	@FindBy(xpath = "//select[@id='style']")
	WebElement styleSelect;
	
	@FindBy(xpath = "//select[@id='price_range']")
	WebElement priceRangeSelect;
	
	@FindBy(xpath = "//input[@id='formButtonBuy']")
	WebElement searchButton;
	
	public CategoryPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getShoeItems() {
		return shoeItems;
	}

	public WebElement getFilterForm() {
		wait.until(ExpectedConditions.visibilityOf(filterForm));
		
		return filterForm;
	}

	public WebElement getBrandSelect() {
		return brandSelect;
	}

	public WebElement getSizeSelect() {
		return sizeSelect;
	}

	public WebElement getColorSelect() {
		return colorSelect;
	}
	
	public WebElement getStyleSelect() {
		return styleSelect;
	}

	public WebElement getPriceRangeSelect() {
		return priceRangeSelect;
	}
	
	public void setBrand(String brand)
	{
		Select select = new Select(getBrandSelect());
		
		select.selectByVisibleText(brand);
	}
	
	public void setSize(String size)
	{
		Select select = new Select(getSizeSelect());
		
		select.selectByVisibleText(size);
	}
	
	public void setColor(String color)
	{
		Select select = new Select(getColorSelect());
		
		select.selectByVisibleText(color);
	}
	
	public void setStyle(String style)
	{
		Select select = new Select(getStyleSelect());
		
		select.selectByVisibleText(style);
	}
	
	public void setPriceRange(String price)
	{
		Select select = new Select(getPriceRangeSelect());
		
		select.selectByVisibleText(price);
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
}
