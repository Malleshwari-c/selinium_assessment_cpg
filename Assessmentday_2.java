//Assessment 2 test case 1
package assessment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day_2_1 {

    public static void main(String[] args) throws InterruptedException {
        // Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(2000);
        // Identify First Name and Surname fields
        WebElement firstName = driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_"));
        WebElement surname = driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_"));
        // Capture Y coordinates
        int firstNameY = firstName.getRect().getY();
        int surnameY = surname.getRect().getY();
        // Verify alignment
        if (firstNameY==surnameY) {
            System.out.println("First Name and Surname are aligned in the same line.");
        } else {
            System.out.println("First Name and Surname are NOT aligned.");
        }
    }
}

//Assessment 2 test case 2
package assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day_2_2 {

    public static void main(String[] args) throws InterruptedException {

        // Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to Facebook and create account
        driver.get("https://www.facebook.com/");
        WebElement createAccount =driver.findElement(By.linkText("Create new account"));
        // Capture location
        System.out.println("X Coordinate: "+ createAccount.getLocation().getX());
        System.out.println("Y Coordinate: "+ createAccount.getLocation().getY());
        createAccount.click();
        Thread.sleep(2000);
        // Identify email field
        WebElement email =driver.findElement(By.name("reg_email__"));
        System.out.println("DOM Attribute: "+ email.getDomAttribute("value"));
        System.out.println("DOM Property: "+ email.getDomProperty("value"));
        email.sendKeys("abc@gmail.com");
        System.out.println("DOM Attribute: "+ email.getDomAttribute("value"));
        System.out.println("DOM Property: "+ email.getDomProperty("value"));
        // Identify submit button
        WebElement submitButton =driver.findElement(By.name("websubmit"));
        // Capture size
        Dimension size = submitButton.getSize();
        System.out.println("Width: " + size.getWidth());
        System.out.println("Height: " + size.getHeight());
        // CSS Properties
        System.out.println("Background Color: "+ submitButton.getCssValue("background-color"));
        System.out.println("Color: "+ submitButton.getCssValue("color"));
        System.out.println("Font Size: "+submitButton.getCssValue("font-size"));
    }
}


//Assessment 3 test case 3
package Day2_Assessment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TeastCase3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//launch the browser
		WebDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//navigate to application
		driver.get("https://demowebshop.tricentis.com/");
		
		//locate add to cart button
		WebElement cartbutton = driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']/../..//input[@value='Add to cart']"));
	
		//get the size of the add to cart button
		Dimension size = cartbutton.getSize();
		
		System.out.println("size of add to cart button: "+size);
		
		//click the add to cart button
		cartbutton.click();
		
		//locate shopping cart and click
		WebElement sclink = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
		sclink.click();
		
		//locate remote check box
		WebElement removecheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
	
		//verify remove check box is selected or not
		if(removecheckbox.isSelected())
			System.out.println("remove check box is selected");
		else
			System.out.println("remove check box is not selected");
		
		//print the location and size using getRect() of remove check box
		System.out.println("check box width: "+removecheckbox.getRect().getWidth());
		System.out.println("check box Height: "+removecheckbox.getRect().getHeight());
		System.out.println("check box x offset: "+removecheckbox.getRect().getX());
		System.out.println("check box y offset: "+removecheckbox.getRect().getY());
		
		//check if alert message is displayed or not before clicking apply coupon
		try
		{
			String text = driver.findElement(By.xpath("//div[@class='message']")).getText();
			System.out.println("alert message before clicking Apply coupon button: "+text);
		
		}
		catch(Throwable e)
		{
			System.out.println("alert message is not displayed before clicking apply coupon button");
		}
		
		//click apply coupon button
		driver.findElement(By.xpath("//input[@value='Apply coupon']")).click();
		Thread.sleep(2000);
		
		//check if alert message is displayed or not After clicking apply coupon
		String text1 = driver.findElement(By.xpath("//div[@class='message']")).getText();
		
		if(text1.isBlank())
			System.out.println("alert message is not displayed after clicking apply coupon button");
		else
			System.out.println("alert message is displayed after clicking apply coupon button");
		
		//take screenshot of the laptop
		WebElement laptop = driver.findElement(By.xpath("(//img[@title='Show details for 14.1-inch Laptop'])[2]"));
		File src = laptop.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshot/laptop.png");
		FileHandler.copy(src, des);
		System.out.println("Screenshot taken successfully");
		
		//close the browser
		Thread.sleep(2000);
		driver.quit();
		
	}

}
