package Assessment_Day9_POMFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class info_page {
	WebDriver driver;
	
	public info_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="first-name")
	private WebElement firstName;
	
	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(id="postal-code")
	private WebElement postalCode;
	
	@FindBy(id="continue")
	private WebElement Continue;
	
	public void enter_details(String FN, String LN,String PC) {
		firstName.sendKeys(FN);
		lastName.sendKeys(LN);
		postalCode.sendKeys(PC);
		Continue.click();
	}

}
