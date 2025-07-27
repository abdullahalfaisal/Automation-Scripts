package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//constructor
	
	public AddUserPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	//locator
	
		
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a") 
	WebElement btn_admin;
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement btn_add;
	@FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[1]/div[1]/div[2]/div[1]/div[1]") 
	WebElement select_userRole;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]") 
	WebElement select_status;
	@FindBy(css = "input[placeholder='Type for hints...']")
	WebElement txt_employeeName;
	@FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']") 
	WebElement txt_userName;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	WebElement txt_password;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	WebElement txt_conPassword;
	@FindBy(css = "button[type='submit']")
	WebElement btn_save;


	//Action Method
	public void clickAdminBtn()
	{
		btn_admin.click();
	}
	public void clickAddBtn()
	{
		btn_add.click();
	}
	public void setRole(String role)
	{
		select_userRole.click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//div[@role='option']//span[text()='" + role + "']"))).click();
		
	}
	public void setStatus(String status)
	{
		select_status.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//div[@role='option']//span[text()='" + status + "']"))).click();
	}

	public void setEmployeeName(String eName) {
	    txt_employeeName.sendKeys(eName);
	    
	    // Wait for suggestions container to be present
	    wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.cssSelector("div.oxd-autocomplete-dropdown")
	    ));
	    
	    // Wait for ANY suggestion to be visible (indicates dropdown populated)
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector("div.oxd-autocomplete-option")
	    ));
	    
	    // Locate the suggestion that contains the employee name
	    WebElement matchingSuggestion = wait.until(driver -> {
	        // Find all suggestions
	        List<WebElement> suggestions = driver.findElements(
	            By.cssSelector("div.oxd-autocomplete-option > span:first-child")
	        );
	        
	        // Find first suggestion where the text contains eName
	        for (WebElement suggestion : suggestions) {
	            String visibleText = suggestion.getText().trim();
	            if (visibleText.equals(eName)) {
	                return suggestion;
	            }
	        }
	        return null; // No match found (will retry)
	    });
	    
	    // Click the matching suggestion
	    matchingSuggestion.click();
	}

	public void setUserName(String uName)
	{
		txt_userName.sendKeys(uName);
	}
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	public void setConPassword(String pwd)
	{
		txt_conPassword.sendKeys(pwd);
	}
	public void clickSaveBtn()
	{
		btn_save.click();
	}
	
}
