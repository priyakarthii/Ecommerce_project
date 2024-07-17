package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseTest{

        @Test
        public void validatePositiveSignUp() throws InterruptedException {

        //Clicking Account button
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
        signUpPage.setSkipNow();

        //Assertions to validate successful sign-up
        WebElement str = driver.findElement(By.xpath("//div[@class='welcome-wrapper--not-emphasized']"));
        str.getText();
        Assert.assertEquals(str, "Hi, vishnu priya. Welcome you back.");
    }
}
