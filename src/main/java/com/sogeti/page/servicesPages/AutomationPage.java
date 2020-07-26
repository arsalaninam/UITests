package com.sogeti.page.servicesPages;

import com.github.javafaker.Faker;
import com.sogeti.base.TestBase;
import com.sogeti.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPage extends TestBase {

    public AutomationPage() {
        PageFactory.initElements(driver, this);
    }

    /**********************************************************
     * Defining Page Factory : Object Repository of Login Page
     **********************************************************/

    @FindBy(xpath = "//div[contains(text(),' / Services / Automation')]")
    private WebElement automationPageHeading;

    @FindBy(id = "4ff2ed4d-4861-4914-86eb-87dfa65876d8")
    private WebElement firstNameTextBox;

    @FindBy(id = "11ce8b49-5298-491a-aebe-d0900d6f49a7")
    private WebElement lastNameTextBox;

    @FindBy(id = "056d8435-4d06-44f3-896a-d7b0bf4d37b2")
    private WebElement emailTextBox;

    @FindBy(id = "755aa064-7be2-432b-b8a2-805b5f4f9384")
    private WebElement phoneTextBox;

    @FindBy(id = "88459d00-b812-459a-99e4-5dc6eff2aa19")
    private WebElement messageTextBox;

    @FindBy(name = "__field_123935")
    private WebElement iAgreeCheckbox;

    @FindBy(id = "06838eea-8980-4305-83d0-42236fb4d528")
    private WebElement submitButton;

    @FindBy(xpath = "//p[contains(text(),'Thank you for contacting us.')]")
    private WebElement formStatusSuccessMessageText;

    /***********************************
     * Methods : Actions of Login Page
     ***********************************/

    public String getPageTitle() {
        TestUtil.waitForVisibilityOfElement(driver, automationPageHeading);
        return driver.getTitle();
    }

    public void scrollToContactUsForm() {
        TestUtil.hoverElement(driver, submitButton);
    }

    public void fillContactUsFormWithValidRandomData() {
        scrollToContactUsForm();
        Faker faker = new Faker();
        firstNameTextBox.sendKeys(faker.name().firstName());
        lastNameTextBox.sendKeys(faker.name().lastName());
        emailTextBox.sendKeys(faker.internet().safeEmailAddress());
        phoneTextBox.sendKeys(faker.phoneNumber().cellPhone());
        messageTextBox.sendKeys(faker.internet().domainName());
    }

    public void clickIAgreeCheckBox() {
        TestUtil.waitForVisibilityOfElement(driver, iAgreeCheckbox);
        iAgreeCheckbox.click();
    }

    public void clickSubmitButton() {
        TestUtil.waitForElementToBeClickable(driver, submitButton);
        submitButton.click();
    }

    public String getFormStatusSuccessMessage() {
        TestUtil.waitForVisibilityOfElement(driver, formStatusSuccessMessageText);
        return formStatusSuccessMessageText.getText();
    }
}
