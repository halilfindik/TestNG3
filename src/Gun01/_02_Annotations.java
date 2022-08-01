package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {

    /*
        @BeforeClass -- > // Her class çalışıyorken önce burası çalışır
         @BeforeMethod--> // Her methoddan (test method) önce çalışır
            @Test     -->  Testlerin çalıştığı methodlar
            @Test     -->  Testlerin çalıştığı methodlar
         @AfterMethod --> // Her methoddan (test method) sonra çalışır
        @AfterClass -- > // Her class çalıştıktan sonra burası çalışır
     */
    @BeforeClass
    void beforeClass() {System.out.println("Her class'tan önce çalışacak : Before Class");}
    @BeforeMethod
    void beforeMethod() {System.out.println("Her test method'dan önce çalışacak : Before Method");}

    @Test
    void test1 () {System.out.println("Test-1 çalıştı.");}
    @Test
    void test2 () {System.out.println("Test-2 çalıştı.");}

    @AfterMethod
    void afterMethod() {System.out.println("Her test method'dan sonra çalışacak : After Method");}
    @AfterClass
    void afterClass() {System.out.println("Her class'tan sonra çalışacak : After Class");}
}
