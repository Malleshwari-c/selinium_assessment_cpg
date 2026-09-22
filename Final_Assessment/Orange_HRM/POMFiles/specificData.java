package final_ass_POMFiles;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class specific_data {
	
	public String MESSAGE;
	public void spData() throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT1/Final_Assessment.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		MESSAGE=sh.getRow(1).getCell(0).getStringCellValue();
		System.out.println(MESSAGE);

	}
}
