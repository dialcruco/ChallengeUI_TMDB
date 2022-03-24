package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    private final By moviesButtonHome = By.xpath("//li[@class = \"k-item k-menu-item k-state-default k-first\"]//a[@class = \"no_click k-link k-menu-link\"]");
    private final By topRatedButton = By.xpath("//*[@href = \"/movie/top-rated\"]");
    private final By nowPlayingButton = By.xpath("//*[@href = \"/movie/now-playing\"]");
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private static Logger loggerBasePage = LogManager.getLogger(BasePage.class);

    public ResultsPage clickOnTopRatedMovies(){
        loggerBasePage.info("Clicking on 'Top-Rated' movies.");
        driver.findElement(moviesButtonHome).click();
        driver.findElement(topRatedButton).click();
        return new ResultsPage(driver);
    }

    public ResultsPage clickOnNowPlayingMovies(){
        loggerBasePage.info("Clicking on 'Now Playing' movies.");
        driver.findElement(moviesButtonHome).click();
        driver.findElement(nowPlayingButton).click();
        return new ResultsPage(driver);
    }

    public WebElement mapElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> mapElements(By locator){
        return driver.findElements(locator);
    }
}
