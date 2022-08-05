package Gun02;

import Utils.GeneralWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.tools.Tool;

/*
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
      5- Bu işlemi 2 kez çalıştırarak eski haline getiriniz.
*/
public class _03_EditAccount extends GeneralWebDriver {

    @Test
    void editAccount() {
        editAccount("Bora","Kayacan");
        Tools.Bekle(2);
        editAccount("Karcan","Korhan");
    }

    void editAccount(String name, String surname) {
        WebElement editAccount= driver.findElement(By.linkText("Edit Account"));
        editAccount.click();
        WebElement nameInput= driver.findElement(By.id("input-firstname"));
        nameInput.clear();
        nameInput.sendKeys(name);
        WebElement lastnnameInput= driver.findElement(By.id("input-lastname"));
        lastnnameInput.clear();
        lastnnameInput.sendKeys(surname);
        WebElement continueButton= driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();
        Tools.successMessageValidation();
    }
}
