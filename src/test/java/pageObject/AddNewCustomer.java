package pageObject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCustomer {

	WebDriver driver;
	public AddNewCustomer(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='nav-icon far fa-user']/parent::a")
	WebElement customerMenu;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customerMenuItem;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/Create']")
	WebElement addNewBtn;
	
	@FindBy(id = "Email")
	WebElement emailId;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(id = "FirstName")
	WebElement firstName;
	
	@FindBy(id = "LastName")
	WebElement lastName;
	
	@FindBy(id = "Gender_Male")
	WebElement gender_Male;
	
	@FindBy(id = "Gender_Female")
	WebElement gender_Female;
	
	@FindBy(id = "DateOfBirth")
	WebElement dateOfBirth;
	
	@FindBy(id = "Company")
	WebElement companyName;
	
	@FindBy(id = "IsTaxExempt")
	WebElement isTaxExempt;
	
	@FindBy(id = "SelectedNewsletterSubscriptionStoreIds_taglist")
	WebElement newsLetter;
	
	@FindBy(xpath = "//li[contains(text(),'Test store 2')]")
	WebElement newsLetterOption2;
	
	@FindBy(id = "VendorId")
	WebElement vendorId;
	
	@FindBy(id = "AdminComment")
	WebElement adminComment;
	
	@FindBy(name = "save")
	WebElement saveBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	WebElement confirmationmsg;
	
	public void customerMenu() {
		customerMenu.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(customerMenuItem));
		}
	
	public void customerMenuItem() {
		customerMenuItem.click();
	}
	
	public void clickOnAddNewBtn() {
		addNewBtn.click();
	}
	
	public void enterEmail(String email) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(emailId));
		
		emailId.sendKeys(email);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void gender(String gender) {
		if(gender.equals("Male")) {
			gender_Male.click();
		}
		else if(gender.equals("Female")) {
			gender_Female.click();
		}
		else {
			gender_Male.click();
		}
	}
	
	public void enterDOB(String dob) {
		dateOfBirth.sendKeys(dob);
	}
	
	public void companyName(String cname) {
		companyName.sendKeys(cname);
	}
	
	public void isTaxExemted() {
		isTaxExempt.click();
	}
	
//	public void selectNewsLetter() {
//		newsLetter.click();
//		newsLetterOption2.click();
//	}
	
	public void selectVendorId(String vendor) {
		Select select = new Select(vendorId);
		select.selectByVisibleText(vendor);
	}
	
	public void addAdminComment(String comment) {
		adminComment.sendKeys(comment);
	}
	
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
	
//	public String confirmationMessege() {
//		String confMsg = confirmationmsg.getText();
//		return confMsg;
//	}
}
