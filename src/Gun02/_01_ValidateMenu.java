package Gun02;
/*
        Senaryo;
        1- Siteyi açınız http://opencart.abstracta.us/index.php?route=account/login
        2- Top Menudeki menu elemanlarının olduğunu doğrulayınız. (menuValidation)
     */


import Utils.GeneralWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _01_ValidateMenu extends GeneralWebDriver {
    @Test
    void menuValidation() {

        List<String> menuExpectedList=new ArrayList<>(Arrays.asList("Desktops","Laptops & Notebooks",
                "Components","Tablets","Software","Phones & PDAs","Cameras","MP3 Players"));

        List<WebElement> menuActualList=driver.findElements(By.cssSelector("[class='nav navbar-nav']>li>a"));
        Assert.assertEquals(menuActualList.size(), 8);
        Tools.compareToList(menuExpectedList,menuActualList);
    }
}
