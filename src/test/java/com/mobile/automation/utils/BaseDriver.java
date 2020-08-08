package com.mobile.automation.utils;

import com.mobile.automation.commons.Configurations;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static com.mobile.automation.utils.Constants.DUBAI_NOW_QA_APK;
import static com.mobile.automation.utils.Constants.IOS_APP_PATH;


@Getter
@Setter
@RequiredArgsConstructor
public class BaseDriver {

    @Autowired
    Configurations config;

    public static AppiumDriver<MobileElement> driver;

    public static DesiredCapabilities capabilities = null;

    public static URL url = null;

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static AppiumDriverLocalService server ;

    public void setDriverType() {
        if(config.getAppType.get().equalsIgnoreCase("androidnative")){
            capabilities = new DesiredCapabilities();
            capabilities.setCapability("autoGrantPermissions", "true");
            driver = new AndroidDriver<>(url, getAndroidNativeCapabilities(capabilities));
        }
        else if(config.getAppType.get().equalsIgnoreCase("iosnative")){
            capabilities.setCapability("autoGrantPermissions", "true");
            // ios driver
        }

    }


    public DesiredCapabilities getAndroidNativeCapabilities(DesiredCapabilities capabilities){
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getAndroidVersion.get());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, Paths.get(DUBAI_NOW_QA_APK).toAbsolutePath().toString());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getAndroidDevice.get());
        return capabilities;
    }

    public DesiredCapabilities getIosNativeCapabilities(DesiredCapabilities capabilities){
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getIosVersion.get());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        capabilities.setCapability(MobileCapabilityType.APP, Paths.get(IOS_APP_PATH));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getIosDevice.get());
        return capabilities;
    }


    public void setAppPath()  {
        if(config.getExecutionMode.get().equalsIgnoreCase("local")){
            try {
                url = new URL(config.getURL.get() + "/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else if(config.getExecutionMode.get().equalsIgnoreCase("remote")){
            // future implementation
        }
    }

    public void setDriverTimeOut() {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getDriverTimeOut.get()), TimeUnit.SECONDS);
    }

    public AppiumDriverLocalService startServer(){

        if(!checkIfServerIsRunning(config.getPort.get())){
            server = AppiumDriverLocalService.buildDefaultService();
            server.start();
        }
        return server;
    }


    public static boolean checkIfServerIsRunning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }


}
