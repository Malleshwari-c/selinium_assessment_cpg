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
