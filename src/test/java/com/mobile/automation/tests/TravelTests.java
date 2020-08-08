package com.mobile.automation.tests;

import com.mobile.automation.utils.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Epic("Travel")
@Feature("Flight info and search")
public class TravelTests extends BaseTest {

    @Tag("Smoke")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify Travel App in Home Screen")
    @Description("Verify Travel App in Home Screen")
    public void verifyTravelApp(){

        languagePreference.
                GivenISelectEnglishLanguage("QA").
                AndILoggedInAsAGuest().
                ThenIVerifyHomeScreenTitle("dubai").
                AndIVerifyNClickTravelIcon().
                ThenIClickFlightInfoIcon();

    }

    @Tag("Smoke")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search EK Flight for the current date")
    @Description("Search EK 512 flight for current date")
    public void searchEKFlightForCurrentDate(){

        languagePreference.
                GivenISelectEnglishLanguage("QA").
                AndILoggedInAsAGuest().
                ThenIVerifyHomeScreenTitle("dubai").
                AndIVerifyNClickTravelIcon().
                ThenIClickFlightInfoIcon();

    }




}
