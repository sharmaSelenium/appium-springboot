package com.mobile.automation.screens;

import com.mobile.automation.screens.home.HomeScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.mobile.automation.utils.Wrappers.waitUntilClickable;
import static com.mobile.automation.utils.Wrappers.waitUntilVisible;

public class LoginScreen extends LanguagePreference{

    @AndroidFindBy(id = "ae.smartdubai.dubainow.enterprise:id/btn_guest_sign_in")
    private MobileElement guest;

    @AndroidFindBy(id = "ae.smartdubai.dubainow.enterprise:id/edit_email")
    private MobileElement email;

    @AndroidFindBy(id = "ae.smartdubai.dubainow.enterprise:id/edit_password")
    private MobileElement password;

    @AndroidFindBy(id = "ae.smartdubai.dubainow.enterprise:id/btn_login")
    private MobileElement login;

    @AndroidFindBy(id = "android:id/alertTitle")
    private MobileElement alertError;

    @AndroidFindBy(id = "android:id/message")
    private MobileElement alertErrorMessage;


    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step
    public LoginScreen AndIVerifyGuestButtonIsEnabled() {
        waitUntilVisible(guest, 5);
        Assert.assertTrue("Login Screen elements are not enabled",
                guest.isEnabled());
        return this;
    }

    @Step
    public HomeScreen WhenISelectGuestLogin(){
        guest.click();
        return new HomeScreen(driver);
    }

    @Step
    public HomeScreen WhenIEnterCredentials(String username , String pwd){
        waitUntilClickable(email,10);
        email.sendKeys(username);
        password.sendKeys(pwd);
        waitUntilClickable(login,5);
        login.click();
        return new HomeScreen(driver);
    }

    @Step
    public HomeScreen ThenIVerifyAlertError(){
        waitUntilVisible(alertError,10);
        System.out.println(alertErrorMessage.getText());
        Allure.addAttachment(" Error Message " , alertErrorMessage.getText() );
        return new HomeScreen(driver);
    }

    @Step
    public HomeScreen AndILoggedInAsAGuest(){
        AndIVerifyGuestButtonIsEnabled();
        AndIVerifyGuestButtonIsEnabled();
        WhenISelectGuestLogin();
        return new HomeScreen(driver);
    }
}
