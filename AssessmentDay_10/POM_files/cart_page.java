package Assessment_Day9_POMFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cart_page {
	WebDriver driver;
	
	public cart_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[class='inventory_item_name']")
	private WebElement title_verify;
	
	@FindBy(id="checkout")
	private WebElement checkout;
	
	public void verify(String IN) {
		String i_n=title_verify.getText();
		if(i_n.equals(IN)) {
			System.out.println("Sauce Labs Backpack Product verified");
		}else {
			System.out.println("No Sauce Labs Backpack");
		}
	}
	
	public void checkout() {
		checkout.click();
		System.out.println("checkout clicked");
	}
}
