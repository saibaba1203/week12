package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {

        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));
        verifyText("Cell phones",By.xpath("//h1[contains(text(),'Cell phones')]"),"Error, Message not displayed as expected");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        verifyUserShouldNavigateToCellPhonesPageSuccessfully();
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        sendKeysToElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"), Keys.ENTER);
        verifyText("Nokia Lumia 1020",By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"),"Error, Message not displayed as expected");
        verifyText("$349.00",By.xpath("//span[contains(text(),'$349.00')]"),"Error, Message not displayed as expected");
        sendKeysToElement(By.id("product_enteredQuantity_20"), Keys.BACK_SPACE + "2");
        clickOnElement(By.id("add-to-cart-button-20"));
        verifyText("The product has been added to your shopping cart",By.xpath("//p[contains(.,'The product has been added to your shopping cart')]"),"Error, Message not displayed as expected");
        clickOnElement(By.xpath("//span[@title='Close']"));
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));
        verifyText("Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"),"Error, Message not displayed as expected");
        verifyText("(2)",By.xpath("//span[contains(text(),'(2)')]"),"Error, Message not displayed as expected");
        verifyText("$698.00",By.xpath("//span[contains(text(),'$698.00')]"),"Error, Message not displayed as expected");
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        verifyText("Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Error, Message not displayed as expected");
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        verifyText("Register",By.xpath("//h1[contains(text(),'Register')]"),"Error, Message not displayed as expected");
        clickOnElement(By.id("gender-male"));
        sendTextToElement(By.id("FirstName"), "Sanket");
        sendTextToElement(By.id("LastName"), "Desai");
        sendTextToElement(By.id("Email"),getRandomEmail());
        clickOnElement(By.id("Newsletter"));
        sendTextToElement(By.id("Password"), "Abc123");
        sendTextToElement(By.id("ConfirmPassword"), "Abc123");
        clickOnElement(By.id("register-button"));
        verifyText("Your registration completed",By.xpath("//div[contains(text(),'Your registration completed')]"),"Error, Message not displayed as expected");
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        verifyText("Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"),"Error, Message not displayed as expected");
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        sendTextToElement(By.id("BillingNewAddress_FirstName"),"Sanket");
        sendTextToElement(By.id("BillingNewAddress_LastName"),"Desai");
       // sendTextToElement(By.id("BillingNewAddress_LastName"),"Desai");
        selectByVisibleTextFromDropdown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "10 Downing Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "SW1A 2AA");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "02082228899");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        clickOnElement(By.id("shippingoption_2"));
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleTextFromDropdown(By.id("CreditCardType"), "Visa");
        sendTextToElement(By.id("CardholderName"), "Sanket Desai");
        sendTextToElement(By.id("CardNumber"), "5555555555554444");
        selectByVisibleTextFromDropdown(By.id("ExpireMonth"), "11");
        selectByVisibleTextFromDropdown(By.id("ExpireYear"), "2022");
        sendTextToElement(By.id("CardCode"), "123");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        verifyText("Payment Method:",By.xpath("//span[contains(text(),'Payment Method:')]"),"Error, Message not displayed as expected");
        verifyText("Credit Card",By.xpath("//span[contains(text(),'Credit Card')]"),"Error, Message not displayed as expected");
        verifyText("Shipping Method:",By.xpath("//span[contains(text(),'Shipping Method:')]"),"Error, Message not displayed as expected");
        verifyText("2nd Day Air",By.xpath("//span[contains(.,'2nd Day Air')]"),"Error, Message not displayed as expected");
        verifyText("$698.00",By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"),"Error, Message not displayed as expected");
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        verifyText("Thank you",By.xpath("//h1[contains(text(),'Thank you')]"),"Error, Message not displayed as expected");
        verifyText("Your order has been successfully processed!",By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Error, Message not displayed as expected");
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        verifyText("Welcome to our store",By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Error, Message not displayed as expected");
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.nopcommerce.com/" );
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
