package Final_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase3 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
		//find laptop elements
		WebElement elel1 = driver.findElement(By.id("dragElement1"));
		elel1.click();
		WebElement elel2 = driver.findElement(By.id("dragElement3"));
		elel2.click();
		WebElement laptop_area = driver.findElement(By.id("dropZone2"));
		Actions act = new Actions(driver);
		//perform drag and drop
		act.dragAndDrop(elel2, laptop_area).perform();
		Thread.sleep(2000);
		//find mobile elements
		WebElement elem1= driver.findElement(By.id("dragElement2"));
		elem1.click();
		WebElement elem2 = driver.findElement(By.id("dragElement4"));
		elem2.click();
		//perform drag and drop
		WebElement mobile_area = driver.findElement(By.id("dropZone1"));
		act.dragAndDrop(elem2, mobile_area).perform();
		Thread.sleep(2000);
		driver.quit();
	}

}
