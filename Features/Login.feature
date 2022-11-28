Feature: Login

@Sanity 
Scenario: Successful Login with valid credentials
			Given User Launch chrome browser
			When User opens URL "https://admin-demo.nopcommerce.com/login"
			And User enters Email as "admin@yourstore.com" and Password as "admin"
			And Click on login
			Then Page Title should be "Dashboard / nopCommerce administration"
			When User click on logout link
			Then Page Title should be "Your store. Login"
			And close browser

@Regression			
Scenario Outline:  Successful Login with valid credentials
			Given User Launch chrome browser
			When User opens URL "https://admin-demo.nopcommerce.com/login"
			And User enters Email as "<email>" and Password as "<password>"
			And Click on login
			Then Page Title should be "Dashboard / nopCommerce administration"
			When User click on logout link
			Then Page Title should be "Your store. Login"
			And close browser			
			
Examples:
	| email | password|
	| admin@yourstore.com | admin |
	| test@yourstore.com | admin |			