package com.mobile.automation.screens.home;

import com.mobile.automation.screens.LoginScreen;
import com.mobile.automation.screens.dashboard.DashboardScreen;
import com.mobile.automation.screens.travel.TravelScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.mobile.automation.utils.Wrappers.*;

public class HomeScreen extends LoginScreen {

    @AndroidFindBy(id = "ae.smartdubai.dubainow.enterprise:id/dubai")
    private MobileElement title;

    @AndroidFindBy(id = "ae.smartdubai.dubainow.enterprise:id/navigation_dashboard")
    private MobileElement dashboard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Travel']")
    private MobileElement travel;


    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step
    public HomeScreen ThenIVerifyHomeScreenTitle(String text) {
        waitUntilVisible(title, 10);
        Assert.assertTrue("Home Screen Is not displayed",
                title.getText().contains(text));
        return this;
    }

    @Step
    public DashboardScreen WhenIClickDashboardIcon() {
        Assert.assertTrue("Dashboard is not enabled ",dashboard.isEnabled());
        waitUntilClickable(dashboard, 10);
        dashboard.click();
        return new DashboardScreen(driver);
    }

    @Step
    public TravelScreen AndIVerifyNClickTravelIcon() {
        verifyAndClickElement(travel);
        return new TravelScreen(driver);
    }

}
