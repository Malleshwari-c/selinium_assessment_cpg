package Assessment12;

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
	
	@FindBy(css="[class='oxd-topbar-body-nav-tab --visited']")
	private WebElement vacancy;
	

	public void vacaClick() {
		vacancy.click();
		System.out.println("vacanyc clicked");
	}

}
