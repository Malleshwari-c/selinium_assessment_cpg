package Final_Assessment;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestCase1 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//click element 1
		WebElement ele1=driver.findElement(By.xpath("(//input[@class='w-0 h-0 opacity-0 absolute'])[1]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].removeAttribute('disabled');", ele1);
		js.executeScript("arguments[0].click();", ele1);
		Thread.sleep(1000);
		//click element 2
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		WebElement ele2=driver.findElement(By.xpath("(//input[@class='w-0 h-0 opacity-0 absolute'])[2]"));
		Thread.sleep(1000);
		js1.executeScript("arguments[0].removeAttribute('disabled');", ele2);
		js1.executeScript("arguments[0].click();", ele2);
		Thread.sleep(1000);
		//click element 3
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		WebElement ele3=driver.findElement(By.xpath("(//input[@class='w-0 h-0 opacity-0 absolute'])[3]"));
		Thread.sleep(1000);
		js2.executeScript("arguments[0].removeAttribute('disabled');", ele3);
		js2.executeScript("arguments[0].click();", ele3);
		Thread.sleep(1000);
		//click element 4
		JavascriptExecutor js3=(JavascriptExecutor)driver;
		WebElement ele4=driver.findElement(By.xpath("(//input[@class='w-0 h-0 opacity-0 absolute'])[4]"));
		Thread.sleep(1000);
		js3.executeScript("arguments[0].removeAttribute('disabled');", ele4);
		js3.executeScript("arguments[0].click();", ele4);
		Thread.sleep(1000);
		//click place order
		driver.findElement(By.id("togglers")).click();
		String text=driver.findElement(By.cssSelector("[class='text-lg text-orange-600 font-bold text-center']")).getText();
		if(text.equals("ORDER PLACED")) {
			System.out.println("order placed succesfully");
		}
		Thread.sleep(1000);
		driver.quit();
	}

}
