import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
//import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTesting {
    public static void main(String[] args) throws InterruptedException {
        //pemanggilan class webDriverManage, methode->chromedriver, setup->finish.
        WebDriverManager.firefoxdriver().setup();
        String itemBaju = "Sauce Labs Bolt T-Shirt";


        FirefoxDriver driver = new FirefoxDriver();
        //chromeDriver adalah class
        // constructor -> nama class (variable) = new nama class
        //driver get halaman web (step yg pertama)
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        //driver mencari locator
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        WebElement inputUserPassword = driver.findElement(By.id("password"));
        WebElement clickButtonLogin = driver.findElement(By.id("login-button"));

        //action on web
        inputUserName.sendKeys("standard_user");
        inputUserPassword.sendKeys("secret_sauce");
        clickButtonLogin.click();

        List<WebElement> items = driver.findElements(By.cssSelector("div[class*='inventory_item_name']"));

        for(int i = 0; i <= items.size(); i++) {
            if (items.get(i).getText().equalsIgnoreCase(itemBaju)){
                items.get(i).click();
                WebElement actual = driver.findElement(By.cssSelector("div[class*='inventory_details_price']"));
                String actualResult = actual.getText();
                String expect = "$15.99";
                Assert.assertEquals(actualResult, expect);
                Thread.sleep(3000);

                WebElement btnAddToCart = driver.findElement(By.cssSelector("button[class*='btn btn_primary btn_small btn_inventory'"));
                btnAddToCart.click();

                WebElement iconCart = driver.findElement(By.cssSelector("a[class*='shopping_cart_link']"));
                iconCart.click();

                WebElement actualCart = driver.findElement(By.cssSelector("div[class*='inventory_item_name']"));
                String actualCartText = actualCart.getText();
                String expectCartText = "Sauce Labs Bolt T-Shirt";
                Assert.assertEquals(actualCartText, expectCartText);

                WebElement actualCartPrice = driver.findElement(By.cssSelector("div[class*='inventory_item_price']"));
                String actualCartPriceText = actualCartPrice.getText();
                String expectCartPrice = "$15.99";
                Assert.assertEquals(actualCartPriceText,expectCartPrice);

                WebElement btnCheckout = driver.findElement(By.cssSelector("button[id*='checkout']"));
                btnCheckout.click();

                WebElement inputFirstName = driver.findElement(By.cssSelector("input[id*='first-name']"));
                inputFirstName.sendKeys("Iksan");
                Thread.sleep(1000);

                WebElement inputLastName = driver.findElement(By.cssSelector("input[id*='last-name"));
                inputLastName.sendKeys("A R");
                Thread.sleep(1000);

                WebElement inputZipCode = driver.findElement(By.cssSelector("input[id*='postal-code']"));
                inputZipCode.sendKeys("10210");
                Thread.sleep(1000);

                WebElement btnContinue = driver.findElement(By.cssSelector("input[id*='continue']"));
                btnContinue.click();

                WebElement actualPriceItem = driver.findElement(By.cssSelector("div[class*='summary_subtotal_label']"));
                String actualPriceItemText = actualPriceItem.getText();
                String expectPriceItemText = "Item total: $15.99";
                Assert.assertEquals(actualPriceItemText,expectPriceItemText);

                WebElement actualTax = driver.findElement(By.cssSelector("div[class*='summary_tax_label']"));
                String actualTaxPrice = actualTax.getText();
                String expectTaxPrice = "Tax: $1.28";
                Assert.assertEquals(actualTaxPrice,expectTaxPrice);

                WebElement actualTotal = driver.findElement(By.cssSelector("div[class*='summary_info_label summary_total_label']"));
                String actualTotalPrice = actualTotal.getText();
                String expectTotal = "Total: $17.27";
                Assert.assertEquals(actualTotalPrice,expectTotal);

                WebElement btnFinish = driver.findElement(By.cssSelector("button[id*='finish']"));
                btnFinish.click();

                Thread.sleep(1000);

                WebElement btnBack = driver.findElement(By.cssSelector("button[id*='back-to-products']"));
                btnBack.click();

                Thread.sleep(2000);
            }
        }


        driver.quit();



//        WebElement productItem1 = driver.findElement(By.xpath("//div[@class='inventory_item_name'][text()='Sauce Labs Bolt T-Shirt']"));
//        productItem1.click();
////        System.out.println(productItem1.getText());
////        Assert.as;
//        WebElement addToCart1 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt'][text()='Add to cart']"));
//        addToCart1.click();
//        driver.navigate().to("https://www.saucedemo.com/inventory.html");
//        Thread.sleep(500);
//        WebElement productItem2 = driver.findElement(By.xpath("//div[@class='inventory_item_name'][text()='Sauce Labs Backpack']"));
//        productItem2.click();
//        WebElement addToCart2 = driver.findElement(By.cssSelector("button[id*='add-to-cart-sauce-labs-backpack']"));
//        addToCart2.click();
//        WebElement btnShoppingCart = driver.findElement(By.cssSelector("div[class*='shopping_cart_container']"));
//        btnShoppingCart.click();
//        WebElement btnCheckout = driver.findElement(By.cssSelector("button[id*='checkout']"));
//        btnCheckout.click();

//        Thread.sleep(3000);
//        driver.quit();

    }
}
