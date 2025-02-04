#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login
@Sanity
Scenario: Successful login with valid Credentials
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on login
	Then Page Title shoud be "Dashboard / nopCommerce administration"
	When User click on Log Out link
	Then Page Title shoud be "Your store. Login"
	And close browser
	
@Regression
Scenario Outline:Successful login with valid and invalid Credentials Data Driven Testing(DDT)
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "<email>" and Password as "<password>"
	And Click on login
	Then Page Title shoud be "Dashboard / nopCommerce administration"
	When User click on Log Out link
	Then Page Title shoud be "Your store. Login"
	And close browser
	
Examples:
|email|password|
|admin@yourstore.com|admin|
|test@yourstore.com|admin|

 