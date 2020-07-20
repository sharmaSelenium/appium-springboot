package com.mobile.automation.screens;

import com.mobile.automation.screens.preference.Preference;
import com.mobile.automation.screens.view.Views;
import com.mobile.automation.utils.BaseDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static com.mobile.automation.utils.Wrappers.*;

public class HomeScreen extends BaseDriver {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App']")
    private MobileElement app;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
    private MobileElement preference;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
    private MobileElement views;

    public Preference preference(){return new Preference(driver);}
    public Views view(){return new Views(driver);}

    public HomeScreen(AppiumDriver<MobileElement> driver){
        BaseDriver.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectViews(){
        waitUntilClickable(views ,10);
        views.click();
    }

    public void selectPreference(){
        waitUntilClickable(preference ,10);
        preference.click();
    }
}
