package Gun02;

import Utils.GeneralWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.tools.Tool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe ve UnSubscribe işlemlerini ayrı ayı testlerde yapınız.
 */
public class _02_Subscribe extends GeneralWebDriver {

    By link=By.linkText("Newsletter");
    By yes=By.cssSelector("input[value='1']");
    By no=By.cssSelector("input[value='0']");
    By continueClick=By.cssSelector("input[value='Continue']");

    @Test (priority = 1)
    void newsletterSubscriptionYes() {
        WebElement newsletter= driver.findElement(link);
        newsletter.click();
        WebElement subscribeYes=driver.findElement(yes);
        subscribeYes.click();
        WebElement subscribeContinue=driver.findElement(continueClick);
        subscribeContinue.click();
        Tools.successMessageValidation();
    }
    @Test (priority = 2)
    void newsletterSubscriptionNo() {
        WebElement newsletter= driver.findElement(link);
        newsletter.click();
        WebElement subscribeNo=driver.findElement(no);
        subscribeNo.click();
        WebElement subscribeContinue=driver.findElement(continueClick);
        subscribeContinue.click();
        Tools.successMessageValidation();
    }
    @Test (priority = 3)
    void newsletterSubscriptionVisaVerse() {
        WebElement newsletter= driver.findElement(link);
        newsletter.click();
        WebElement subscribeYes=driver.findElement(yes);
        WebElement subscribeNo=driver.findElement(no);
        WebElement subscribeContinue=driver.findElement(continueClick);
        if (subscribeNo.isSelected()) {
            subscribeYes.click();
        } else {
            subscribeNo.click();
        }
        subscribeContinue.click();
        Tools.successMessageValidation();
    }
}
