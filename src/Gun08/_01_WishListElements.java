package Gun08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _01_WishListElements {

    public _01_WishListElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "search")
    public WebElement searchBox;

    @FindBy (css = "[data-original-title='Add to Wish List']")
    public List<WebElement> items;

    @FindBy (xpath = "(//*[@class='alert alert-success alert-dismissible']//following-sibling::a)[1]")
    public WebElement wishedItem;

    @FindBy (css = "[class='fa fa-heart']")
    public WebElement wishList;

    @FindBy (css = "[class='text-left']>a")
    public WebElement wishListProducts;

    @FindBy (css = "[class='fa fa-times']")
    public WebElement removeWishedItem;




}
