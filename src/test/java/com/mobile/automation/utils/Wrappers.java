package com.mobile.automation.utils;

import io.appium.java_client.*;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;


public class Wrappers extends BaseDriver {

    public static void waitUntilVisible(MobileElement element, int timeOutInSec) {
        int waitTime = getImplicitWaitTimeInSec(timeOutInSec);
        try {
            FluentWait<AppiumDriver<MobileElement>> fWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(waitTime))
                    .pollingEvery(Duration.ofMillis(50))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            fWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            Assert.fail("Expected element not displayed in " + waitTime + " seconds");
        }
    }


    public static void waitForSomeTime(int timeOutInSec) {
        try {
            Thread.sleep(timeOutInSec * 1000);
        } catch (InterruptedException ignored) {
        }
    }

    public static void waitUntilClickable(MobileElement element, int timeOutInSec) {
        int waitTime = getImplicitWaitTimeInSec(timeOutInSec);
        try {
            FluentWait<AppiumDriver<MobileElement>> fWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(waitTime))
                    .pollingEvery(Duration.ofMillis(50))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            fWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            Assert.fail("Expected element not clickable in " + waitTime + " seconds");
        }
    }


    private static int getImplicitWaitTimeInSec(int timeOutInSec) {
        int waitTime;
        if (timeOutInSec == 0) {
            waitTime = Integer.parseInt(System.getProperty("driverTimeout"));
        } else {
            waitTime = timeOutInSec;
        }
        return waitTime;
    }

    public static boolean ifElementPresent(MobileElement element) {
        try {
            element.isEnabled();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void tap(MobileElement element){
       new TouchAction<>(driver).tap(new TapOptions().withElement(ElementOption.element(element))).perform();
    }

    public static void longPress(MobileElement element, int duration){
        new TouchAction<>(driver).longPress(LongPressOptions.longPressOptions().
                withElement(ElementOption.element(element)).withDuration(Duration.ofSeconds((long) duration))).
                release().perform();
    }

    public static void swipe(MobileElement element1 , int duration , MobileElement element2){
        new TouchAction<>(driver).longPress(LongPressOptions.longPressOptions().
                withElement(ElementOption.element(element1)).withDuration(Duration.ofSeconds((long) duration))).
                moveTo(ElementOption.element(element2)).release().perform();
    }

    public static void scrollIntoView(String text){
        driver.findElement(MobileBy.
                AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));

    }

    public static void scrollAndClick(String visibleText) {
        driver.findElement(MobileBy.
                AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
                        "scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))")).click();

}

    public static void verifyAndClickElement(MobileElement mobileElement){
        waitUntilVisible(mobileElement,5);
        waitUntilClickable(mobileElement,5);
        mobileElement.click();
    }
}
