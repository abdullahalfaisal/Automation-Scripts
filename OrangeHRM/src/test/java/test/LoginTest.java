package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

public class LoginTest extends Base {

    @BeforeClass
    void setupBrowser() {
        setup(); // initializes driver in Base
    }

    @Test
    void testLogin() {
        LoginPage lp = new LoginPage(driver);
        lp.setUsername("Admin");
        lp.setPassword("admin123");
        lp.clickBtnLogin();
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    
//    @AfterMethod
//    void logout() {
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/logout");
//    }
    
    @AfterClass
    void tearDownBrowser() {
        tearDown();
    }
}
