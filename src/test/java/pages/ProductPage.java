package pages;

import logger.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage extends BasePage {
    public static TestLogger logger = TestLogger.getInstance();
    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public float getProductPriceWithId(String elementId){
        Float productPrice = 0.0F;
        try {
            WebElement product = driver.findElement(By.id(elementId));
             productPrice= Float.parseFloat(product.getText().replace(".","").replace(",",".").replace("TL","").replace(" ",""));
            return productPrice;
        }
        catch(Exception expection){
            logger.log(expection.getMessage());
        }
        return productPrice;
    }


    public void compareProductPrices(float currentPrice, float otherSellerPrice){
        try {
            if (currentPrice<=otherSellerPrice){
                click(By.id("add-to-cart-button"));
            }
            else {
                click(By.id("mbc-buybutton-addtocart-2-announce"));
            }
            sleep(2000);
        }
        catch(Exception expection){
            logger.log(expection.getMessage());
        }

    }

    public void verifyAddBasket(){
        Assert.assertTrue(By.xpath("//h1[contains(.,'Sepete Eklendi')]")!= null,"Sepete Eklendi");
    }

}
