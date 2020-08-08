package com.mobile.automation.screens.dashboard;

import com.mobile.automation.screens.home.HomeScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.mobile.automation.utils.Wrappers.*;

public class DashboardScreen extends HomeScreen {


    @AndroidFindBy(xpath = "android.widget.TextView[@text='Prayer Times']")
    private MobileElement prayerTimes;

    @AndroidFindBy(id = "ae.smartdubai.dubainow.enterprise:id/txtToolbarTitle")
    private MobileElement dashboardTitle;

    public DashboardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step
    public DashboardScreen ThenIVerifyDashboardTitle(String title) {
        waitUntilVisible(dashboardTitle, 10);
        Assert.assertEquals(title , dashboardTitle.getText());
        return this;
    }

    @Step
    public DashboardScreen AndIClickTheNextPrayerTime(){
        scrollAndClick("Prayer Times");
        return this;
    }
}
