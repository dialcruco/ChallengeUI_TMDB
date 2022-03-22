package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.BrowserFactory;

public class Hooks {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("Chrome") String browser){
        driver.set(BrowserFactory.getBrowser(browser));
        getDriver().manage().window().maximize();
        getDriver().navigate().to("https://www.themoviedb.org/");
    }

    public static WebDriver getDriver(){
        return driver.get();
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
    /*
    @AfterMethod
    public void tearDown() {
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File("./target/"+ Math.random()*6 +"screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

     */

}
