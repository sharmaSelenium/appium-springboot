package com.qa.mobileautomation.utills;

import com.qa.mobileautomation.data.Endpoints;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class BaseDriver {

    @Autowired
    Endpoints config;

    public static AndroidDriver<AndroidElement> driver;

    public static DesiredCapabilities capabilities = null;

    public static URL url = null;

    public static AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }
}
