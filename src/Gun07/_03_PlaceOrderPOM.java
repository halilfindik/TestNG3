package Gun07;

import Utils.GeneralWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _03_PlaceOrderPOM extends GeneralWebDriver { //POM: Page Object Model
    @Test
    void ConfirmOrder() {

        _03_PlaceOrderElements elements=new _03_PlaceOrderElements(driver);

        elements.searchBox.clear();
        elements.searchBox.sendKeys("ipod" + Keys.ENTER);
        elements.ipods.get(0).click();
        elements.cart.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.addressContinue)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.shippingContinue)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.shippingMethodContinue)).click();
        elements.agreeButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.paymentMethodContinue)).click();
        elements.confirmButton.click();
        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertTrue(elements.orderCompleteMessage.getText().contains("Your order has been placed"));

    }
}
