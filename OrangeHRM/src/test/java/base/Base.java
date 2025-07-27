package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	protected WebDriver driver;
	protected  WebDriverWait wait;
	
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wait = new WebDriverWait (driver,Duration.ofSeconds(10));
	}
	public void tearDown()
	{
		driver.quit();
	}
}
