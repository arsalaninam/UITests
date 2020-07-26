package com.sogeti.testcase;

import com.sogeti.base.TestBase;
import com.sogeti.page.servicesPages.AutomationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.sogeti.constant.LogConstant.TEST_CONTACT_US_FORM_DISPLAYS_MESSAGE;

public class AutomationPageTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(AutomationPage.class);

    /***************************************************************************************************
     * Test Case 2 : Test to verify Contact Us Form On Automation Link display valid message.
     *
     * - Navigate to the URL https://www.sogeti.com/
     * - Hover over Services Link and then Click Automation link.
     * - On Automation Page, scroll down to the Contact us Form.
     * - Fill the First Name, Last Name, Email, Phone and Message fields with Random Generated Data.
     * - Check the I agree checkbox.
     * - Then Click SUBMIT button.
     * - After clicking SUBMIT button the form is submitted and Thank you message is displayed.
     * - Assert the Thank you message.
     **************************************************************************************************/

    @Test()
    public void testContactUsFormDisplaysValidMessage() {

        log.info(TEST_CONTACT_US_FORM_DISPLAYS_MESSAGE);

        AutomationPage automationPage = homePage.navigateToAutomationPage();
        Assert.assertEquals(automationPage.getPageTitle(),"Automation");

        automationPage.scrollToContactUsForm();
        automationPage.fillContactUsFormWithValidRandomData();
        automationPage.clickIAgreeCheckBox();
        automationPage.clickSubmitButton();

        String actualFormStatusMessage = automationPage.getFormStatusSuccessMessage();
        Assert.assertEquals(actualFormStatusMessage, "Thank you for contacting us.");
    }

}
