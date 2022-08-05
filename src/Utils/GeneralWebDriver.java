package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneralWebDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void BaslangicIslemleri() {
        System.out.println("Driver start....");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        //System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // bütün webElement için geçerli
        // defaultta hiç bekleme yok, onun için pagetimeout implicitly wait'i basestaticdriver'da açmak lazım
        // pageloadtimeout açık olduğu için ilk elemanı bulabiliyor; ancak ikinci elemanı bulmak için ise
        // implicitly wait tanımlamak gerekiyor; bu tüm elemanlar için geçerli

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        LoginTest();
    }

    @AfterClass
    public void BitisIslemleri() {
        System.out.println("Driver stop....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
    void LoginTest() {

        WebElement emailInput= driver.findElement(By.id("input-email"));
        emailInput.sendKeys("karkor@gmail.com");
        WebElement passwordInput= driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("C6JyVMjBdi52RGy", Keys.ENTER);
        List<WebElement> logoutLink=driver.findElements(By.linkText("Logout"));

    }
}
