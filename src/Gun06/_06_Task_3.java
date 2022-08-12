package Gun06;
/*
   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun sayisi ile indirimli urun sayisi ayni mi dogrulayiniz
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan
      yüksek olduğunu doğrulayınız.
*/
import Utils.GeneralWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _06_Task_3 extends GeneralWebDriver {

    @Test
    void SpecialsValidation() {
        WebElement speacials= driver.findElement(By.linkText("Specials"));
        speacials.click();
        List<WebElement> specialProducts=driver.findElements(By.cssSelector("h4>a"));
        List<WebElement> productNewPrices=driver.findElements(By.cssSelector("span[class='price-new']"));
        List<WebElement> productoldPrices=driver.findElements(By.cssSelector("span[class='price-old']"));

        for (int i=0; i<specialProducts.size(); i++) {
            System.out.println(productoldPrices.get(i).getText());
            System.out.println(productNewPrices.get(i).getText());
            Assert.assertTrue(Double.parseDouble(productoldPrices.get(i).getText().replace("$",""))<Double.parseDouble(productNewPrices.get(i).getText().replace("$","")));
        }


    }
}
