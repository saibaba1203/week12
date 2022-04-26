package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@class='header-menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
    }

    @Test
    public void verifyComputer() {
        selectMenu("Computers");
        verifyText("Computers",By.xpath("//h1[contains(text(),'Computers')]"), "Error, Computers not displayed as expected");
    }

    @Test
    public void verifyElectronics(){
        selectMenu("Electronics");
        verifyText("Electronics", By.xpath("//h1[contains(text(),'Electronics')]"), "Error, Electronics not displayed as expected");
    }

    @Test
    public void verifyApparel(){
        selectMenu("Apparel");
        verifyText("Apparel", By.xpath("//h1[contains(text(),'Apparel')]"), "Error, Apparel not displayed as expected");
    }

    @Test
    public void verifyDigitalDownloads(){
        selectMenu("Digital downloads");
        verifyText("Digital downloads", By.xpath("//h1[contains(text(),'Digital downloads')]"), "Error, Digital downloads not displayed as expected");
    }

    @Test
    public void verifyBooks(){
        selectMenu("Books");
        verifyText("Books", By.xpath("//h1[contains(text(),'Books')]"), "Error, Books not displayed as expected");
    }

    @Test
    public void verifyJewelry(){
        selectMenu("Jewelry");
        verifyText("Jewelry", By.xpath("//h1[contains(text(),'Jewelry')]"), "Error, Jewelry not displayed as expected");
    }
    @Test
    public void verifyGiftCards(){
        selectMenu("Gift Cards");
        verifyText("Gift Cards", By.xpath("//h1[contains(text(),'Gift Cards')]"), "Error, Gift Cards not displayed as expected");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
