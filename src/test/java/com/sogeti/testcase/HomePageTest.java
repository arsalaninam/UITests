package com.sogeti.testcase;

import com.sogeti.base.TestBase;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static com.sogeti.constant.LogConstant.TEST_COUNTRY_SPECIFIC_SOGETI_LINKS_ARE_WORKING;
import static com.sogeti.constant.LogConstant.TEST_SERVICE_AND_AUTOMATION_LINKS_ARE_SELECTED;

public class HomePageTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(HomePageTest.class);

    /********************************************************************************************
     * Test Case 1 : Test to verify that the Services and Automation are selected.
     *
     * - Navigate to the URL https://www.sogeti.com/
     * - Hover over Services Link (see Image below) and then Click Automation link.
     * - Verify that Automation Screen is displayed, and “Automation” text is visible in Page.
     * - Hover again over Services Link. Verify that the Services and Automation are selected
     *******************************************************************************************/

    @Test()
    public void testServicesAndAutomationLinksAreVisible() {

        log.info(TEST_SERVICE_AND_AUTOMATION_LINKS_ARE_SELECTED);

        homePage.hoverServicesLink();
        homePage.hoverAutomationLinkUnderServicesLink();

        Assert.assertTrue(homePage.servicesLinkTabIsVisibleOrNot());
        Assert.assertTrue(homePage.serviceLinkSubCategoryAutomationLinkIsVisibleOrNot());
    }


    /********************************************************************************************
     * Test Case 3 : Test to verify all the Country specific Sogeti links are working.
     *
     * - Navigate to the URL https://www.sogeti.com/
     * - Click the Worldwide Dropdown link in Page Header.
     * - A Country dropdown list is displayed. These are the Country specific Sogeti links.
     * - Assert that all the Country specific Sogeti links are working.
     *******************************************************************************************/
    @Test
    public void verifyCountrySpecificLinksAreWorking(){

        log.info(TEST_COUNTRY_SPECIFIC_SOGETI_LINKS_ARE_WORKING);

        String url;
        HttpURLConnection huc;
        int respCode;

        homePage.clickWorldwideDropdown();
        List<WebElement> links = homePage.getCountryListWorldwide();

        for (WebElement link : links) {
            url = link.getAttribute("href");

            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.connect();
                respCode = huc.getResponseCode();
                Assert.assertEquals(respCode, 200);

                if (respCode==200) {
                    log.info(url + " is a valid link");
                } else {
                    log.info(url + " is not valid link");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
