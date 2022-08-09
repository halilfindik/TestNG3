package Gun05;

import Utils.GeneralWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */
public class _02_ContactUs extends GeneralWebDriver {

    @Test
    @Parameters("mesaj") // XML'deki adı
    void ContactUs(String geleneMesaj) { // metoddaki adı

    WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        contactUs.click();
    WebElement messageArea = driver.findElement(By.id("input-enquiry"));
        messageArea.sendKeys(geleneMesaj);
    WebElement submitButton = driver.findElement(By.cssSelector("[value='Submit']"));
        submitButton.click();
    WebElement result = driver.findElement(By.cssSelector("div[id='content']>h1"));
        Assert.assertEquals("Contact Us",result.getText(),"Karşılaştırma Sonucu");
    }
}
