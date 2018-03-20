package smokeTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends DefaultPage {
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@id='formButton']")
	WebElement buttonSubmit;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	public void insertEmail(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void insertPassword(String pass)
	{
		passwordField.sendKeys(pass);
	}
	
	public void submitLogin()
	{
		buttonSubmit.click();
	}

	public WebElement getEmailField() {
		wait.until(ExpectedConditions.visibilityOf(emailField));
		
		return emailField;
	}

	public WebElement getPasswordField() {
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		
		return passwordField;
	}

	public WebElement getButtonSubmit() {
		wait.until(ExpectedConditions.visibilityOf(buttonSubmit));
		
		return buttonSubmit;
	}
}
