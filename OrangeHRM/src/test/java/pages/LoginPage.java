package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage  {
	
	WebDriver driver;
	
	//constructor
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//locator
	
	@FindBy(xpath = "//input[@placeholder='Username']") 
	WebElement username;	
	@FindBy(xpath = "//input[@placeholder='Password']") 
	WebElement password;	
	@FindBy(xpath = "//button[normalize-space()='Login']") 
	WebElement btn_login;	
	

	//Action method
	
	public void setUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickBtnLogin()
	{
		btn_login.click();
	}
}
