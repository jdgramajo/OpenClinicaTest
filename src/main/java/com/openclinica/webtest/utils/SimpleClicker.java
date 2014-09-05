/**
 * 
 */
package com.openclinica.webtest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.openclinica.webtest.interfases.Clicker;
import com.openclnica.webtest.enums.Clickables;

/**
 * @author Juan Diego Gramajo
 * Simply clicks on objects accessible by selenium.
 */
public class SimpleClicker implements Clicker {

	private static SimpleClicker sc;
	
	private SimpleClicker() {
		// Singleton
	}
	
	public static SimpleClicker getSimpleClicker() {
		if(sc == null)
			sc = new SimpleClicker();
		return sc;
	}
	
	public void click(WebDriver driver, Clickables clickableType, String clickOn) {
		switch(clickableType) {
		case ID:
			driver.findElement(By.id(clickOn)).click();
			break;
		case CLASS_NAME:
			driver.findElement(By.className(clickOn)).click();
			break;
		case TAG_NAME:
			driver.findElement(By.tagName(clickOn)).click();
			break;
		case NAME:
			driver.findElement(By.name(clickOn)).click();
			break;
		case LINK_TEXT:
			driver.findElement(By.linkText(clickOn)).click();
			break;
		case PARTIAL_LINK_TEXT:
			driver.findElement(By.partialLinkText(clickOn)).click();
			break;
		case CSS:
			driver.findElement(By.cssSelector(clickOn)).click();
			break;
		case XPATH:
			driver.findElement(By.xpath(clickOn)).click();
			break;
		default:
			System.out.println("No matching clickable found for: " + clickOn);
		}
	}

}
