package runner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
@CucumberOptions(
		features = "D:\\New_Workspace\\mvncucumtng\\src\\test\\resources\\feature\\google.feature"
		, glue={"stepdefns"}
		, plugin= {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"}
		, monochrome=true
		, dryRun=false	
		)
public class Runner {
	public static WebDriver driver;
	private TestNGCucumberRunner testRunner;
	@BeforeClass
	public void setUP()
	{
		testRunner = new TestNGCucumberRunner(Runner.class);
		System.out.println("testRunner:"+testRunner);
		
	}
	@Test(dataProvider="features")
	public void HomeLoan(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}
	@DataProvider(name="features")
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
	}
	@AfterClass
	public void tearDown()
	{
		testRunner.finish();
	}
}