package PageObjects;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver ldriver;
	
		//Constructor
		public AddCustomerPage(WebDriver rdriver)    
		{	
			ldriver = rdriver;
			PageFactory.initElements(ldriver, this);			
		}
		
		//Find web elements on web page
		@FindBy(xpath ="//a[@href='#']//p[contains(text(),'Customers')]")		//a[@href='#']//following::p[19]
		WebElement lnkCustomers_menu;
		
		@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
		WebElement lnkCustomers_menuitem;
				
		@FindBy(xpath = "//a[@class='btn btn-primary']")	 
		WebElement btnAddnew;
		
		@FindBy(xpath = "//input[@id='Email']")
		WebElement txtEmail;
		
		@FindBy(xpath = "//input[@id='Password']")
		WebElement txtPassword;
		
		@FindBy(xpath = "//input[@id='FirstName']")
		WebElement txtFirstName;
		@FindBy(xpath = "//input[@id='LastName']")
		WebElement txtLastName;
		
		@FindBy(xpath = "//input[@id='Gender_Male']")
		WebElement MaleGender;
		@FindBy (xpath = "//input[@id='Gender_Female']")
		WebElement FemaleGender;
		
		@FindBy(xpath = "//input[@id='DateOfBirth']")
		WebElement txtDob;
		
		@FindBy(xpath = "//input[@id='Company']")
		WebElement txtCompanyName;
		
		@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")  ////label[text()='Customer roles']//parent::div//following::div[@class='k-multiselect-wrap k-floatwrap']
		WebElement txtCustomerRoles;
		
		@FindBy(xpath = "//li[contains(text(),'Administrators']")
		WebElement listItemAdministrators;
		@FindBy(xpath = "//li[contains(text(),'Registered')]")
		WebElement listItemRegistered;
		@FindBy(xpath = "//li[contains(text(),'Guests')]")
		WebElement listItemGuests;
		@FindBy(xpath = "//li[contains(text(),'Vendors')]")
		WebElement listItemVendors;
		
		@FindBy(xpath = "//select[@id='VendorId']")
		WebElement dropdownmgrVendor;
		
		@FindBy(xpath = "//textarea[@id='AdminComment']")
		WebElement txtAdminComment;
		
		@FindBy(xpath = "//button[@name='save']")
		WebElement btnSave;
		
		///Actions Method For Web Elements/////
		
		public String getPageTitle()
		{
			return ldriver.getTitle();
		}

		public void clickOnCustomersMenu() {
			lnkCustomers_menu.click();
		}

		public void clickOnCustomersMenuItem() {
			lnkCustomers_menuitem.click();
		}

		public void clickOnAddnew() {
			btnAddnew.click();
		}

		public void enterEmail(String email)
		{
			txtEmail.sendKeys(email);
		}

		public void enterPassword(String password)
		{
			txtPassword.sendKeys(password);
		}
		public void enterFirstName(String firstName)
		{
			txtFirstName.sendKeys(firstName);
		}

		public void enterLastName(String lastName)
		{
			txtLastName.sendKeys(lastName);
		}

		public void enterDob(String dob)
		{
			txtDob.sendKeys(dob);
		}

		public void enterCompanyName(String coName)
		{
			txtCompanyName.sendKeys(coName);
		}

		public void enterAdminContent(String content)
		{
			txtAdminComment.sendKeys(content);
		}

		/*public void enterCustomerRoles(String role)  
		{
		}*/

		public void enterManagerOfVendor(String value)
		{
			Select drp=new Select(dropdownmgrVendor);
			drp.selectByVisibleText(value);
		}

		public void enterGender(String gender)
		{
			if(gender.equals("Male"))
			{
				MaleGender.click();
			}
			else if(gender.equals("Female"))
			{
				FemaleGender.click();
			}
			else//default set Male gender
			{
				MaleGender.click();
			}

		}
		public void clickOnSave()
		{
			btnSave.click();
		}

	}
