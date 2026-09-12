/*
TestCase-1
Launch SauceDemo.
Login using the valid credentials provided on the application.
On the Products page, use JavaScript Executor to scroll to the bottom of the page.
Take a screenshot of the page after scrolling.
Save the screenshot with a meaningful name such as products-page.png.
*/
//Assessment 1 test case 1
package assessment;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotTest 
{
	public static void main(String[] args) throws Exception {
        //launch browser
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//naviagte to url
        driver.get("https://www.saucedemo.com/");
		//login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //scroll down
        JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//take screenshot
		TakesScreenshot tks = (TakesScreenshot) driver;
		//save to the file
		File src = tks.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/products-page.png");
		FileHandler.copy(src, dest);
		Thread.sleep(3000);
		//close
		driver.quit();
}
}
