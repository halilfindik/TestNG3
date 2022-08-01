package Gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {
    // Yeşil Tik  : Test'te hata yok
    // Sarı Çarpı : Test'te hata var
    // Beyaz      : Test atlandı/çalıştırılmadı (skip)

    @Test
    void EqualOrnek() {
        String s1="Merhaba";
        String s2="İyi akşamlar";

        // actual, expected, fail subject
        Assert.assertEquals(s1,s2,"Karşılaştırma Sonucu");
    }

    @Test
    void NotEqualOrnek() {
        String s1="Merhaba";
        String s2="İyi akşamlar";

        // actual, expected, fail subject
        Assert.assertNotEquals(s1,s2,"Karşılaştırma Sonucu");
    }

    @Test
    void TrueOrnek() {
        int i1=55;
        int i2=555;

        // actual, expected, fail subject
        Assert.assertTrue(i1==i2,"Karşılaştırma Sonucu");
    }

    @Test
    void NullOrnek() {
        String s1=null;

        // actual, expected, fail subject
        Assert.assertNull(s1,"Karşılaştırma Sonucu");
    }
    @Test
    void DirectFail() {
        Assert.fail();
    }
}