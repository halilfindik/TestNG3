package Gun06;

import Utils.GeneralWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _04_Task extends GeneralWebDriver {

    @Test (dataProvider = "getData")
    void search(String keyword) {
        WebElement searchBox= driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys(keyword + Keys.ENTER);
        List<WebElement> keywords=driver.findElements(By.cssSelector("h4>a"));

        for (WebElement i:keywords) {
            Assert.assertTrue(i.getText().toLowerCase().contains(keyword));
        }
    }

    @DataProvider (name="getData")
    public Object[] getData() {
        return new Object[]{"mac","ipod","samsung"};
    }
}
