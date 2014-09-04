package com.openclinica.webtest.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openclinica.webtest.interfases.SessionManager;
import com.openclinica.webtest.utils.SessionManagerOpenClinica;

public class SessionManagementTest {

    SessionManager sm;
    WebDriver driver;
    
    @Test
    public void main() throws InterruptedException {
        sm = SessionManagerOpenClinica.getSessionManager(driver, "manager", "password");
        sm.doLogin();
        Thread.sleep(3000L);
        sm.doLogout();
        Thread.sleep(2000L);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.eclinicalhosting.com/OpenClinica/pages/login/login");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


}
