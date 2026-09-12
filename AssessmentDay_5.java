/*1.Navigate to DemoWebshop application 
2.Click on login link .
3.Enter email and password and click on login button by reading the data from property file.
*/
//Assessment 5 test case 1
package Assessments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day_5_1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		//Create FileInputStream to read Properties file
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT/data.properties");
		//Create Properties object 
		Properties pro=new Properties();
		//load the Properties file to the load method
		pro.load(fis);
		//get the properties 
		String BROWSER=pro.getProperty("browser");
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
		String URL=pro.getProperty("url");
		String UN=pro.getProperty("username");
		String PW=pro.getProperty("pw");
		//naviagte to url
		driver.get(URL);
		//click login button
		driver.findElement(By.xpath("//a[.='Log in']")).click();
		//enter email and password
		driver.findElement(By.id("Email")).sendKeys(UN);
		driver.findElement(By.id("Password")).sendKeys(PW);
		//click on login submit button
		driver.findElement(By.cssSelector("[class='button-1 login-button']")).click();
		Thread.sleep(2000);
		//close the browser
		driver.quit();

		
	}

}

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
/*
1.Navigate to Demoappsqspiders application
2.Enter name, email,password and click on login  submit button
3.Read the data from json file.
*/
//Assessment 5 test case 3
package Assessments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day_5_3 {
	public static void main(String[] args) throws  IOException, ParseException, InterruptedException {
		//Read file json using FileReader 
		FileReader fis=new FileReader("./src/test/resources/DDT/Ass_data.json");
		//jsonPRaser class
		JSONParser jsonparser=new JSONParser();
		//we are getting java object from parse 
		Object javaobj=jsonparser.parse(fis);
		//downcasting to get the java to json
		JSONObject json=(JSONObject)javaobj;
		//get the elements from json
		String BROWSER=json.get("browser").toString();
		String URL=json.get("url").toString();
		String NAME=json.get("name").toString();
		String EMAIL=json.get("username").toString();
		String PW=json.get("pw").toString();
		//launch browser
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
		//navigate to url
		driver.get(URL);
		//send name,email,password
		driver.findElement(By.id("name")).sendKeys(NAME);
		driver.findElement(By.id("email")).sendKeys(EMAIL);
		driver.findElement(By.id("password")).sendKeys(PW);
		//click login
		driver.findElement(By.xpath("//button[.='Register']")).click();
		Thread.sleep(2000);
		//close browser
		driver.quit();
	}

}

