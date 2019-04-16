package stepdefns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.GooglePage;

public class GoogleStepDefn {
	WebDriver driver;
	GooglePage GPObj = null;
	@Given("^Load the webbrowser$")
	public void load_the_webbrowser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\TestingJar\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		GPObj = new GooglePage(driver);
	}

	@When("^Navigate to google.com$")
	public void navigate_to_google_com() throws Throwable {
		GPObj.toLoadURL("https://www.google.com/");
	}

	@Then("^Verify the page$")
	public void verify_the_page() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(GPObj.toVerify(),"Google");
		softAssertion.assertAll();
	}
	
	@Then("^Close the Browser$")
	public void close_the_Browser() throws Throwable {
		driver.close();
	}

}
