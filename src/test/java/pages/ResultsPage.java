package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultsPage extends BasePage{

    private final By movieName = By.xpath("//*[@id=\"card_movie_4bc88fc1017a3c122d009254\"]//a//h2");
    private final By filterBox = By.xpath("//*[@id=\"media_v4\"]//div[@data-callback = \"filterCallback()\"]");
    private final By actionFilter = By.xpath("//*[@id=\"with_genres\"]//li[@data-value = \"28\"]");
    private final By searchButton = By.xpath("//*[@class = \"apply full background_color light_blue enabled fixed\"]//p[@class = \"load_more\"]");
    private String movieChosenFromResults = "//*[@id = \"media_results\"]//div[@class = \"content\"]//a[@title = '%s']";
    private final By searchButtonDisabled = By.xpath("//*[@class = \"apply small background_color light_blue disabled\"]//p[@class = \"load_more\"]");

    private final By sortBox = By.xpath("//*[@class = \"k-dropdown-wrap k-state-default\"]//span[@class = \"k-icon k-i-arrow-60-down\"]");
    private final By dateAscendingOption = By.xpath("//*[@id =\"sort_by_listbox\"]//li[@data-offset-index = \"5\"]");
    private final By searchButtonSort = By.xpath("//*[@class = \"apply small background_color light_blue enabled\"]//p[@class = \"load_more\"]");
    private final By datesOfMovies = By.xpath("//*[@id =\"media_results\"]//div[@class = \"content\"]//p");


    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public ResultsPage selectActionFilter(){
        mapElement(filterBox).click();
        mapElement(actionFilter).click();
        return new ResultsPage(driver);
    }
    public ResultsPage waitForSearchButtonAppears(){
        WebDriverWait waitSearchButton = new WebDriverWait(driver,5);
        waitSearchButton.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        return new ResultsPage(driver);
    }

    public ResultsPage clickOnSearch(){
        mapElement(searchButton).click();
        return new ResultsPage(driver);
    }

    public MoviePage selectMovieFromSearch(String movieNameToSelect){
        mapElement(By.xpath(String.format(movieChosenFromResults, movieNameToSelect))).click();
        return new MoviePage(driver);
    }

    public ResultsPage waitForNewResults(){
        WebDriverWait waitActionFilter= new WebDriverWait(driver,5);
        waitActionFilter.until(ExpectedConditions.presenceOfElementLocated(searchButtonDisabled));
        return new ResultsPage(driver);
    }

    public ResultsPage selectSortAndSearch(){
        mapElement(sortBox).click();
        mapElement(dateAscendingOption).click();
        mapElement(searchButtonSort).click();
        return new ResultsPage(driver);
    }


    public String getMovieName(){
        return mapElement(movieName).getText();
    }

    public boolean verifyAscendingOrder(int numberOfMovies){
        List<WebElement> dates = mapElements(datesOfMovies);
        int[] years = new int[numberOfMovies];
        boolean state = false;

        for(int i=0;i<numberOfMovies;i++){
            String date = dates.get(i).getText();
            String[] temp = date.split(", ");
            years[i] = Integer.parseInt(temp[1]);
            System.out.println(temp[1]);
        }
        for(int i=0;i<numberOfMovies-1;i++){
            if(years[i]<=years[i+1]){
                state = true;
            }
        }
        return state;
    }

}