package keyWordDriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sauce_keyWordI {
	
	WebDriver driver;
	
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void openurl() {
		driver.get("https://www.saucedemo.com/");
	}
	
	public void userName() {
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
	}
	
	public void password() {
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	public void loginB() throws InterruptedException {
		driver.findElement(By.id("login-button")).click();
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
	}
	
	public void closeBw() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}


}
