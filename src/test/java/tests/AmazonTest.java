package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;


public class AmazonTest extends BaseTest {


    @Test
    public void AmazonTest() throws InterruptedException {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
        SearchPage searchPage = new SearchPage(driver,wait);
        ProductPage productPage = new ProductPage(driver,wait);

        //*************PAGE Methods********************
        //Open Amazon HomePage
        homePage.goToAmazon();

        searchPage.search("Iphone X");
        searchPage.checkSearch();
        searchPage.clickFirstProduct();

        float currentProductPrice=productPage.getProductPriceWithId("priceblock_ourprice");
        float otherSellerPrice=productPage.getProductPriceWithId("mbc-price-2");

        productPage.compareProductPrices(currentProductPrice,otherSellerPrice);
        productPage.verifyAddBasket();


    }
}