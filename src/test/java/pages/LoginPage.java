package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LoginPage extends LandingPage{

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login_button");
    private By badConfirmMessage = By.xpath("//*[@class = \"background_color red\"]//span");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage enterUsernameAndPassword(String state){
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
        mapElement(loginButton).click();
        return new ProfilePage(driver);
    }

    public LoginPage loginClickFailed(){
        mapElement(loginButton).click();
        return new LoginPage(driver);
    }
    public String getBadConfirmation(WebDriver driver){
        return mapElement(badConfirmMessage).getText();
    }

}
