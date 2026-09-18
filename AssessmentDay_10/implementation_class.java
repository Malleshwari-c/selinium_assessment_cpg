package Assessments;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Assessment_Day9_POMFiles.cart_page;
import Assessment_Day9_POMFiles.complete_page;
import Assessment_Day9_POMFiles.info_page;
import Assessment_Day9_POMFiles.overview_page;
import Assessment_Day9_POMFiles.product_page;
import ass_9.ass_9;
import ass_9.specific_data;

public class Day_9 extends ass_9{
	@Test
	public void loginTest() {
		System.out.println("Executed");
	}
	
	@Test
	public void orderplacementtest() throws EncryptedDocumentException, IOException {
		specific_data sp=new specific_data();
		sp.sdata();
		
		product_page pp=new product_page(driver);
		pp.verify_page(sp.prod_ve);
		pp.add_2_cart();
		pp.verify_cart();
		
		cart_page cp=new cart_page(driver);
		cp.verify(sp.pro_name);
		cp.checkout();
		
		info_page ip=new info_page(driver);
		ip.enter_details(sp.fn, sp.ln, sp.postalCode);
		
		overview_page op=new overview_page(driver);
		op.fin_click();
		
		complete_page c_p=new complete_page(driver);
		c_p.verify_text(sp.last_text);
	}
	

}
