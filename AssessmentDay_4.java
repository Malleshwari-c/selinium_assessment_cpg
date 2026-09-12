
/*
  Testcase1:
  1.Navigate to any application
  2.count all the textfields
  3.get the size of each textfield
  4.verify my giving input to any of the textfield among all
*/

//Assessment 4 test case 2
package assessment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class day_4_1 {
	public static void main(String[] args) throws InterruptedException {
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//navigate to url
		driver.get("https://www.instagram.com/");
		//find text fields from the pages
		List<WebElement> l = driver.findElements(By.xpath("//input[@dir='ltr']"));
		//get the size
		System.out.println(l.size());
		for(WebElement ele:l) {
			//send the keys
			if("_r_4_".equals(ele.getDomAttribute("id")) )
		    {
		        ele.sendKeys("malli@gmail.com");
		    }
		}
		Thread.sleep(2000);
		//close
		driver.quit();
	}

}

/*
  Testcase2:
  1.navigate to zomato appliaction
  2.click on log in
  3.enter the phone number
  4.Locate the frame 
  5.use switch frame to go back to main document
  6.verify whether it has switched to main document or not
*/


//Assessment 4 test case 2
package assessment;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class day_4_2 {
	public static void main(String[] args) throws InterruptedException {
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//navigate to url
		driver.get("https://www.zomato.com/bangalore/delivery");
		//Login button
		driver.findElement(By.xpath("//button[.='Log in']")).click();
		Thread.sleep(1000);
		//switch the control to next frame
		WebElement fra = driver.findElement(By.cssSelector("[id='auth-login-ui']"));
		driver.switchTo().frame(fra);
		//send keys to phone number
		driver.findElement(By.cssSelector("[class='sc-60vv3c-0 gmdLhr sc-fPXMVe iHUNmi']")).sendKeys("9019960147");
		driver.findElement(By.cssSelector("[class='sc-rbbb40-0 fJjczH']")).click();
		//return back the control main frame page
		driver.switchTo().defaultContent();
		//verification of switching the control to main frame
		WebElement verify=driver.findElement(By.xpath("//div[.='Dining Out']"));
		verify.click();
		System.out.println(verify.getText());
		Thread.sleep(2000);
		//close the browser
		driver.quit();
	}

}

/*
	Testcase3:
	1.Navigate to bigbasket application
	2.search any product
	3.Amog all suggestions select one product
	4.add to cart one product
	5.verify whether the product is added to cart or not
*/

//Assessment 4 test case 3

package Problems;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day_4_3
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Navigate to the bigbasket application
		driver.get("https://www.bigbasket.com/pb/boss/");
		//search for any product
		driver.findElement(By.xpath("(//input[@placeholder='Search for Products...'])[2]")).sendKeys("Apples");
		//select required product and add to cart
		List<WebElement> allmatches=driver.findElements(By.xpath("//ul[@class='overscroll-contain']/li"));
		for(WebElement ele : allmatches)
		{
			String text = ele.getText();
			if(text.contains("Apple - Red Delicious"))
			{
				ele.findElement(By.xpath(".//button[text()='Add']")).click();
				break;
			}
			
		}
		//after clicking on add and then we need to verify that it is added or not
		WebElement verify=driver.findElement(By.xpath("//p[text()='Item has been added to your basket successfully']"));
		
		//verify
		if(verify.isDisplayed()){
			System.out.println(verify.getText());
		}
		else{
			System.out.println("Item has Not Added to your basket");
		}
		Thread.sleep(2000);
		//close the browser
		driver.quit();
	}
}

