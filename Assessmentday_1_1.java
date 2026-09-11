/*
TestCase-1
Launch SauceDemo.
Login using the valid credentials provided on the application.
On the Products page, use JavaScript Executor to scroll to the bottom of the page.
Take a screenshot of the page after scrolling.
Save the screenshot with a meaningful name such as products-page.png.
*/
//Assessment 1 test case 1
package assessments;

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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		TakesScreenshot tks = (TakesScreenshot) driver;
		
		File src = tks.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/products-page.png");
		FileHandler.copy(src, dest);
		Thread.sleep(3000);
		
		driver.quit();
}
}
