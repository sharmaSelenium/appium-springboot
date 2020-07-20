package com.mobile.automation.screens.view;

import com.mobile.automation.screens.HomeScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.mobile.automation.utils.Wrappers.*;

public class Views extends HomeScreen {
    @AndroidFindBy(uiAutomator = "text(\"Expandable Lists\")")
    private MobileElement expandableLists;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text ,'Custom Adapter')]")
    private MobileElement customerAdaptor;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
    private MobileElement peopleNames;


    public Views(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void selectExpandableLists(){
        waitUntilVisible(expandableLists ,10);
        expandableLists.click();
    }

    public void selectCustomerAdaptor(){
        waitUntilVisible(customerAdaptor ,10);
        customerAdaptor.click();
    }

    public void longPressPeopleName(){
        waitUntilVisible(peopleNames,10);
        longPress(peopleNames,2);
    }

    public void scrollView(String text){
       scrollIntoView(text);
    }
}
