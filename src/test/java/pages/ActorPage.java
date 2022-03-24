package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActorPage extends BasePage{

    private By movieListOfActor = By.xpath("//*[@id=\"media_v4\"]//a[@class=\"tooltip\"]/bdi");

    private static Logger loggerActorPage = LogManager.getLogger(ActorPage.class);

    public ActorPage(WebDriver driver) {
        super(driver);
    }

    /**
     *
     * @return
     */
    public String getMovieFromActor(){
        loggerActorPage.info("Verifying the movie selected is on the acting history list.");
        List<WebElement> movies = mapElements(movieListOfActor);
        String allMovies = "";
        for(WebElement movieSelected : movies){
            allMovies += movieSelected.getText();
            allMovies += " ";
        }
        return allMovies;
    }
}
