package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MoviePage extends BasePage{

    private final By movieGenres = By.xpath("//*[@class=\"genres\"]/a");
    private final String actorSelected = "//*[@id = \"cast_scroller\"]//img[@alt = '%s']";

    private static Logger loggerMoviePage = LogManager.getLogger(MoviePage.class);

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    /**
     *
     * @param actorToSelect
     * @return
     */
    public ActorPage selectActor(String actorToSelect){
        loggerMoviePage.info("Selecting from 'Top Billed Cast' section the actor: " + actorToSelect);
        mapElement(By.xpath(String.format(actorSelected, actorToSelect))).click();
        return new ActorPage(driver);
    }

    /**
     *
     * @return
     */
    public String getMovieGenre(){
        loggerMoviePage.info("Getting genres of movie selected.");
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
