package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultsPage extends BasePage{

    private By movieName = By.xpath("//*[@id=\"card_movie_4bc88fc1017a3c122d009254\"]//a//h2");
    private By filterBox = By.xpath("//*[@id=\"media_v4\"]//div[@data-callback = \"filterCallback()\"]");
    private By actionFilter = By.xpath("//*[@id=\"with_genres\"]//li[@data-value = \"28\"]");
    private By searchButton = By.xpath("//*[@class = \"apply full background_color light_blue enabled fixed\"]//p[@class = \"load_more\"]");
    //private By movieChosenFromResults = By.xpath("//*[@id = \"media_results\"]//div[@class = \"content\"]//a[@title = '%s']");
    private String movieChosenFromResults = "//*[@id = \"media_results\"]//div[@class = \"content\"]//a[@title = '%s']";
    private By movieChosenValidate = By.xpath("//*[@id = \"media_results\"]//div[@class = \"content\"]//a[@title = \"Blacklight\"]");

    private By sortBox = By.xpath("//*[@class = \"k-dropdown-wrap k-state-default\"]//span[@class = \"k-icon k-i-arrow-60-down\"]");
    private By dateAscendingOption = By.xpath("//*[@id =\"sort_by_listbox\"]//li[@data-offset-index = \"5\"]");
    private By searchButtonSort = By.xpath("//*[@class = \"apply small background_color light_blue enabled\"]//p[@class = \"load_more\"]");
    private By datesOfMovies = By.xpath("//*[@id =\"media_results\"]//div[@class = \"content\"]//p");

    private By sectionResultsWithFilter = By.id("page_1");


    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public ResultsPage selectActionFilter(){
        driver.findElement(filterBox).click();
        driver.findElement(actionFilter).click();
        return new ResultsPage(driver);
    }
    public ResultsPage waitForSearchButtonAppears(){
        WebDriverWait waitSearchButton = new WebDriverWait(driver,5);
        waitSearchButton.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        return new ResultsPage(driver);
    }

    public ResultsPage clickOnSearch(){
        driver.findElement(searchButton).click();
        return new ResultsPage(driver);
    }

    public MoviePage selectMovieFromSearch(String movieName1){
        driver.findElement(By.xpath(String.format(movieChosenFromResults, movieName1))).click();

        /*
        public void setAFilter(String filter, String value) {
            driver.findElement(By.xpath(String.format(xpathFilters, filter, value))).click();
        }

         */
        return new MoviePage(driver);
    }
    public MoviePage selectMovieToValidate(){
        driver.findElement(movieChosenValidate).click();
        return new MoviePage(driver);
    }

    public ResultsPage waitForNewResults(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return new ResultsPage(driver);
    }

    public ResultsPage waitForResults(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sectionResultsWithFilter));
        //wait.until(ExpectedConditions.elementToBeSelected(actionClicked)); //Crear el BY de "actionClicked" y buscar su Xpath
        //wait.until(ExpectedConditions.presenceOfElementLocated(movieChosen));
        return new ResultsPage(driver);
    }


    public ResultsPage selectSortAndSearch(){
        mapElement(sortBox).click();
        mapElement(dateAscendingOption).click();
        mapElement(searchButtonSort).click();
        return new ResultsPage(driver);
    }

    public ResultsPage verifyAscendingOrder(){ //REVISAR!
        List<WebElement> dates = driver.findElements(datesOfMovies);
        ArrayList<String> datesOnString = new ArrayList<>();
        for(int i=0;i<4;i++){
            datesOnString.add(dates.get(i).getText());
            System.out.println(datesOnString);
        }
        /*
        for(WebElement fecha : dates){
            System.out.println(fecha.getText() + " / ");
        }
         */
        return new ResultsPage(driver);
    }

    /*
    public ResultsPage waitForResultsSort(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(popMovieChosen));
        return new ResultsPage(driver);
    }
    */

    public String getMovieName(){
        return driver.findElement(movieName).getText();
    }

}