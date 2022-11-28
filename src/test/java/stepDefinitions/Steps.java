package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;



public class Steps extends BaseClass{
	
	@Before("@Sanity")  //Conditional Hook we can associate hooks with tags for conditional execution.
	public void setUp() throws IOException {
		
		//initialize properties file & read the config.properties file
		readConfig = new ReadConfig();	
		
		
		//Initialize Logger
		log =LogManager.getLogger("Steps");
		System.out.println("setUp Sanity Method Executed");
		
		
		//Based on browser we launch browser
		String browser=readConfig.getBrowser(); //browser key is k-sensitive
		
		
		//launch browser
				switch(browser.toLowerCase())
				{
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;

				case "msedge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				default:
					driver = null;
					break;

				}
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    log.info("SetUp 1 log executed.........");
	}
	
	@Before("@Regression")  //This setup runs only for regression scenario
	public void setUp2() {
		
		System.out.println("setUp Regression Method Executed");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    log.info("SetUp 2 log executed.........");
	}
	
	
	
	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() {
		lp = new LoginPage(driver);
		addnewcus = new AddCustomerPage(driver);  //webdriver object 2nd method
		searchcuspg = new SearchCustomerPage(driver); //webdriver initilize for SearchCustomerPage
		log.info("User Launch Chrome Browser.....");
	}
	@When("User opens URL {string}")
	public void user_opens_url(String url)  {	   
		driver.get(url);
		log.info("Url Opened.........");
		
	}
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String password)  {
		lp.SetUserName(emailAdd);
	    lp.SetPassword(password);
	    log.info("Entering Email Adress and Password.........");
	}
	@When("Click on login")
	public void click_on_login() throws InterruptedException {
	    lp.clickLogin();
	    log.info("Log in Button Click.........");
	    Thread.sleep(3000);
	}
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	  String actulTitle = driver.getTitle();
	  if(actulTitle.equals(title))
	  {
		  log.info("Login Feature : Page Title Match......");
		  Assert.assertTrue(true); //pass
	  }
	  else
	  {		 
		  Assert.assertTrue(false); //fail
		  log.warn("Login Feature :Page Title Not Match......");
	  }
		   
	}
	@When("User click on logout link")
	public void user_click_on_logout_link() {
	   lp.clickLogout();
	   log.info("User Click on logout link......");
	}
	

	
//////////////////////////////Add New Customers ///////////////////////////
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    String actualTitle = addnewcus.getPageTitle();
	    String expectedTitle = "Dashboard / nopCommerce administration";
	    if(actualTitle.equals(expectedTitle)) 
	    {
	    	log.info("user can view dashboard test pass......");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    	log.warn("user can view dashboard test gail......");
	    }
	}
	
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
	    addnewcus.clickOnCustomersMenu();
	    log.info("User click on customers Menu Button......");
	    Thread.sleep(3000);
	}
	@When("Click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
	   addnewcus.clickOnCustomersMenuItem();
	   log.info("User Click on customers Menu Item Button......");
	   Thread.sleep(3000);
	}
	
	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
	    addnewcus.clickOnAddnew();
	    Thread.sleep(3000);
	    log.info("User Click on Add new button......");
	}
	@Then("User can view add new customers page")
	public void user_can_view_add_new_customers_page() {
	  String actualTitle= addnewcus.getPageTitle();
	  String expectedTitle="Add a new customer / nopCommerce administration";
	  if(actualTitle.equals(expectedTitle)) 
	    {
		    log.info("User can view add new customers page pass......");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    	 log.warn("User can view add new customers page fail......");
	    }
	}
	
	@When("User enters customers info")
	public void user_enters_customers_info() {
//	  addnewcus.enterEmail("test11@gmail.com");
		addnewcus.enterEmail(generateEmailId() + "@gmail.com");  //This method invokes the random email id method present in base class
		
	  addnewcus.enterPassword("test1");
	  addnewcus.enterFirstName("Omkar");
	  addnewcus.enterLastName("Bawkar");
	  addnewcus.enterGender("Male");
	  addnewcus.enterDob("9/16/1996");
	  addnewcus.enterCompanyName("Utkarshaaacademy");
	  addnewcus.enterAdminContent("Spiderman is Best");
	  addnewcus.enterManagerOfVendor("Vendor 2");
	  
	  log.info("User enters customers info ......");
	}
	
	@When("Click on Save button")
	public void click_on_save_button() throws InterruptedException {
	   addnewcus.clickOnSave();
	   Thread.sleep(3000);
	   log.info("User enters customers info ......");
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedconmsg) {
	   String bodyTagText = driver.findElement(By.tagName("Body")).getText();
	   if(bodyTagText.contains(expectedconmsg)) 
	    {
		   log.info("User can view confirmation message test pass......");
	    	Assert.assertTrue(true); //pass
	    }
	    else
	    {
	    	Assert.assertTrue(false); //fail
	    	log.warn("User can view confirmation message fail......");
	    }
	}
	
