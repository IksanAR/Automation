import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollTesting {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        FirefoxDriver driver = new FirefoxDriver();
//        WebDriverManager.chromedriver().setup();

//        ChromeDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        //maximize
        driver.manage().window().maximize();
        //jsexecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //sc down
        jse.executeScript("window.scrollBy(0,250);");

        Thread.sleep(3000);
        //sc up
        jse.executeScript("window.scrollBy(0,-250);");
        //minimize
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com/");

        Thread.sleep(3000);
        driver.quit();




    }
}
