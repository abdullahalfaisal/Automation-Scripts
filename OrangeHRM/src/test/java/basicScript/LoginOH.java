package basicScript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;

public class LoginOH {
	public static void main(String [] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.name("password"));
//		password.sendKeys("admin123"+Keys.ENTER);
		password.sendKeys("admin123");
		 driver.findElement(By.cssSelector("button[type='submit']")).click();
		 Thread.sleep(7000);
		 driver.close();
	}
	

}
