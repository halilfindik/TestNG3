package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {



    @Test (priority = 1) // annotation
    void webSitesiniAc () {
        System.out.println("Driver tanımlandı ve web sitesi açıldı.");
    }
    @Test (priority = 2) // annotation
    void loginTestIsleminiYap() {
        System.out.println("Login test işlemleri yapıldı.");
    }
    @Test (priority = 3) // annotation
    void driveriKapat() {
        System.out.println("Driver kapatıldı ve çıkıldı.");
    }

}
