package Assessment_Day9_POMFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class overview_page {
	
	WebDriver driver;
	
	public overview_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="finish")
	private WebElement finish;
	
	public void fin_click() {
		finish.click();
		System.out.println("clicked finish");
	}

}
