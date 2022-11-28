package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		
	public WebDriver ldriver;
	
	public  LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements( rdriver,this);
	}
	
	@FindBy(id = "Email") 
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id =  "Password") 
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[text()='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[text()='Logout']")
	@CacheLookup
	WebElement lnktLogout;
	
	public void SetUserName(String emailAdd)
	{	
		txtEmail.clear();
		txtEmail.sendKeys(emailAdd);		
	}
	public void SetPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin() {
		btnLogin.click();
	}
	public void clickLogout()
	{
		lnktLogout.click();
	}
}
