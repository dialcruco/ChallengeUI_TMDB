package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginTest extends Hooks{

    @Test
    public void successfulLogin(){
        LandingPage landingPageSuccessful = new LandingPage(getDriver());

        LoginPage loginPage = landingPageSuccessful.clickOnLogin();
        loginPage.enterUsernameAndPassword("success");
        ProfilePage newProfilePage = loginPage.loginClick();

        Assert.assertEquals(newProfilePage.getProfileName(getDriver()),"dicruz");
    }

    @Test
    public void failedLogin(){
        LandingPage landingPageFailed = new LandingPage(getDriver());
        LoginPage loginPageFailed = landingPageFailed.clickOnLogin();
        loginPageFailed.enterUsernameAndPassword("failed")
                .loginClickFailed();

        Assert.assertEquals(loginPageFailed.getBadConfirmation(getDriver())," There was a problem");
    }
}
