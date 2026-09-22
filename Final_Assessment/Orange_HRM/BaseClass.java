package final_ass_POMFiles;

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

import Assess12_testcase2.login_page12;

public class base_class extends commonDataf{
	protected WebDriver driver=null;
	@BeforeSuite
	public void bs() {
		System.out.println("Open database connectivity");

	}
	@BeforeTest
	public void bt() {
		System.out.println("Pre-conditions");
	}
	@BeforeClass
	public void Bc() throws IOException {
		bowser();
		if(BROWSER.equals("chrome")) {
			ChromeOptions settings=new ChromeOptions();
			Map<String, Object> prefs=new HashMap<>();
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
			login_page12 lp=new login_page12(driver);
			lp.lPage(USERNAME, PASSWORD);
		}
		
		@AfterMethod
		public void Am() {
			System.out.println("log-out succesfully");
		}
		
		@AfterClass
		public void Ac() {
			driver.quit();
			System.out.println("Close the browser");
		}
		@AfterTest
		public void At() {
			System.out.println("Post conditions");
		}
		@AfterSuite
		public void As() {
			System.out.println("close database connectivity");
		}
}

