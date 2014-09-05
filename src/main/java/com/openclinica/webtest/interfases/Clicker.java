package com.openclinica.webtest.interfases;

import org.openqa.selenium.WebDriver;

import com.openclnica.webtest.enums.Clickables;

/*
 * Specifies the contract for object to click on a webpage.
 */
public interface Clicker {
	public void click(WebDriver driver, Clickables clickableType, String clickOn);
}
