package Gun06;
/**
 * Bir önceki task da yapılan testi PARAMETERDRIVER ile yapınız
 * sonrasında fakrlı tarayıcılar ile çalıştırınız.
 * sonrasında paralel çalıştırınız.
 */
import Utils.ParameteredWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _05_Task_2 extends ParameteredWebDriver {

    @Test(dataProvider = "getData")
    void search(String keyword) {
        WebElement searchBox= driver.findElement(By.name("search"));
        //Tools.Bekle(3);
        searchBox.clear();
        searchBox.sendKeys(keyword + Keys.ENTER);
        Tools.Bekle(1);
        List<WebElement> keywords=driver.findElements(By.cssSelector("h4>a"));

        for (WebElement i:keywords) {
            Assert.assertTrue(i.getText().toLowerCase().contains(keyword));
        }
    }

    @DataProvider(name="getData")
    public Object[] getData() {
        return new Object[]{"mac","ipod","samsung"};
    }
}
