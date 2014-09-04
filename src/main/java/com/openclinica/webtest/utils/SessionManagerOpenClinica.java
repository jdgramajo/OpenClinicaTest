package com.openclinica.webtest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.openclinica.webtest.interfases.SessionManager;

/*
 * SessionManager implementation for OpenClinica.
 * It is meant to be a Singleton during the test.
 */
public class SessionManagerOpenClinica implements SessionManager {

    private String user;
    private String password;
    private WebDriver driver;
    private static SessionManager sm;
    
    /*
     * Private constructor.
     */
    private SessionManagerOpenClinica(WebDriver driver, String user,
            String password) {
        this.driver = driver;
        this.user = user;
        this.password = password;
    }
    
    public static SessionManager getSessionManager(WebDriver driver, String user,
            String password) {
        if(sm == null)
            return new SessionManagerOpenClinica(driver, user, password);
        else
            return sm;
    }

    public void doLogin() {
        driver.findElement(By.id("username")).sendKeys(this.user);
        driver.findElement(By.id("j_password")).sendKeys(this.password);
        driver.findElement(By.name("submit")).click();
    }

    public void doLogout() {
        driver.findElement(By.partialLinkText("Log Out")).click();
    }

}

