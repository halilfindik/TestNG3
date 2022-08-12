package Gun07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _03_PlaceOrderElements {
    // Bu sayfadaki bütün elemenaların driver bağlantısı gerekiyor
    // bunun için aşağıdaki consructor eklendi ve içine PageFatory ile
    // driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
    // Böylece Sayfa'dan nesne türetildiği zaman değil, kullanıldığı
    // anda elemanların bulunması aktif oluyor. Bu yöntemle bütün sayfalarda
    // aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
    // gelmiş oluyor. Bu yapıya Page Object Model (POM) adı veriliyor.

    public _03_PlaceOrderElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "search")
    public WebElement searchBox;

    @FindBy (linkText = "Checkout")
    public WebElement cart;

    @FindBy (xpath = "//span[text()='Add to Cart']")
    public List<WebElement> ipods;

    @FindBy(id = "button-payment-address")
    public WebElement addressContinue;

    @FindBy(id = "button-shipping-address")
    public WebElement shippingContinue;

    @FindBy(id = "button-shipping-method")
    public WebElement shippingMethodContinue;

    @FindBy(id = "button-payment-method")
    public WebElement paymentMethodContinue;

    @FindBy(name = "agree")
    public WebElement agreeButton;

    @FindBy(id = "button-confirm")
    public WebElement confirmButton;

    @FindBy(css = "[id='content']")
    public WebElement orderCompleteMessage;
}
