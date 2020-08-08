package com.mobile.automation.screens;

import com.mobile.automation.utils.BaseDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import static com.mobile.automation.utils.Wrappers.waitUntilClickable;
import static com.mobile.automation.utils.Wrappers.waitUntilVisible;

public class LanguagePreference extends BaseDriver {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='English']")
    private MobileElement selectEnglish;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
    private MobileElement skip;

    public LanguagePreference(AppiumDriver<MobileElement> driver){
        BaseDriver.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step
    public LoginScreen GivenISelectEnglishLanguage(String environment){
        waitUntilVisible(selectEnglish ,10);
        selectEnglish.click();
        MobileElement envElement = driver.findElementByXPath("//android.widget.TextView[@text='" + environment + "']");
        waitUntilClickable(envElement,10);
        envElement.click();
        waitUntilClickable(skip,10);
        skip.click();
        return new LoginScreen(driver);
    }


}