///////Step for Search Customer by Email////////////////////////////////
	
	@When("Enter Customers Email")
	public void enter_customers_email() {
	   searchcuspg.enterEmailAdd("victoria_victoria@nopCommerce.com");
	   log.info("Enter Customers Email......");
	}
	
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {	    		
		searchcuspg.clickOnSearchButton();
		Thread.sleep(3000);
		log.info("Click on search button......");
	}
	
	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
	   String expectedEmail ="victoria_victoria@nopCommerce.com";
	   Assert.assertTrue(searchcuspg.searchCustomerByEmail(expectedEmail));
	}
	
////////////////Search customer by name///////////////////////////////////////////////////////
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchcuspg.enterFirstName("Victoria");
		log.info("Enter customer FirstName......");
	}
	@When("Enter customer LastName")
	public void enter_customer_last_name() throws InterruptedException {
		searchcuspg.enterLastName("Terces");
		Thread.sleep(3000);
		log.info("Enter customer LastName......");
	}
	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName ="Victoria Terces";
//		   Assert.assertTrue(searchcuspg.searchCustomerByName(expectedName));
		if(searchcuspg.searchCustomerByName(expectedName) ==true)
	{
		log.info("User should found Name in the Search table - pass......");	
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
		log.warn("User should found Name in the Search table - fail......");	
	}
	}
	
	//Take Screen Shots
/*	@After
	public void teardown(Scenario sc) throws IOException {
		System.out.println("Tear Down Method Executed");
		if(sc.isFailed()==true)
		{
			//Convert Web driver object to TakeScreenShot
			
			String file= "C:\\Users\\Omkar\\eclipse-workspace\\Cucumber_Project\\ScreenShots\\FailedTest.png";
			TakesScreenshot scrShot=(TakesScreenshot)driver;
			
			//Call getScreenShotAs Method to create image file
			File Scrfile=scrShot.getScreenshotAs(OutputType.FILE);
			
			//Move Image file to new  destination
			File DestFile=new File(file);
			
			//Copy File at destination
			FileUtils.copyFile(Scrfile, DestFile);
			
		}
		driver.quit();		
	}     */
	
	
	
	
	
	//This will capture every test step screenshot
	
	
	@AfterStep  //This method runs after every test step in scenario
	public void addScreenshot(Scenario scenario){
		if(scenario.isFailed())
		{
		
		//byte array 
		final byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType. BYTES);
		
		//attach image file report(data,media type,name of the attachment)
		scenario.attach(screenshot, "image/png", scenario.getName());
		
		}
	}
}
		
		
		
		
		
/*	@After
	public void teardown2() {
		System.out.println("Tear Down 2 Method Executed");
		driver.quit();		
	}
	
/*	@BeforeStep                  //it will execute before each scenario test steps
	public void beforeStepMethodDemo()
	{
		System.out.println("This is before step");
	}
	
	
	@AfterStep             //it will execute after each scenario test steps
	public void afterStepMethodDemo()
	{
		System.out.println("This is after step");
	}    */

