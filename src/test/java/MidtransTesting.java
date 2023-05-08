import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MidtransTesting {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://demo.midtrans.com/");

        WebElement buttonBuy = driver.findElement(By.xpath("//a[@class='btn buy']"));
        buttonBuy.click();

        WebElement formPrice = driver.findElement(By.xpath("//input[@class='text-right']"));
        formPrice.clear();
        formPrice.sendKeys("45000");

        WebElement forName = driver.findElement(By.xpath("//input[@value='Budi']"));
        forName.clear();
        forName.sendKeys("Ahmad");

        WebElement buttonCheckout = driver.findElement(By.xpath("//div[@class='cart-checkout']"));
        buttonCheckout.click();

        Thread.sleep(3000);

        driver.switchTo().frame("snap-midtrans"); //by id
        System.out.println("********We are switch to the iframe*******");

        Thread.sleep(3000);

        WebElement payMethode = driver.findElement(By.xpath("//a[@href='#/bank-transfer']"));
        payMethode.click();

        WebElement bcaPayVa = driver.findElement(By.xpath("//a[@href='#/bank-transfer/bca-va']"));
        bcaPayVa.click();

        Thread.sleep(6000);

        WebElement btnBack = driver.findElement(By.xpath("//button[@class='btn full primary']"));
        btnBack.click();


        Thread.sleep(6000);
        driver.quit();

    }
}
