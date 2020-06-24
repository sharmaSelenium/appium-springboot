package com.qa.mobileautomation.practise;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import com.qa.mobileautomation.utills.BaseTest;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@Epic("Test epic")
@Feature("Test Feature")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Demo {

    @Test
    public void testApp() throws MalformedURLException {
        System.out.println("test");

        // set mobile capability
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME , "Google Pixel");
        desiredCapabilities.setCapability(MobileCapabilityType.APP , "C:\\Users\\nitis\\Desktop\\projects\\appium-springboot\\src\\apidemos.apk");

        // connection to server
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);


    }

}
