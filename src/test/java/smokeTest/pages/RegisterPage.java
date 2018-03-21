package smokeTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends DefaultPage {
	@FindBy(xpath = "//input[@id='user_email']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@id='user_password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@id='user_password_confirmation']")
	WebElement repeatedPasswordField;
	
	@FindBy(xpath = "//input[@id='formButton']")
	WebElement buttonSubmit;
	
	@FindBy(xpath = "//div[@id='error_explanation']")
    WebElement errorMessage;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	public void insertEmail(String email)
	{
		getEmailField().sendKeys(email);
	}
	
	public void insertPassword(String pass)
	{
		getPasswordField().sendKeys(pass);
	}
	
	public void insertRepeatedPassword(String pass)
	{
		getRepeatedPasswordField().sendKeys(pass);
	}

	public void submitRegister()
	{
		getButtonSubmit().click();
	}

	public WebElement getErrorMessage() {
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		
		return errorMessage;
	}

	public WebElement getEmailField() {
		wait.until(ExpectedConditions.visibilityOf(emailField));
		
		return emailField;
	}

	public WebElement getPasswordField() {
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		
		return passwordField;
	}

	public WebElement getRepeatedPasswordField() {
		wait.until(ExpectedConditions.visibilityOf(repeatedPasswordField));
		
		return repeatedPasswordField;
	}

	public WebElement getButtonSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
		
		return buttonSubmit;
	}
}
