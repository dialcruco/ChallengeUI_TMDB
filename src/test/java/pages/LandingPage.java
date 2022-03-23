package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{

    private By loginButtonHome = By.xpath("//*[@class = \"primary\"]//a[@href = \"/login\"]");
    private By searchBar = By.id("inner_search_v4");
    private By searchButton = By.xpath("//*[@id=\"inner_search_form\"]/input"); //Es válido este XPath?


    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLogin(){
        driver.findElement(loginButtonHome).click();
        return new LoginPage(driver);
    }

    /**
     * (Method description)
     * @param query lkshlkfa
     * @return aslkdhsakdj
     */
    public LandingPage searchQuery(String query){
        //Log: searching query: (parameter query)
        driver.findElement(searchBar).sendKeys(query);
        return new LandingPage(driver);
    }

    public ResultsPage searchButtonClick(){
        //Log: Clicking on search button.
        driver.findElement(searchButton).click();
        return new ResultsPage(driver);
    }




}
