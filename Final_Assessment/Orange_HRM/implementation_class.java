package Final_Assessment;

import java.io.IOException;

import org.testng.annotations.Test;

import final_ass_POMFiles.base_class;
import final_ass_POMFiles.buzz;
import final_ass_POMFiles.dashboard;
import final_ass_POMFiles.specific_data;

public class orghm extends base_class {
	
	@Test
	public void imple() throws InterruptedException, IOException {
		dashboard db = new dashboard(driver);
		db.buzz();
		Thread.sleep(20000);
		
		specific_data sp = new specific_data();
		sp.spData();
		
		buzz buz = new buzz(driver);
		buz.message(sp.MESSAGE);
		Thread.sleep(2000);
		buz.fetch(sp.MESSAGE);
		Thread.sleep(1000);
		buz.logout();
	}

}
