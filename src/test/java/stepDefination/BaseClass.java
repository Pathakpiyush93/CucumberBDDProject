package stepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObject.AddNewCustomer;
import pageObject.LoginPage;
import pageObject.SearchCustomerByEmail;

public class BaseClass {


	public static WebDriver driver;
	public LoginPage loginPage;
	public AddNewCustomer addNewCustomer;
	public SearchCustomerByEmail searchCustomerByEmail;


public String randomEmails() {
	
	String email = RandomStringUtils.randomAlphabetic(5);
	return email;
	
}
}