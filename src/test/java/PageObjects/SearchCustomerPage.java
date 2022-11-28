package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelperClass;

public class SearchCustomerPage {

public WebDriver ldriver;
public WaitHelperClass waithelper;
	
	public  SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements( rdriver,this);
		waithelper=new WaitHelperClass(rdriver);
	}
	
	@FindBy (id = "SearchEmail")
	WebElement emailAdd;
	
	@FindBy(id = "search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement searchResult;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr")
	List<WebElement> tableRows;
	
//	@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr//td")  //Not in use
//	List<WebElement> tableColunm;
	
	@FindBy(id="SearchFirstName")
	WebElement firstName;
	@FindBy(id="SearchLastName")
	WebElement lastName;
	
	//Action Method to enter Email id
	public void enterEmailAdd(String email)
	{	
		emailAdd.sendKeys(email);
	}
	
	//Action method for click on search button
	public void clickOnSearchButton()
	{
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//	    js.executeScript("arguments[0].click();", )
	    searchBtn.click();
	}
	
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean found = false;
		
		
		//total no. of rows
		int totalRows=tableRows.size();
		
		//total no. of columns
//		int totalColumns=tableColunm.size();
		
		//Use of for loop to fetch the all rows
		
		for(int i=1;i<=totalRows;i++) //to iterate all the rows of the table //first row is header so  we put i=1
		{
			 WebElement WebElementEmail = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+ i + "]//td[2]"));
			 String actualEmailAdd= WebElementEmail.getText();
			 if(actualEmailAdd.equals(email))
			 {
				 found = true;
			 }
		}
		return found;
	}
	
/////////////////Search Customer by Name//////////////////////////////
	//Enter First Name and Last Name actions///
	
	public void enterFirstName(String firstname)
	{
		firstName.sendKeys(firstname);
	}
	public void enterLastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	
	public boolean searchCustomerByName(String name)
	{
		boolean found = false;
		
		
		//total no. of rows
		int totalRows=tableRows.size();
		
		//total no. of columns                 //not in use
//		int totalColumns=tableColunm.size();
		
		//Use of for loop to fetch the all rows
		
		for(int i=1;i<=totalRows;i++) //to iterate all the rows of the table //first row is header so  we put i=1
		{
			 WebElement WebElementName = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+ i + "]//td[3]"));
			 String actualName= WebElementName.getText();
			 if(actualName.equals(name))
			 {
				 found = true;
				 break;
			 }
		}
		return found;
	}
	
}
