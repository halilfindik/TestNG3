package Gun01;

/*
   Senaryo ;
     1- http://opencart.abstracta.us/index.php?route=account/login  sitesini açınız.
     2- New Customer kısmında "Continue" tuşuna bas
     3- asd@gmail.com  ve 123qweasd   bilgileri ile login olan test metodunu yazınız.
     4- Login olup olmadığınızı assert ile kontrol ediniz.

 */

import Utils.GeneralWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _05_Ornek extends GeneralWebDriver {

    @Test
    void LoginTest() {

        WebElement emailInput= driver.findElement(By.id("input-email"));
        emailInput.sendKeys("karkor@gmail.com");
        WebElement passwordInput= driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("C6JyVMjBdi52RGy", Keys.ENTER);
        List<WebElement> logoutLink=driver.findElements(By.linkText("Logout"));
        Assert.assertEquals(logoutLink.size(), 1);

    }

}
