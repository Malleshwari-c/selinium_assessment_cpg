package Assessments;

import java.io.IOException;

import org.testng.annotations.Test;

import Assessment12.Ass_12_base_class;
import Assessment12.addJobVacancy12;
import Assessment12.commonData;
import Assessment12.dashboard12;
import Assessment12.login_page12;
import Assessment12.recuritment_page;
import Assessment12.specificData;
import Assessment12.vacancy12;

public class Ass_Day_12 extends Ass_12_base_class{
	
	@Test
	public void imple12() throws IOException {
		specificData sp = new specificData();
		sp.spData();
		
		dashboard12 db = new dashboard12(driver);
		db.recur();
		
		recuritment_page rp = new recuritment_page(driver);
		rp.vacaClick();
		
		vacancy12 vc = new vacancy12(driver);
		vc.addButton();
		
		addJobVacancy12 av = new addJobVacancy12(driver);
		av.vacanyJob(sp.vacnacyName,sp.Jobtitle,sp.description,sp.hiringManager,sp.Position);
		
	}

}
