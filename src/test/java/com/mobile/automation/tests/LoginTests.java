package com.mobile.automation.tests;

import com.mobile.automation.utils.BaseTest;
import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Epic("Login")
@Feature("Valid and invalid Logins")
public class LoginTests extends BaseTest {

    @Tag("Smoke")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("User tries to login as s Guest")
    @Description("User tries to login as s Guest")
    public void validLoginTestAsAGuest(){

        languagePreference.
                GivenISelectEnglishLanguage("QA").
                AndIVerifyGuestButtonIsEnabled().
                WhenISelectGuestLogin().
                ThenIVerifyHomeScreenTitle("dubai");

    }

    @Tag("Sanity")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("User tries to login with invalid creds")
    @Description("User tries to login with invalid creds")
    public void invalidLogin(){

        languagePreference.
                GivenISelectEnglishLanguage("QA").
                AndIVerifyGuestButtonIsEnabled().
                WhenIEnterCredentials("invalidUser", "invalidPwd").
                ThenIVerifyAlertError();

    }


}
