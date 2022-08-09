package Gun05;

import Utils.GeneralWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.tools.Tool;
import java.util.List;

/*
       Senaryo ;
       1- Siteyi açınız.
       2- mac kelimeini göndererek aratınız.
       3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
       4- aynı işlemi samsung için de yapınız
     */
public class _03_SearchFunctionality extends GeneralWebDriver {

    @Test
    @Parameters("keyword")
    void search(String keyword) {
        WebElement searchBox= driver.findElement(By.name("search"));
        searchBox.sendKeys(keyword + Keys.ENTER);
        List<WebElement> keywords=driver.findElements(By.cssSelector("h4>a"));
        for (WebElement i:keywords) {
            Assert.assertTrue(i.getText().toLowerCase().contains(keyword));
        }
    }

}
