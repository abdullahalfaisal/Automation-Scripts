package test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AddEmployeePage;
import pages.LoginPage;
import util.CSVDataProvider;

public class AddEmployeeTest extends Base {
  
	@BeforeClass
	
	public void setBrowser() 
	{
		setup();
	}
	
	@BeforeMethod
	  
	  public void testLogin() {
	      LoginPage lp = new LoginPage(driver);
	      lp.setUsername("Admin");
	        lp.setPassword("admin123");
	      lp.clickBtnLogin();
	  }
	
	@Test(dataProvider = "employeeData", dataProviderClass = CSVDataProvider.class)
	public void testAddEmployee(String fname, String mname, String lname)
	{
		AddEmployeePage ae = new AddEmployeePage(driver);
		ae.clickPim();
		ae.clickAddBtn();
		ae.setFirstName(fname);
		ae.setMiddleName(mname);
		ae.setLastName(lname);
		ae.clickBtnSave();
	}
	
//	 @AfterMethod
//	    void logout() {
//	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/logout");
//	    }

	@AfterClass
	void tearDownBrowser()
	{
		tearDown();
	}
	
}
