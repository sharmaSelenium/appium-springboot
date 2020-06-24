package com.qa.mobileautomation.utills;

import com.qa.mobileautomation.config.Config;
import com.qa.mobileautomation.data.Endpoints;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

@ContextConfiguration(classes = Config.class)
//@ExtendWith(SpringExtension.class)
//@TestPropertySource({"classpath:endpoints.properties"})

public class BaseTest  {

    @Autowired
    Endpoints config ;

    public static AndroidDriver<AndroidElement> driver;

    public static DesiredCapabilities capabilities = null;

    public static URL url = null;

    public static AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    @Before
    public void launchDriver(){
        System.out.println(" In Base Test ");
        setAppPath();
        setDriverType();
    }

    @After
    public void quitDriver(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    private void setDriverType() {
        if(config.getAppType.get().equalsIgnoreCase("androidnative")){
        driver = new AndroidDriver<>(url, getAndroidNativeCapabilities(capabilities));
        }
        else if(config.getAppType.get().equalsIgnoreCase("iosnative")){
            // ios driver
        }

    }


    private DesiredCapabilities getAndroidNativeCapabilities(DesiredCapabilities capabilities){
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getAndroidVersion.get());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, Paths.get(Constants.ANDROID_APP_PATH));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getAndroidDevice.get());
        return capabilities;
    }

    private DesiredCapabilities getIosNativeCapabilities(DesiredCapabilities capabilities){
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getIosVersion.get());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        capabilities.setCapability(MobileCapabilityType.APP, Paths.get(Constants.IOS_APP_PATH));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getIosDevice.get());
        return capabilities;
    }


    private void setAppPath()  {
        System.out.println("execution mode" + config.getExecutionMode.get());
        if(config.getExecutionMode.get().equalsIgnoreCase("local")){
            try {
                url = new URL(config.getURL + "/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else if(config.getExecutionMode.get().equalsIgnoreCase("remote")){
            // future implementation
        }
    }
}
