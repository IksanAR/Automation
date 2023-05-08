import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TugasTesting {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        WebElement inputFirstname = driver.findElement(By.id("first-name"));
        inputFirstname.sendKeys("Iksan");
        WebElement inputLastName = driver.findElement(By.id("last-name"));
        inputLastName.sendKeys("A R");
        WebElement inputJobTitle = driver.findElement(By.id("job-title"));
        inputJobTitle.sendKeys("Kepo");
        WebElement inputRadioButton = driver.findElement(By.id("radio-button-1"));
        inputRadioButton.click();
        WebElement inputCheckBox = driver.findElement(By.id("checkbox-1"));
        inputCheckBox.click();
        Select inputSelect = new Select(driver.findElement(By.id("select-menu")));
        inputSelect.selectByValue("1");
//        WebElement inputDate = driver.findElement(By.id("datepicker"));
//        inputDate.sendKeys("03/20/2023");
        WebElement inputDate = driver.findElement(By.id("datepicker"));
        inputDate.click();

//        WebElement selectDate = driver.findElement(By.cssSelector("tbody tr:nth-child(3) td:nth-child(2)"));
        WebElement selectDate = driver.findElement(By.xpath("//td[@data-date='1679529600000']"));
        selectDate.click();
        Thread.sleep(6000);


        WebElement btnSubmit = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary']"));
        btnSubmit.click();



        Thread.sleep(6000);
        driver.quit();





    }
}
