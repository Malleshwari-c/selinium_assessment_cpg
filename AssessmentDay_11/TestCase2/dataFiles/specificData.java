package Assess12_testcase2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class specificData {
	public String FIRSTNAME,LASTNAME,MIDDLENAME,EMPLOYEEID;
	public void spData() throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT1/Assessment12.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet3");
		FIRSTNAME=sh.getRow(1).getCell(0).getStringCellValue();
		LASTNAME=sh.getRow(1).getCell(1).getStringCellValue();
		MIDDLENAME=sh.getRow(1).getCell(2).getStringCellValue();
		EMPLOYEEID=sh.getRow(1).getCell(3).getStringCellValue();
	}

}
