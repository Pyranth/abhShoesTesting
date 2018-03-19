package smokeTest.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage extends DefaultPage {
	@FindBy(xpath = "//div[contains(@class, 'shoeData')]")
	List<WebElement> shoeItems;
	
	@FindBy(xpath = "//div[@id='categoryShoeFilter']/form")
	WebElement filterForm;
	
	public CategoryPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getShoeItems() {
		return shoeItems;
	}

	public WebElement getFilterForm() {
		return filterForm;
	}
}
