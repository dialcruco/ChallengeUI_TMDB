package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MoviePage extends BasePage{

    private final By movieGenres = By.xpath("//*[@class=\"genres\"]/a");
    private final String actorSelected = "//*[@id = \"cast_scroller\"]//img[@alt = '%s']";

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public ActorPage selectActor(String actorToSelect){
        mapElement(By.xpath(String.format(actorSelected, actorToSelect))).click();
        return new ActorPage(driver);
    }

    public String getMovieGenre(){
        List<WebElement> genres = mapElements(movieGenres);
        String allGenres = "";
        for (WebElement genreToChoose : genres) {
            allGenres += genreToChoose.getText();
            allGenres += " ";
        }
        System.out.println(allGenres);
        return allGenres;
    }
}
