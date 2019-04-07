package pages;

import logger.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class HomePage extends BasePage {
    public static TestLogger logger = TestLogger.getInstance();
    //*********Constructor*********
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Page Variables*********
    String baseURL = "http://www.amazon.com.tr/";

    //*********Page Methods*********

    //Go to Homepage
    public void goToAmazon() {
        driver.get(baseURL);
        logger.log("Anasayfaya Gidildi");
    }

}