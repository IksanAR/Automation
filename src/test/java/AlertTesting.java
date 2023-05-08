import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertTesting {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clickButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        clickButton.click();
        Thread.sleep(5000);


        driver.switchTo().alert().accept();

        Thread.sleep(6000);
        driver.quit();
    }
}
