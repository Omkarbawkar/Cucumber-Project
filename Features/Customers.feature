Feature: Customers
Background: User Already Login  
			Given User Launch chrome browser
			When User opens URL "https://admin-demo.nopcommerce.com/login"
			And User enters Email as "admin@yourstore.com" and Password as "admin"
			And Click on login
			Then User can view Dashboard

@Sanity
Scenario: Add New Customer			
			When User click on customers Menu
			And Click on customers Menu Item
			And Click on Add new button
			Then User can view add new customers page
			When User enters customers info
			And Click on Save button
			Then User can view confirmation message "The new customer has been added successfully."
			And close browser

@Sanity
Scenario: Search Customer by Email			
			When User click on customers Menu
			And Click on customers Menu Item
			And Enter Customers Email
			When Click on search button
			Then User should found Email in the Search table
			And close browser
			
@Regression
Scenario: Search Customer by Name		
			When User click on customers Menu
			And Click on customers Menu Item		
			And Enter customer FirstName
			And Enter customer LastName
			When Click on search button
			Then User should found Name in the Search table
			And close browser