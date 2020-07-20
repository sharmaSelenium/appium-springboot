package com.mobile.automation.tests;

import com.mobile.automation.screens.HomeScreen;
import com.mobile.automation.utils.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Epic("Test epic")
@Feature("Test Feature")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class TestDemoApp extends BaseTest {
    private HomeScreen homeScreen ;

    @Test
    public void testPreferencesOptions(){
        System.out.println("test started");
        homeScreen = new HomeScreen(driver);
        homeScreen.selectPreference();
        homeScreen.preference().selectPreferenceDependencies();
        homeScreen.preference().selectWifiCheckBox();
        homeScreen.preference().selectWifiSettings();

    }

    @Test
    public void testViewOptions(){
        System.out.println("test started");
        homeScreen = new HomeScreen(driver);
        homeScreen.selectViews();
        homeScreen.view().selectExpandableLists();
        homeScreen.view().selectCustomerAdaptor();
        homeScreen.view().longPressPeopleName();

    }

    @Test
    public void testSwipe(){
        System.out.println("test started");
        homeScreen = new HomeScreen(driver);
        homeScreen.selectViews();
        homeScreen.view().scrollView("Spinner");

    }
}
