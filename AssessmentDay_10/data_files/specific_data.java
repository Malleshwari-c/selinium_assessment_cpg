package ass_9;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class specific_data {
	public String fn;
	public String ln;
	public String postalCode;
	public String prod_ve;
	public String pro_name;
	public String last_text;


	public void sdata() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT/ass_10_spec_data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		fn=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		ln=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		postalCode=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		prod_ve=wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		pro_name=wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		last_text=wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();


	}

}
