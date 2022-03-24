package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.LoginTest;

public class ProfilePage extends BasePage{

    private By profileName = By.xpath("//*[@class = \"about\"]//a");

    private static Logger loggerProfilePage = LogManager.getLogger(ProfilePage.class);

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    /**
     *
     * @param driver
     * @return
     */
    public String getProfileName(WebDriver driver){
        loggerProfilePage.info("Getting the username from profile.");
        return mapElement(profileName).getText();
    }

}
