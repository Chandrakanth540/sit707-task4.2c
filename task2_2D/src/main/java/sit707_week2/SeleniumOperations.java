package sit707_week2;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) throws IOException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\VE\\Downloads\\geckodriver-v0.34.0-win-aarch64 (1)\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);



        driver.quit();
    }

}
