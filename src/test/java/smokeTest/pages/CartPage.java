package smokeTest.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends DefaultPage {
	@FindBy(xpath = "//div[contains(@class, 'order-item')]")
	List<WebElement> cartItems;
	
	@FindBy(xpath = "//div[@id='receipt-price']")
	WebElement receiptData;
	
	@FindBy(xpath = "//a[@id='cart-button-continue1']")
	WebElement continueButton;
	
	@FindBy(xpath = "//div[contains(@class, 'address-form-div')]")
	WebElement shipmentForm;

	@FindBy(xpath = "//input[contains(@class, 'cart-button-continue')]")
	WebElement shipmentContinueButton;
	
	@FindBy(xpath = "//div[contains(@class, 'addressReview')]")
	List<WebElement> addressInfo;
	
	@FindBy(xpath = "//button[contains(@class, 'stripe-button-el')]")
	WebElement payButton;
	
	public CartPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getCartItems() {
		return cartItems;
	}

	public WebElement getReceiptData() {
		return receiptData;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getShipmentForm() {
		return shipmentForm;
	}

	public WebElement getShipmentContinueButton() {
		return shipmentContinueButton;
	}

	public List<WebElement> getAddressInfo() {
		return addressInfo;
	}

	public WebElement getPayButton() {
		return payButton;
	}
}
