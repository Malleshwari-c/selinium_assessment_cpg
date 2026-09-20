package Assessment11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vacancy12 {
WebDriver driver;
	
	public vacancy11(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addB;
	
	public void addButton() {
		addB.click();
		System.out.println("add button clicked");
	}

}
