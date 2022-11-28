package stepDefinitions;

import io.cucumber.java.en.Then;

public class CloseBrowser extends BaseClass{
		
	@Then("close browser")
	public void close_browser() {
	   driver.quit();
	   log.info("Browser Closed......");
	}
}
