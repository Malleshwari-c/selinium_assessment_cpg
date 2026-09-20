package Assessment12;

import java.io.FileInputStream;import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class specificData {
	public String vacnacyName, description, hiringManager,Jobtitle,Position;
	public void spData() throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT1/Assessment11.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
		vacnacyName=sh.getRow(1).getCell(0).getStringCellValue();
		description=sh.getRow(1).getCell(1).getStringCellValue();
		hiringManager=sh.getRow(1).getCell(2).getStringCellValue();
		Jobtitle=sh.getRow(1).getCell(3).getStringCellValue();
		Position=sh.getRow(1).getCell(4).getStringCellValue();

	}

}
