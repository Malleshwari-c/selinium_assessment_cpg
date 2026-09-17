package Assessments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import POMutilities.orange_assess;
import POMutilities.recuritment_page;
import assess_8.addCandidates;
import assess_8.login_page;
import assess_8.view_candidates;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day_8 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis1=new FileInputStream("./src/test/resources/DDT/Assessment_8.properties");
		Properties p=new Properties();
		p.load(fis1);
		
		FileInputStream fis2=new FileInputStream("./src/test/resources/DDT/assessment_8.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String FN=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String MN=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String LN=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String EM=wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();

		String BROWSER = p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		login_page lp=new login_page(driver);
		lp.loginPage(USERNAME, PASSWORD);
		recuritment_page r_p=new recuritment_page(driver);
		r_p.recu();
		view_candidates v_c=new view_candidates(driver);
		v_c.addButton();
		addCandidates a_c=new addCandidates(driver);
		a_c.enterName(FN, MN, LN, EM);
	
	}

}
