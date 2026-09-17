package assess_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class recuritment_page {
	//create driver as global variable
	WebDriver driver;
	//constructor call and pass driver as argument
	public recuritment_page(WebDriver driver) {
		this.driver=driver;
	    //initiate all the variables using PageFactory
		PageFactory.initElements(driver,this);
		}
	//find recurment button using css selector
	@FindBy(css="[href='/web/index.php/recruitment/viewRecruitmentModule']")
	private WebElement recur;
	
	//create recu method 
	public void recu() {
		//click on the button
		recur.click();
	}

}
