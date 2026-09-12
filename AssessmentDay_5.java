/*
1.Navigate to orange Hrm application
2.Enter the username password and click on login buuton
by redaing the data from excel file.
*/
//Assessment 5 test case 2
package Assessments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day_5_2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		//Create FileInputStream to read the Excel file
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT/loginCredi.xlsx");
		//Create Workbook object and open the Excel file
		Workbook wb=WorkbookFactory.create(fis);
		//Access Sheet1 from the workbook
		Sheet sh=wb.getSheet("Sheet1");
		// Read browser name from Row 1, Column 0
		String BROWSER=sh.getRow(1).getCell(0).getStringCellValue();
		// Read URL from Row 1, Column 1
		String URL=sh.getRow(1).getCell(1).getStringCellValue();
		// Read username from Row 1, Column 2
		String UN=sh.getRow(1).getCell(2).getStringCellValue();
		// Read password from Row 1, Column 3
		String PW=sh.getRow(1).getCell(3).getStringCellValue();
		// launching the browser
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Open the URL read from Excel
		driver.get(URL);
		// Locate username field and enter username from Excel
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(UN);
		// Locate password field and enter password from Excel
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(PW);
		// Locate and click the Login button
		driver.findElement(By.cssSelector("[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		Thread.sleep(1000);
		// Close the browser
		driver.quit();
	}

}
