package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCustomerByEmail{
	
	WebDriver driver;
	public SearchCustomerByEmail(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "SearchEmail")
	WebElement email;
	
	@FindBy(id = "search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr/td[2]")
	List <WebElement> emailsList;
	
	public void enterEmail(String emailId) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(emailId);
	}
	
	public void clickOnSearchBtn() {
		searchBtn.click();
	}
	
	public List<WebElement> verifyEmailInTable(String emailId) {
		return emailsList;
		}
	}


