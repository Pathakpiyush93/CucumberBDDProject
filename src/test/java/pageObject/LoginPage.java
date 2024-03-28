package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Email")
	WebElement userEmail;
	
	@FindBy(id="Password")
	WebElement userPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logoutBtn;
	
	public void enterEmailId(String email) {
		userEmail.clear();
		userEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		userPassword.clear();
		userPassword.sendKeys(password);
	}
	
	public void clickOnLogin() {
		submitBtn.click();
	}
	
	public void clickOnLogout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(logoutBtn));
		logoutBtn.click();
	}
}
