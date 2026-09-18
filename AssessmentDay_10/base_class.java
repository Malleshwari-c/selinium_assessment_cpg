package ass_9;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import Assessment_Day9_POMFiles.login_page;

public class ass_9 extends Common_data{
	protected WebDriver driver=null;
	@BeforeSuite
	public void Bs() {
		System.out.println("Open database connectivity");
	}
	@BeforeTest
	public void Bt() {
		System.out.println("Pre-condition");
	}
	@BeforeClass
	public void Bc() throws IOException {
		cdata();
		if(BROWSER.equals("chrome")) {
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver=new ChromeDriver(settings);
		}
		if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Launch Browser");
	}
	@BeforeMethod
	public void Bm() {
		driver.get(URL);
		login_page lp=new login_page(driver);
		lp.login(USERNAME, PASSWORD);

	}

	@AfterMethod
	public void Am() {
		System.out.println("Logout executed");
	}
	@AfterClass
	public void Ac() {
		driver.quit();
		System.out.println("Close the browser");
	}
	@AfterTest
	public void At() {
		System.out.println("post-condition");
	}
	@AfterSuite
	public void As() {
		System.out.println("cloase the database");
	}
}


