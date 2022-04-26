package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        clickOnElement(By.xpath("//a[@href='/computers']"));
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        selectByVisibleTextFromDropdown(By.name("products-orderby"), "Name: Z to A");
        verifyText("Name: Z to A",By.xpath("//option[contains(text(),'Name: Z to A')]"),"Error, Message not displayed as expected");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        clickOnElement(By.xpath("//a[@href='/computers']"));
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        selectByVisibleTextFromDropdown(By.name("products-orderby"), "Name: A to Z");
        sendKeysToElement(By.xpath("//a[contains(text(),'Build your own computer')]"), Keys.ENTER);
        verifyText("Build your own computer",By.xpath("//h1[contains(text(),'Build your own computer')]"),"Error, Message not displayed as expected");
        selectByVisibleTextFromDropdown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        selectByVisibleTextFromDropdown(By.id("product_attribute_2"), "8GB [+$60.00]");
        clickOnElement(By.id("product_attribute_3_7"));
        clickOnElement(By.id("product_attribute_4_9"));
        clickOnElement(By.id("product_attribute_5_12"));
        verifyText("$1,475.00",By.xpath("//span[contains(text(),'$1,475.00')]"),"Error, Message not displayed as expected");
        clickOnElement(By.id("add-to-cart-button-1"));
        verifyText("The product has been added to your shopping cart",By.xpath("//p[contains(.,'The product has been added to your shopping cart')]"),"Error, Message not displayed as expected");
        clickOnElement(By.xpath("//span[@title='Close']"));
        mouseHoverAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"));
        verifyText("Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"),"Error, Message not displayed as expected");
        sendKeysToElement(By.xpath("(//input[contains(@id, 'itemquantity')])"), Keys.BACK_SPACE + "2");
        clickOnElement(By.xpath("//button[text()='Update shopping cart']"));
        verifyText("$2,950.00",By.className("product-subtotal"),"Incorrect price");
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        verifyText("Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Error, Message not displayed as expected");
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Sanket");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Desai");
        sendTextToElement(By.id("BillingNewAddress_Email"), "abcxyz@gmail.com");
        sendTextToElement(By.id("BillingNewAddress_Company"), "Prime Testing Inc.");
        selectByVisibleTextFromDropdown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "10 Downing Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "SW1B 2BA");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "02082268899");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        clickOnElement(By.id("shippingoption_1"));
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleTextFromDropdown(By.id("CreditCardType"), "Master card");
        sendTextToElement(By.id("CardholderName"), "Sanket Desai");
        sendTextToElement(By.id("CardNumber"), "5555555555554444");
        selectByVisibleTextFromDropdown(By.id("ExpireMonth"), "10");
        selectByVisibleTextFromDropdown(By.id("ExpireYear"), "2023");
        sendTextToElement(By.id("CardCode"), "123");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        verifyText("Payment Method:",By.xpath("//span[contains(text(),'Payment Method:')]"),"Error, Message not displayed as expected");
        verifyText("Credit Card",By.xpath("//span[contains(text(),'Credit Card')]"),"Error, Message not displayed as expected");
        verifyText("Shipping Method:",By.xpath("//span[contains(text(),'Shipping Method:')]"),"Error, Message not displayed as expected");
        verifyText("Next Day Air",By.xpath("//span[contains(text(),'Next Day Air')]"),"Error, Message not displayed as expected");
        verifyText("$2,950.00",By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"),"Error, Message not displayed as expected");
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        verifyText("Thank you",By.xpath("//h1[contains(text(),'Thank you')]"),"Error, Message not displayed as expected");
        verifyText("Your order has been successfully processed!",By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Error, Message not displayed as expected");
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        verifyText("Welcome to our store",By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Error, Message not displayed as expected");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
