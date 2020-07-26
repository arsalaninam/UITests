package com.sogeti.page;

import com.sogeti.base.TestBase;
import com.sogeti.page.servicesPages.AutomationPage;
import com.sogeti.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends TestBase {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    /**********************************************************
     * Defining Page Factory : Object Repository of Login Page
     **********************************************************/

    @FindBy(xpath = "//li[@data-levelname='level2']")
    private WebElement servicesLinkTab;

    @FindBy(xpath = "//a[@href='https://www.sogeti.com/services/automation/']")
    private WebElement serviceLinkSubCategoryAutomationLink;

    @FindBy(xpath = "//div[contains(@class, 'sprite-header sprite-global-arrowdown')]")
    private WebElement worldwideDropdown;

    @FindBy(xpath = "//div[contains(@class, 'country-list')]//ul//li")
    private WebElement countryListWorldwide;

    /***********************************
     * Methods : Actions of Login Page
     ***********************************/

    public String getPageTitle() {
        TestUtil.waitForVisibilityOfElement(driver, servicesLinkTab);
        return driver.getTitle();
    }

    public void hoverServicesLink(){
        TestUtil.hoverElement(driver, servicesLinkTab);
    }

    public void hoverAutomationLinkUnderServicesLink(){
        TestUtil.hoverElement(driver, serviceLinkSubCategoryAutomationLink);
    }

    public boolean servicesLinkTabIsVisibleOrNot(){
        return servicesLinkTab.isDisplayed();
    }

    public boolean serviceLinkSubCategoryAutomationLinkIsVisibleOrNot(){
        return serviceLinkSubCategoryAutomationLink.isDisplayed();
    }

    public AutomationPage navigateToAutomationPage(){
        TestUtil.hoverElement(driver, servicesLinkTab);
        TestUtil.waitForVisibilityOfElement(driver, serviceLinkSubCategoryAutomationLink);
        serviceLinkSubCategoryAutomationLink.click();
        return new AutomationPage();
    }

    public void clickWorldwideDropdown(){
        TestUtil.waitForElementToBeClickable(driver, worldwideDropdown);
        worldwideDropdown.click();
    }

    public List<WebElement> getCountryListWorldwide(){
        TestUtil.waitForVisibilityOfElement(driver, countryListWorldwide);
        return driver.findElements(By.xpath("//div[contains(@class, 'country-list')]//ul//li//a"));
    }


}
