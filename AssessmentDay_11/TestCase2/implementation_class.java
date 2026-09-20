package Assessments;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Assess12_testcase2.Ass_12_base_class;
import Assess12_testcase2.PIM;
import Assess12_testcase2.commonData;
import Assess12_testcase2.dashboard12;
import Assess12_testcase2.login_page12;
import Assess12_testcase2.specificData;


public class ass_Day_12_testCase2 extends Ass_12_base_class{
	
	@Test
	public void imple12_2() throws IOException, InterruptedException, AWTException {
		specificData sp = new specificData();
		sp.spData();
		
		commonData cd = new commonData();
		cd.bowser();
		
		dashboard12 db = new dashboard12(driver);
		db.myInfo();
		
		PIM pim = new PIM(driver); 
		pim.enterDetails(sp.FIRSTNAME,sp.MIDDLENAME,sp.LASTNAME,sp.EMPLOYEEID);
		pim.logOut();
		
		login_page12 lp=new login_page12(driver);
		lp.lPage(cd.USERNAME, cd.PASSWORD);
		
		db.myInfo();
		pim.verify();
		Assert.assertEquals(sp.FIRSTNAME,pim.first_name);
		Assert.assertEquals(sp.MIDDLENAME, pim.middle_name);
		Assert.assertEquals(sp.LASTNAME, pim.last_name);
		Assert.assertEquals(sp.EMPLOYEEID, pim.employee_id);
		
		Thread.sleep(5000);
	}

}

