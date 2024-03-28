Feature: Customer
Background: Common steps for all scenarios
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on login
	Then User can view Dashboard

@Sanity
Scenario: Add New Customer

	When User click on Customer Menu
	And click on Customers Menu Item
	And click on Add new button
	Then User can view Add new customer page
	When User enter customer info
	And click on Save button
	Then User can view confirmation message "The new customer has been added successfully."
	And close browser
	
@Regression
Scenario: Search Customer By Email
	
	When User click on Customer Menu
	And click on Customers Menu Item
	And Enter customer Email
	When Click on search button
	Then User should found Email in the Search table
	And close browser
	
