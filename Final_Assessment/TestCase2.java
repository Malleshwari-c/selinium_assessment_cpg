package Final_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
		//find element
		WebElement ele=driver.findElement(By.id("slide"));
		ele.sendKeys(Keys.ARROW_RIGHT);
		Thread.sleep(1000);
		ele.sendKeys(Keys.ARROW_RIGHT);
		Thread.sleep(1000);
		ele.sendKeys(Keys.ARROW_RIGHT);
		Thread.sleep(1000);
		//verification
		String verify=driver.findElement(By.xpath("//h3[text()='Mens Cotton Jacket']")).getText();
		if (verify.equals("Mens Cotton Jacket...")) {
			System.out.println("verified succesfully");
		}
		Thread.sleep(1000);
		driver.quit();
	}

}
