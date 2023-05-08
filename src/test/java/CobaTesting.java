import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CobaTesting {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://demo.guru99.com/test/guru99home/");

        driver.switchTo().frame("a077aa5e");

        driver.findElement(By.xpath("html/body/a/img")).click();
    }
}
