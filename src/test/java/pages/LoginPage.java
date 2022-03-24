package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.LoginTest;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LoginPage extends LandingPage{

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login_button");
    private By badConfirmMessage = By.xpath("//*[@class = \"background_color red\"]//span");

    private static Logger loggerLoginPage = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     *
     * @param state
     * @return
     */
    public LoginPage enterUsernameAndPassword(String state){
        loggerLoginPage.info("Filling 'username' and 'password' fields.");
        String username = "";
        String password = "";
        String wrongPassword = "NotAValidPassword";

        Map variablesMap = System.getenv();
        Set keys = variablesMap.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            String value = (String) variablesMap.get(key);
            if(key.equals("USERNAME_UI_CHALLENGE")){
                username = value;
            }
            if(key.equals("PASSWORD_UI_CHALLENGE")){
                password = value;
            }
        }
        mapElement(usernameField).sendKeys(username);
        if (state.equals("success")) {
            mapElement(passwordField).sendKeys(password);
        } else if(state.equals("failed")){
            mapElement(passwordField).sendKeys(wrongPassword);
        }
        return new LoginPage(driver);
    }
    public ProfilePage loginClick(){
        loggerLoginPage.info("Clicking on 'Login' button.");
        mapElement(loginButton).click();
        return new ProfilePage(driver);
    }

    public LoginPage loginClickFailed(){
        loggerLoginPage.info("Clicking on 'Login' button.");
        mapElement(loginButton).click();
        return new LoginPage(driver);
    }
    public String getBadConfirmation(WebDriver driver){
        loggerLoginPage.info("Getting non-successful login message.");
        return mapElement(badConfirmMessage).getText();
    }

}
