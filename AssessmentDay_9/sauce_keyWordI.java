package keyWordDriven;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sauce_keyWordI {
	// create driver as global variable 
	WebDriver driver;
	//create a method for launching the browser
	public void launchBrowser() {
    //launch chrome browser
		driver=new ChromeDriver();
    //maximize the browser
		driver.manage().window().maximize();
    //give implicit time for waiting
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	// craete the openurl method use get
	public void openurl() {
		driver.get("https://www.saucedemo.com/");
	}
	//create the userName method using the element id and sending username
	public void userName() {
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
	}
	//create the password method using the element id and sending password
	public void password() {
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
  //create the login method using the element id and clicking it
	public void loginB() throws InterruptedException {
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}
	//create the closing browser method using quit method
	public void closeBw() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
