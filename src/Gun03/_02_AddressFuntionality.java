package Gun03;

import Utils.GeneralWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son eklenen adresi siliniz.
 */
public class _02_AddressFuntionality extends GeneralWebDriver {

    @Test
    void addAddress() {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();
        Tools.Bekle(2);
        WebElement newAddress = driver.findElement(By.linkText("New Address"));
        newAddress.click();
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("Karcan");
        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Korhan");
        WebElement addressInput = driver.findElement(By.id("input-address-1"));
        addressInput.sendKeys("Dünya Mahallesi");
        WebElement cityInput = driver.findElement(By.id("input-city"));
        cityInput.sendKeys("Small World");
        WebElement postcodeInput = driver.findElement(By.id("input-postcode"));
        postcodeInput.sendKeys("2359");
        WebElement countryList = driver.findElement(By.id("input-country"));
        Select country = new Select(countryList);
        country.selectByIndex(2);
        //Tools.Bekle(3);
        //wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("[id='input-zone']>option"),true));
        //wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("select[id='input-zone']>option"))));
        wait.until(ExpectedConditions.elementToBeClickable(countryList));
        WebElement zoneList = driver.findElement(By.id("input-zone"));
        Select zone = new Select(zoneList);
        zone.selectByIndex(1);
        //WebElement defaultAddress=driver.findElement(By.cssSelector("input[value='1']"));
        //defaultAddress.click();
        WebElement continueButton=driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation();
    }
    @Test (dependsOnMethods = {"editAddress"})
    void deleteLastAddress() {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();
        Tools.Bekle(2);
        List<WebElement> addresses= driver.findElements(By.cssSelector("a[class*='btn btn-danger']"));
        int totalAddress=addresses.size();
        addresses.get((addresses.size()-3)).click();
        Tools.successMessageValidation();
    }
    @Test (dependsOnMethods = {"addAddress"})
    void editAddress() {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll=driver.findElements(By.linkText("Edit"));
        WebElement lastAddressEdit= editAll.get(editAll.size()-1);
        lastAddressEdit.click();

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.clear();
        firstNameInput.sendKeys("Mehmet");

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Yılmaz");

        WebElement continueButton=driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();
        Tools.successMessageValidation();

    }
}
