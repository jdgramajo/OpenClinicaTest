package com.openclinica.webtest.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openclinica.webtest.interfases.SessionManager;
import com.openclinica.webtest.utils.SessionManagerOpenClinica;
import com.openclinica.webtest.utils.SimpleClicker;
import com.openclnica.webtest.enums.Clickables;

public class CheckPatientTest {

    private SessionManager sm;
    private SimpleClicker sc;
    private WebDriver driver;
    
    @Test
    public void main() throws InterruptedException {
        sm = SessionManagerOpenClinica.getSessionManager(driver, "manager", "password");
        sm.doLogin();
        sc = SimpleClicker.getSimpleClicker();
        sc.click(driver, Clickables.LINK_TEXT, "Subject Matrix");
        Thread.sleep(2000L);
        driver.findElement(By.name("findSubjects_f_studySubject.label")).sendKeys("TS10_101_10");
        sc.click(driver, Clickables.CLASS_NAME, "navSearchButton");
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
