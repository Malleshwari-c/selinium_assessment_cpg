package assessment;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class day_1_1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		driver.findElement(By.className("desktop-searchBar")).sendKeys("watch");
		driver.findElement(By.xpath("//li[.='Watches For Women']")).click();
		driver.findElement(By.className("img-responsive")).click();
		String parentid=driver.getWindowHandle();
		Thread.sleep(1000);
		Set<String> allids=driver.getWindowHandles();
		for(String id:allids) {
			if(!parentid.equals(id)) {
				String title=driver.getTitle();
				if(title.equals("Watches For Women - Buy Watches For Women online in India")) {
					driver.switchTo().window(id);
				}
			}
		}
		driver.findElement(By.xpath("//div[starts-with(@class,' pdp-add-to-wishlist')]")).click();
		String url=driver.getCurrentUrl();
		System.out.println(url);
		if(url.equals("https://www.myntra.com/login")) {
			System.out.println("Wish list is Added");
		}
		else {
			System.out.println("Not added");
		}
	}

}
