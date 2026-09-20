package Assessment12;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addJobVacancy12 {
WebDriver driver;
	
	public addJobVacancy12(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement vacancyName;
	
	@FindBy(xpath="//div[@role='listbox' and normalize-space()='\" + JT + \"']")
	private WebElement selectClick;
	
	@FindBy(xpath="//div[@class='oxd-select-text-input']")
	private WebElement description;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement hiringManager;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	private WebElement noPosition;	
	
	@FindBy(css="[type='submit']")
	private WebElement saveClick;

	public void vacanyJob(String VN,String JT,String des,String HM,String Pos) {
		System.out.println("filling started");
		vacancyName.sendKeys(VN);
		System.out.println("vaname entered");
		selectClick.click();
		System.out.println("click selection");
		description.sendKeys(des);
		System.out.println("descript entered");
		hiringManager.sendKeys(HM);
		System.out.println("HM entered");
		noPosition.sendKeys(Pos);
		System.out.println("Position entered");
		saveClick.click();
		System.out.println("saved succesfully");;
	}

}
