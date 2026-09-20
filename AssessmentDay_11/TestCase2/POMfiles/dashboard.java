package Assess12_testcase2;

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
	
	@FindBy(xpath="//span[text()='My Info']")
	public WebElement my_info;
	
	public void myInfo() {
		my_info.click();
		System.out.println("myInfo_clicked");
	}


}
