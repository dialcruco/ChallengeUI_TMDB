package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MoviePage extends BasePage{

    private By movieGenres = By.xpath("//*[@class=\"genres\"]/a");
    private By actorToSelect = By.xpath("//*[@id = \"cast_scroller\"]//a[@href = \"/person/3896-liam-neeson\"]");


    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public ActorPage selectActor(){
        driver.findElement(actorToSelect).click();
        return new ActorPage(driver);
    }

    public String getMovieGenre(){
        List<WebElement> genres = driver.findElements(movieGenres);
        String allGenres = "";
        for (WebElement genreToChoose : genres) {
            allGenres += genreToChoose.getText();
            allGenres += " ";
        }
        System.out.println(allGenres);
        return allGenres;
    }
}
