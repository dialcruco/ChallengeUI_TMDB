package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage{

    private By profileName = By.xpath("//*[@class = \"about\"]//a");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileName(WebDriver driver){
        return mapElement(profileName).getText();
    }

}
