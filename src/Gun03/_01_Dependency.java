package Gun03;

import Utils.GeneralWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
Interview'da sorulan soru: testlerde öncelikleri nasıl belirlersin?
priority, dependency; Nasıl kullanırsın?
 1-Priority = 1 gibi; sıralı rakamlar vererek
 2- dependOnMethods : Bununla kendinden önce hangi metod çalışması gerekiyor ise onu belirtirim.
Bir metodu direkt çalıştırdığınızda kendinden önce bağımlı metod var ise ototmaitk onları
önce çağırıp sonra kendisi çalışır. Fakat 2 veya daha fazla tane var ise bağımlı olduğu metod ozaman çalışamaz.
 */
public class _01_Dependency extends GeneralWebDriver {
    @Test
    void startCar()
    {
        System.out.println("Car is started.");
    }
    @Test (dependsOnMethods = {"startCar"}) // bu testin çalışması startCar'ın hatasız çalışmasına bağlı
    void driveCar()
    {
        System.out.println("Car is driven.");
        Assert.fail();
    }
    @Test (dependsOnMethods = {"startCar","driveCar"})
    void parkCar()
    {
        System.out.println("Car is parked.");
    }
    @Test (dependsOnMethods = {"parkCar"},alwaysRun = true) // alwaysRun=true; hata çıksa da yine de çalıştırır
    void stopCar()
    {
        System.out.println("Car is stopped.");
    }
}
