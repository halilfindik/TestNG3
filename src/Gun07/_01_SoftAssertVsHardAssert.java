package Gun07;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {

    @Test
    void hardAssert() {
        String s1="Merhaba";
        System.out.println("Hard Assert Öncesi...");
        Assert.assertEquals("Merhaba 123",s1,"Hard Assert Hatası");
    }

    @Test
    void softAssert() {
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert _softAssert=new SoftAssert();
        _softAssert.assertEquals("www.facebook.com/homepage",strHomePage);
        System.out.println("Assert 1");

        _softAssert.assertEquals("www.facebook.com/profile",strCartPage);
        System.out.println("Assert 2");

        _softAssert.assertEquals("www.facebook.com/settings",strEditAccount);
        System.out.println("Assert 3");

        _softAssert.assertAll(); // bütün sonuçlarını işleme koyuyor
        System.out.println("Aktiflik Sonrası"); // Bu bölüm assertAll'dan sonra olduğu ve öncesinde
                                                // hata oluştuğu için yazılmadı.

    }
}
