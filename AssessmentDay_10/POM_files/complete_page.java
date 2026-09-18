package Assessment_Day9_POMFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class complete_page {
	WebDriver driver;
	
	public complete_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2[@class='complete-header']")
	private WebElement text;
	
	public void verify_text(String TEXT) {
		String pn=text.getText();
		if(pn.equals(TEXT)) {
			System.out.println("Text verified");
		}
		else {
			System.out.println("Text not verifired");
		}

	}}
