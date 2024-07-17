package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeSignUp extends BaseTest{

    @Test
    public void negativeSignUp() throws InterruptedException {

        //Clicking Account Button
        homePage.setAccount();

        Thread.sleep(2000);
        homePage.setCreateAccount();
        //Sending keys to create new account
        signUpPage.setFirstName("vishnu");
        signUpPage.setLastName("priya");
        signUpPage.setEmail("ngvishnupriya@gmail.com");
        signUpPage.setPassword("priya12345");
        signUpPage.setReEnterPassword("priya12345");
        signUpPage.setPhoneNumber("7826941864");
        signUpPage.setRecoverPhoneNum();
        signUpPage.setSubmit();
        //Getting error message
        WebElement error = driver.findElement(By.xpath("//strong[text()='An account with this email already exists.']"));
        Thread.sleep(5000);
        String actualErrorMessage =  error.getText();
        Assert.assertEquals(actualErrorMessage,"An account with this email already exists.");

    }
}
