package com.sogeti.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.sogeti.constant.TestConstant.PAGE_LOAD_TIMEOUT;

public class TestUtil {

    /************************************************************************************************
     * Explicit Wait for visibility of an element
     *
     * @param driver - WebDriver instance
     * @param element - Element to be Displayed
     ************************************************************************************************/

    public static void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }


    /************************************************************************************************
     * Hover and element or drag to a particular position on the web
     *
     * @param driver - WebDriver instance
     * @param element - Element to be hover
     *************************************************************************************************/

    public static void hoverElement(WebDriver driver, WebElement element){
        waitForVisibilityOfElement(driver, element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    /************************************************************************************************
     * Explicit Wait for element to be clickable
     *
     * @param driver - WebDriver instance
     * @param element - Element to be Clickable
     ************************************************************************************************/

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /************************************************************************************************
     * Explicit Wait for invisibility of an element
     *
     * @param driver - WebDriver instance
     * @param element - Element not to be Displayed
     ************************************************************************************************/

    public static void waitForInvisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }


    /************************************************************************************************
     * Explicit Wait for visibility of an element and enters text to the text box
     *
     * @param driver - WebDriver instance
     * @param element - Element to be Displayed
     * @param keys - Value to send in text box
     ************************************************************************************************/

    public static void sendKeysToTextBox(WebDriver driver, WebElement element, String keys) {
        waitForElementToBeClickable(driver, element);
        element.sendKeys(keys);
    }


}
