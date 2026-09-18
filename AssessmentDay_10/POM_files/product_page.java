package Assessment_Day9_POMFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class product_page {
	WebDriver driver;
	
	public product_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//	@FindBy(xpath="//span[@class='title']")
//	private WebElement title_verify;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement add2cart;
	
	@FindBy(css="[class='shopping_cart_badge']")
	private WebElement cart_verify;
	
	public void add_2_cart() {
		add2cart.click();
		System.out.println("addedd suc");
	}
	
	public void verify_page(String URL) {
		System.out.println("product page");
		String url=driver.getCurrentUrl();
		if(url.equals(URL)) {
			System.out.println("Product page is verified");
		}
		else {
			System.out.println("Product page is not verified");
		}
	}
	
	public void verify_cart() {
		String pn=cart_verify.getText();
		if(pn.equals("1")) {
			System.out.println("Number of products verified");
			cart_verify.click();
			System.out.println("clicked cart");
		}
		else {
			System.out.println("there are more number of products");
		}
	}
	
}
