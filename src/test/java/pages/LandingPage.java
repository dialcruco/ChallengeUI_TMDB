package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.MovieTest;

public class LandingPage extends BasePage{

    private final By loginButtonHome = By.xpath("//*[@class = \"primary\"]//a[@href = \"/login\"]");
    private final By searchBar = By.id("inner_search_v4");
    private final By searchButton = By.xpath("//*[@id=\"inner_search_form\"]/input"); //Es válido este XPath?

    private static Logger loggerLandingPage = LogManager.getLogger(LandingPage.class);

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLogin(){
        loggerLandingPage.info("Clicking on 'Login' button at Home.");
        mapElement(loginButtonHome).click();
        return new LoginPage(driver);
    }

    /**
     * (Method description)
     * @param query
     * @return
     */
    public LandingPage searchQuery(String query){
        loggerLandingPage.info("Sending keys of the movie.");
        mapElement(searchBar).sendKeys(query);
        return new LandingPage(driver);
    }

    public ResultsPage searchButtonClick(){
        mapElement(searchButton).click();
        loggerLandingPage.info("Clicking on search button.");
        return new ResultsPage(driver);
    }




}
