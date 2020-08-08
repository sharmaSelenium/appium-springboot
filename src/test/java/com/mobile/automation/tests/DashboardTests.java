package com.mobile.automation.tests;

import com.mobile.automation.utils.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@Epic("Dashboard")
@Feature("Guest Features ")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class DashboardTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Prayer Times")
    @Description("User tries to find prayer times from dashboard as guest user")
    public void verifyPrayerTimesInDashboardAsGuest(){

        languagePreference.
                GivenISelectEnglishLanguage("QA").
                AndIVerifyGuestButtonIsEnabled().
                WhenISelectGuestLogin().
                ThenIVerifyHomeScreenTitle("dubai").
                WhenIClickDashboardIcon().
                ThenIVerifyDashboardTitle("Dashboard").
                AndIClickTheNextPrayerTime();

    }


}
