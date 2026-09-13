/*Login to orangeHrm application -> Click on PIM link -> click on +Add button ->enter firstname , middlename, lastname , employeeId -> 
click on Create Login Details toggle button -> enter username , password and confirm password -> click on save button-> 
click on Admin link -> enter username , select role ,enter employee name and select status -> click on search button
->verify whether the emplyoee is added from the records found section and logout.
Note: store the common data in property file and testscript data in excel file.*/

//Assessment 6
package Assessments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day_6 
{
	public static void main(String[] args) throws IOException, InterruptedException {
		//read data from properties file
		FileInputStream fis1=new FileInputStream("./src/test/resources/DDT/common_data.properties");
		Properties p=new Properties();
		p.load(fis1);
		
		String browser = p.getProperty("browser");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		
		//read data from excel file
		FileInputStream fis2=new FileInputStream("./src/test/resources/DDT/TestScript_data.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		DataFormatter df = new DataFormatter();
		String fn=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String mn=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String ln=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		//convert the int type into string type
		String empid = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(3));
		String un=wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		String pw=wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		String cp=wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
		String role=wb.getSheet("Sheet1").getRow(1).getCell(7).getStringCellValue();
		String empn=wb.getSheet("Sheet1").getRow(1).getCell(8).getStringCellValue();
		String status=wb.getSheet("Sheet1").getRow(1).getCell(9).getStringCellValue();
		
		// Launch the browser
        WebDriver driver = null;
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }

        // Maximize the browser window
        driver.manage().window().maximize();

        // Apply implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 1. Navigate to orangeHrm application
        driver.get(url);
        Thread.sleep(2000);
        
        //Admin Login
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        
        //click on PIM link
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(2000);
        
        //click on Add+ button
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")).click();
        Thread.sleep(2000);
        
        //enter firstname , middlename, lastname , employeeId)
        driver.findElement(By.name("firstName")).sendKeys(fn);
        driver.findElement(By.name("middleName")).sendKeys(mn);
        driver.findElement(By.name("lastName")).sendKeys(ln);
        
        WebElement employeeId = driver.findElement(By.xpath("//label[normalize-space()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input"));
    	employeeId.click();
    	employeeId.sendKeys(Keys.CONTROL, "a");
    	employeeId.sendKeys(empid);
        
        //click on Create Login Details toggle button
        driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
        Thread.sleep(2000);
        
        //enter username , password and confirm password 
        WebElement user = driver.findElement(By.xpath("//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input"));
        user.sendKeys(un);
        WebElement pass = driver.findElement(By.xpath("//label[normalize-space()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input"));
        pass.sendKeys(pw);
        WebElement confirmPass = driver.findElement(By.xpath("//label[normalize-space()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input"));
        confirmPass.sendKeys(cp);
        
        
        //click on save button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        
        //click on Admin link
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        Thread.sleep(2000);
        
        //enter username , select role ,enter employee name and select status
        //username
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(un);
        
        //role
        WebElement roleselect = driver.findElement(By.xpath("//label[normalize-space()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"));
        roleselect.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath( "//div[contains(@class,'oxd-select-option')]//span[normalize-space()='" + role + "']")).click();
        
        //Emplyoee name
        WebElement employee = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']//input"));
        employee.sendKeys(empn);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + empn + "']")).click();
   
        //status
        WebElement statusselect = driver.findElement(By.xpath("//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"));
        statusselect.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@class,'oxd-select-option')]//span[normalize-space()='" + status + "']")).click();
        
        // click on search button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        
       //verify whether the emplyoee is added from the records found section and logout.
        WebElement employeeRecord = driver.findElement(By.xpath( "//div[@role='cell'][normalize-space()='" + un + "']" ));
        if(employeeRecord.isDisplayed())
        {
            System.out.println("Employee added successfully");
            Thread.sleep(2000);
        }
        else
        {
            System.out.println("Employee not added");
            Thread.sleep(2000);
        }

        // logout
        driver.findElement(By.xpath("//span[contains(@class,'oxd-userdropdown-tab')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        Thread.sleep(2000);
        
        //close the browser
        driver.quit();
        
	}

}
