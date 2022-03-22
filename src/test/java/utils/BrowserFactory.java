package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver getBrowser(String browserName) {
        WebDriver webDriver = null;
        if (browserName.equals("Chrome") ) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        return webDriver;
    }
}
