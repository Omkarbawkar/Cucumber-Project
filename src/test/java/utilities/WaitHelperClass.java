package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelperClass {

	public WebDriver driver;
	
	
	public WaitHelperClass(WebDriver driver) {
		this.driver=driver;
	}
	
	public void WaitForElement(WebElement element,Duration timeOutInSeconds) {
		WebDriverWait wait =new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
