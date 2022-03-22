package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActorPage extends BasePage{

    private By movieListOfActor = By.xpath("//*[@id=\"media_v4\"]//a[@class=\"tooltip\"]/bdi");

    public ActorPage(WebDriver driver) {
        super(driver);
    }

    //Método de verificación de película escogida en la lista del actor escogido.
    public String getMovieFromActor(){
        List<WebElement> movies = driver.findElements(movieListOfActor);
        String allMovies = "";
        for(WebElement movieSelected : movies){
            allMovies += movieSelected.getText();
            allMovies += " ";
        }
        return allMovies;
    }
}
