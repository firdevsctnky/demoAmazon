package pages;

import logger.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BasePage {

    public static TestLogger logger = TestLogger.getInstance();
    String searchBox = "twotabsearchtextbox";

    String searchBtn = "issDiv0";

    //*********Constructor*********
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Page Methods*********

    public void search(String keyword) {
        try {
            writeText(By.id(searchBox), keyword);
            sleep(1000);
            click(By.id(searchBtn));
            sleep(3000);
        } catch (Exception exception) {
            logger.log(exception.getMessage());
        }

    }

    public void checkSearch() {

        WebElement element = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold'][contains(.,'\"iphone x\"')]"));
        Assert.assertTrue(element != null, "Arama Başarılı.");
    }

    public void clickFirstProduct() {
        try {
            click(By.xpath("((//div[@class='a-section a-spacing-medium'])[1]//a)[2]"));
            sleep(2000);
            scrollDown();
        } catch (Exception exception) {
            logger.log(exception.getMessage());
        }

    }

}