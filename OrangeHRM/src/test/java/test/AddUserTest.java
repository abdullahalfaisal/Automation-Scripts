package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AddUserPage;
import pages.LoginPage;
import util.CSVDataProvider;

public class AddUserTest extends Base{

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
  @Test(dataProvider = "userData", dataProviderClass = CSVDataProvider.class)
  public void testAddUser(String role, String status, String employeeName, 
          String userName, String password) 
   {
	  String uniqueUsername = userName + "_" + System.currentTimeMillis();
	  
	  AddUserPage au = new AddUserPage(driver);
	  au.clickAdminBtn();
	  au.clickAddBtn();
	  au.setRole(role);
	  au.setStatus(status);
	  au.setEmployeeName(employeeName);
	  au.setUserName(uniqueUsername);
	  au.setPassword(password);
	  au.setConPassword(password);
	  au.clickSaveBtn();
	  
   }
  
//  @AfterMethod
//  void logout() {
//      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/logout");
//  }
 
  @AfterClass
  void tearDownBrowser() {
      tearDown();
  }

}
