package stepDefinitions;


import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import utilities.ReadConfig;

import org.apache.logging.log4j.*;

//parent class
public class BaseClass {
		
	public static  WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addnewcus;
	public SearchCustomerPage searchcuspg;
	public static Logger log;
	public ReadConfig 	readConfig;
	
	//To Generate Random Email id for add new customer 
	public String generateEmailId()
	{
		return (RandomStringUtils.randomAlphabetic(6));
		
		
	}
}
