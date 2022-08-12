package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class Tools {

    public static void compareToList(List<String> menuExpectedList, List<WebElement> menuActualList) {
        for (int i=0; i<menuActualList.size(); i++) {
            Assert.assertEquals(menuActualList.get(i).getText(), menuExpectedList.get(i),"Karşılaştırma Sonucu :");
        }
    }
    public static void Bekle(int saniye)
    {

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static void successMessageValidation(){
        GeneralWebDriver.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='alert alert-success alert-dismissible']")));
        WebElement subscriptionSuccesful= GeneralWebDriver.driver.findElement(By.cssSelector("[class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(subscriptionSuccesful.getText().toLowerCase().contains("success"));
    }

    public static int randomGenerator(int max) {
        return (int) (Math.random() * max);
    }
}
