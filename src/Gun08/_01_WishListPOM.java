package Gun08;

import Utils.GeneralWebDriver;
import Utils.Tools;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
    Senaryo ;
   1- Siteye gidiniz..
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */
public class _01_WishListPOM extends GeneralWebDriver {

    @Test
    @Parameters("keyword")
    void addToWishList(String keyword) {
        _01_WishListElements elements = new _01_WishListElements(driver);

        elements.searchBox.clear();
        elements.searchBox.sendKeys(keyword + Keys.ENTER);
        int random = Tools.randomGenerator(elements.items.size());
        elements.items.get(random).click();
        String wishedItem=wait.until(ExpectedConditions.elementToBeClickable(elements.wishedItem)).getText();
        elements.wishList.click();
        wait.until(ExpectedConditions.visibilityOf(elements.wishListProducts));
        Assert.assertTrue(elements.wishListProducts.getText().contains(wishedItem));
        elements.removeWishedItem.click();

    }
}
