package com.mobile.automation.utils;


import com.mobile.automation.config.Config;
import com.mobile.automation.screens.LanguagePreference;
import com.mobile.automation.screens.LoginScreen;
import com.mobile.automation.screens.dashboard.DashboardScreen;
import com.mobile.automation.screens.home.HomeScreen;
import com.mobile.automation.screens.travel.FlightInfoScreen;
import com.mobile.automation.screens.travel.TravelScreen;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ContextConfiguration(classes = Config.class)
@ExtendWith(SpringExtension.class)
@TestPropertySource({"classpath:config.properties"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseTest extends BaseDriver {

    public LanguagePreference languagePreference;
    public LoginScreen loginScreen;
    public HomeScreen homeScreen;
    public DashboardScreen dashboardScreen;
    public TravelScreen travelScreen;
    public FlightInfoScreen flightInfoScreen;

        @BeforeAll
        public void launchDriver(){
            startServer();
            setAppPath();
        }

        @BeforeEach
        public void launchApp(){
            setDriverType();
            setDriverTimeOut();
            initializeScreenElements();
        }

        private void initializeScreenElements(){
            languagePreference = new LanguagePreference(driver);
            loginScreen = new LoginScreen(driver);
            homeScreen = new HomeScreen(driver);
            dashboardScreen = new DashboardScreen(driver);
            travelScreen = new TravelScreen(driver);
            flightInfoScreen = new FlightInfoScreen(driver);

        }

        @After
        public void quitDriver(){
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        }

        @AfterAll
        public void stopServer(){
            if (server != null) {
                server.stop();
            }
        }



}
