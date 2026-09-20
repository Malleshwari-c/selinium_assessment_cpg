package Assessment12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboard12 {
	WebDriver driver;
	
	public dashboard12(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Recruitment']")
	public WebElement recu_b;
	
	public void recur() {
		recu_b.click();
		System.out.println("recu_clicked");
	}

}
