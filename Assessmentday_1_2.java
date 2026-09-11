/*
TestCase-2
Navigate to myntra application
Search for any product
Add the product to the wishlist
Verify whether it is added or not
*/
//Assesment 1 test case 2
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
		//launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//naviagte to url
		driver.get("https://www.myntra.com/");
		//enter value in search bar
		driver.findElement(By.className("desktop-searchBar")).sendKeys("watch");
		//select the value from dropdown
		driver.findElement(By.xpath("//li[.='Watches For Women']")).click();
		//click the item you want to add to cart
		driver.findElement(By.className("img-responsive")).click();
		//get the window id
		String parentid=driver.getWindowHandle();
		Thread.sleep(1000);
		Set<String> allids=driver.getWindowHandles();
		for(String id:allids) {
			if(!parentid.equals(id)) {
				String title=driver.getTitle();
				//switch the control to the child window
				if(title.equals("Watches For Women - Buy Watches For Women online in India")) {
					driver.switchTo().window(id);
				}
			}
		}
		//add to cart
		driver.findElement(By.xpath("//div[starts-with(@class,' pdp-add-to-wishlist')]")).click();
		//verify the item is added or not
		String url=driver.getCurrentUrl();
		System.out.println(url);
		if(url.contains("https://www.myntra.com/login")) {
			System.out.println("Wish list is Added");
		}
		else {
			System.out.println("Not added");
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
