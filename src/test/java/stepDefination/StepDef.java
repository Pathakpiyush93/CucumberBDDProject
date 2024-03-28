package stepDefination;


import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AddNewCustomer;
import pageObject.LoginPage;
import pageObject.SearchCustomerByEmail;

public class StepDef extends BaseClass{
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
	    
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		loginPage = new LoginPage(driver);
		addNewCustomer = new AddNewCustomer(driver);
		searchCustomerByEmail = new SearchCustomerByEmail(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	   driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailId, String pass) {
		loginPage.enterEmailId(emailId);
		loginPage.enterPassword(pass);
	}

	@When("Click on login")
	public void click_on_login() {
		loginPage.clickOnLogin();
	    
	}

	@Then("Page Title shoud be {string}")
	public void page_title_shoud_be(String title) {
		String titlePg = driver.getTitle();
		Assert.assertTrue(titlePg.equals(title));
	    
	}

	@When("User click on Log Out link")
	public void user_click_on_log_out_link() {
		loginPage.clickOnLogout();
	}

//	@Then("close browser")
//	public void close_browser() {
//	   driver.close();
//	}
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}

	@When("User click on Customer Menu")
	public void user_click_on_customer_menu() {
		addNewCustomer.customerMenu();
	}

	@When("click on Customers Menu Item")
	public void click_on_customers_menu_item() {
		addNewCustomer.customerMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustomer.clickOnAddNewBtn();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		
		
		addNewCustomer.enterEmail(randomEmails()+"@gmail.com");
		addNewCustomer.enterPassword("test@1");
		addNewCustomer.enterFirstName("Piyush");
		addNewCustomer.enterLastName("Pathak");
		addNewCustomer.gender("Male");
		addNewCustomer.enterDOB("11/11/1993");
		addNewCustomer.companyName("HCL Tech");
		addNewCustomer.isTaxExemted();
//		addNewCustomer.selectNewsLetter();
		addNewCustomer.selectVendorId("Vendor 2");
		addNewCustomer.addAdminComment("Admin");
		
	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustomer.clickOnSaveBtn();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		String actualMsg = driver.findElement(By.tagName("body")).getText();
		String expectedMsg = "The new customer has been added successfully.";
		Assert.assertTrue(actualMsg.contains(expectedMsg));
	}
	
	@When("Enter customer Email")
	public void enter_customer_email() {
		searchCustomerByEmail.enterEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchCustomerByEmail.clickOnSearchBtn();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		List<WebElement> actualEmailList = searchCustomerByEmail.verifyEmailInTable("victoria_victoria@nopCommerce.com");
		String expectedEmail = "victoria_victoria@nopCommerce.com";
		for(WebElement email:actualEmailList) {
			if(expectedEmail.contains(email.getText())) {
				
			}
		}
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
		final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot,"image/png",scenario.getName());
		}
	}

	


}
