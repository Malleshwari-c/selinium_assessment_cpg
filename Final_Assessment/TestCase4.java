package Final_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.shoppersstack.com/");
		Thread.sleep(2000);
		//find the product
		driver.findElement(By.xpath("(//div[@class='featuredProducts_cardBody__l4gLE'])[2]")).click();
		Thread.sleep(1000);
		//send pin code
		driver.findElement(By.xpath("//input[@id='Check Delivery']")).sendKeys("234567");
		Thread.sleep(1000);
		//click on check button
		WebElement check=driver.findElement(By.xpath("//button[@id='Check']"));
		check.click();
		//verification
		String st=driver.findElement(By.xpath("//p[text()='Not Deliveriable.']")).getText();
		System.out.println(st);
		Thread.sleep(2000);
		driver.quit();
	}

}
