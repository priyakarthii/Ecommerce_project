package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest{
    @Test
    public void testLoginPage() throws InterruptedException {

        homePage.setAccount();
        Thread.sleep(2000);
        homePage.setSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailAdd("ngvishnupriya@gmail.com");
        loginPage.setPassword("priya12345");
        loginPage.setClickSignIn();
        loginPage.setLoginSkipNow();

        //Validating Assertion
        String str = driver.getTitle();
        System.out.println(str);
        Assert.assertEquals(str, "Best Buy | Official Online Store | Shop Now & Save ");
    }
}
