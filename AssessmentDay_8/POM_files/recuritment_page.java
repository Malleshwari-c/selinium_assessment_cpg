package assess_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class recuritment_page {
	WebDriver driver;
	
	public recuritment_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(css="[href='/web/index.php/recruitment/viewRecruitmentModule']")
	private WebElement recur;
	

	public void recu() {
		recur.click();
	}

}
