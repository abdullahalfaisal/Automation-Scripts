package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.Base;

public class AddEmployeePage extends Base {
		
	WebDriver driver;
	
	
	//Constructor

	public AddEmployeePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//Locator}
	
	@FindBy(xpath = "//a[.//span[text()='PIM']]")
	WebElement btnPim;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement btnAdd;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement txtFName;
	
	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	WebElement txtMName;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement txtLName;

	
	@FindBy(css = "button[type='submit']")
	WebElement btnSave;
	
	
	//Action Methods
	
	public void clickPim()
	{
		btnPim.click();
	}
	public void clickAddBtn()
	{
		btnAdd.click();
	}
	public void setFirstName(String fName)
	{
		txtFName.sendKeys(fName);
	}
	public void setMiddleName(String mName)
	{
		txtMName.sendKeys(mName);
	}
	public void setLastName(String lName)
	{
		txtLName.sendKeys(lName);
	}
	public void clickBtnSave()
	{
		btnSave.click();
	}
}