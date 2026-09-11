/*Test Case 1 

1.Navigate EaseMyTrip and handle the notification popup.
2.Select One Way.
3.Enter any state  in the From field and select a valid suggestion.
4.Enter another state  in the To field and select a valid suggestion.
5.Click the Departure Date field.
6.Select any available future date from the calendar.
7.Click Traveller & Class.
8.Select 2 Adults and keep the class as Economy.
9.Click Search.
10.Verify that the flight-results page is displayed.
  */
//Assessment 3 test case 1
package assessment;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class day_3_1 {
	public static void main(String[] args) throws InterruptedException {
		//Disable notification pop-ups
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		//launch webDriver
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//naviagte to easymytrip
		driver.get("https://www.easemytrip.com/");
		//enter from location
		driver.findElement(By.id("FromSector_show")).click();
		driver.findElement(By.id("spn2")).click();
		//enter to location
		driver.findElement(By.id("a_Editbox13_show")).sendKeys("Mumbai");
		driver.findElement(By.id("airportMumbai")).click();
		//select the date for ticket booking
		driver.findElement(By.id("frth_3_23/09/2026")).click();
		//select the number of tickets as 2
		driver.findElement(By.id("pcalss")).click();
		driver.findElement(By.id("add")).click();
		//select economy class
		driver.findElement(By.id("spanEconomy")).click();
		driver.findElement(By.id("traveLer")).click();
		//click on search button
		driver.findElement(By.className("srchBtnSe")).click();
		//Verify that the flight-results page is displayed.
		String title=driver.getTitle();
		if(title.contains("EaseMyTrip.com Lowest Airfare, Flight Tickets, Cheap Air Tickets – EaseMyTrip.com"))
			System.out.println("Flight results page is displayed");
		else
			System.out.println("Flight results page is not displayed");
		Thread.sleep(2000);
		
		//close the browser
		driver.quit();
	}

}


/*Testcase 2

1.NAvigate to demo appa qspiders date picker---  (https://demoapps.qspiders.com/ui/datePick?sublist=0)
2.Click on calender.
3. Navigate to the next month in the current year.
4. Select any valid date from that month.
5. Verify that the selected date is displayed correctly in the date field.
  */

//Assessment 3 test case 1

package assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class day_3_2 {
	public static void main(String[] args) throws InterruptedException {
		//launch webDriver
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//navigate to url
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		//select the date picker
		driver.findElement(By.xpath("//section[.='Date & Time Picker']")).click();
		driver.findElement(By.xpath("//section[.='Date Picker']")).click();
		//select the calender icon
		WebElement ref=driver.findElement(By.cssSelector("[class='react-datepicker-wrapper']"));
		driver.findElement(RelativeLocator.with(By.tagName("svg")).toRightOf(ref)).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']")).click();
		//select the date
		driver.findElement(By.xpath("//div[.='8']")).click();
		//verification
		WebElement verify=driver.findElement(By.xpath("//input[@placeholder='Select A Date']"));
		System.out.println(verify.getAttribute("value"));
		if(verify.getAttribute("value").contains("8/10/2026")) {
			System.out.println("selected date is displayed");
		}else {
			System.out.println("selected date is not displayed");
		}
		Thread.sleep(2000);
		//close the browser
		driver.quit();
	}

}

