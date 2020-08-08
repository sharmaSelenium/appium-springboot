package com.mobile.automation.screens.travel;

import com.mobile.automation.screens.home.HomeScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.mobile.automation.utils.Wrappers.verifyAndClickElement;

public class TravelScreen extends HomeScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Flight Info']")
    private MobileElement flightInfo;

    public TravelScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public FlightInfoScreen ThenIClickFlightInfoIcon(){
        verifyAndClickElement(flightInfo);
        return new FlightInfoScreen(driver);
    }
}
