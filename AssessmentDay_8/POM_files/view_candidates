package assess_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class view_candidates {
  //create driver as global variable
	WebDriver driver;
	//constructor call and pass driver as argument	
	public view_candidates(WebDriver driver) {
		this.driver=driver;
    //initiate all the variables using PageFactory
		PageFactory.initElements(driver, this);
	}
	//find add button using xpath
	@FindBy(xpath="//div[@class='orangehrm-header-container']/descendant::button")
	public WebElement addB;
	//create a method for clicking add button
	public void addButton() {
		addB.click();
	}

}
