package Assessment12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class commonData {
	public String BROWSER;
	public String URL;
	public String USERNAME,PASSWORD;
	
	public void bowser() throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT1/comData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		BROWSER=pro.getProperty("browser");
		URL=pro.getProperty("url");
		USERNAME=pro.getProperty("username");
		PASSWORD=pro.getProperty("password");
	}
	


}
