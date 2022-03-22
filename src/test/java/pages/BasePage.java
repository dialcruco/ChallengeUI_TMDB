package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class BasePage {

    protected WebDriver driver;
    private By moviesButtonHome = By.xpath("//li[@class = \"k-item k-menu-item k-state-default k-first\"]//a[@class = \"no_click k-link k-menu-link\"]");
    private By topRatedButton = By.xpath("//*[@href = \"/movie/top-rated\"]");
    private By nowPlayingButton = By.xpath("//*[@href = \"/movie/now-playing\"]");
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultsPage clickOnTopRatedMovies(){
        driver.findElement(moviesButtonHome).click();
        driver.findElement(topRatedButton).click();
        return new ResultsPage(driver);
    }

    public ResultsPage clickOnNowPlayingMovies(){
        driver.findElement(moviesButtonHome).click();
        driver.findElement(nowPlayingButton).click();
        return new ResultsPage(driver);
    }

    public WebElement mapElement(By locator){
        return driver.findElement(locator);
    }
}