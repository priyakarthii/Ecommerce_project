package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class CheckoutPageTest extends  BaseTest {

    @Test(priority = 4)
    public void testCheckoutPage() {

        //Giving Address to place the order
        checkoutPage.setCheckout();
        checkoutPage.setContinueAsGuest();
        checkoutPage.setSwitchToPickup();
        checkoutPage.setFirstName("vishnu");
        checkoutPage.setLastName("priya");
        checkoutPage.setAddress("somapuragate, Bangalore");
        checkoutPage.setCity("Bangalore");
        //Dropdown
        WebElement dd = driver.findElement(By.xpath("//select[@id='state']"));
        Select select = new Select(dd);
        select.selectByIndex(1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        checkoutPage.setZipCode("600048");
        checkoutPage.setSaveAddress();
        checkoutPage.setKeepAddressEntered();
        //Scrolling down to the Email block
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);");
        checkoutPage.setEmailAddress("ngvishnupriya@gmail.com");
        checkoutPage.setMobileNumber("7826941864");
        checkoutPage.setCheckBox();
        checkoutPage.setPaymentInformation();
        checkoutPage.setCardNumber("6485974286397456");
        checkoutPage.setExpiryDate("05/29");
        checkoutPage.setCvvNumber("199");
        checkoutPage.setApply();
        //Scrolling down to the Place order button
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);");
        checkoutPage.setPlaceOrder();
        //Assertion
        String str = driver.getTitle();
        System.out.println("The title of the page is: " + str);
        Assert.assertEquals(str, "Checkout - Best Buy");
    }

}
