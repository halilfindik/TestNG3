package Gun07;
/*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/
import Utils.GeneralWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _02_PlaceOrder extends GeneralWebDriver {

    @Test
    void ConfirmOrder() {
        WebElement searchBox= driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("ipod" + Keys.ENTER);
        List<WebElement> ipods=driver.findElements(By.xpath("//span[text()='Add to Cart']"));
        ipods.get(0).click();
        WebElement cart= driver.findElement(By.linkText("Checkout"));
        cart.click();
        WebElement addressContinue=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-address")));
        addressContinue.click();
        WebElement shippingContinue=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-address")));
        shippingContinue.click();
        WebElement shippingMethodContinue=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-method")));
        shippingMethodContinue.click();
        WebElement paymentMethodContinue=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-method")));
        WebElement agreeButton=driver.findElement(By.name("agree"));
        agreeButton.click();
        paymentMethodContinue.click();
        WebElement confirmButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-confirm")));
        confirmButton.click();

        wait.until(ExpectedConditions.urlContains("success"));
        WebElement orderCompleteMessage=driver.findElement(By.cssSelector("[id='content']"));
        Assert.assertTrue(orderCompleteMessage.getText().contains("Your order has been placed"));

    }
}
