
//Assessment 4 test case 1
package assessment;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class day_4_1 {
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


//Assessment 4 test case 2
package assessment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class day_4_2 {
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



