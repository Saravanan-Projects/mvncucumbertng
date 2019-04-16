package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	WebDriver driver;
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void toLoadURL(String url) {
		driver.get(url);
	}
	
	public String toVerify() {
		return driver.getTitle();
	}
	
}
