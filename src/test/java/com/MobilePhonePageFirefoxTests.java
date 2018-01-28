package com;

import attd.pages.catalog.electronics.mobilephone.MobilePhoneAnalysisPage;
import attd.pages.catalog.electronics.mobilephone.MobilePhonePage;
import attd.selenium.WebDriverFactory;
import com.base.BaseFirefoxTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class MobilePhonePageFirefoxTests extends BaseFirefoxTest {

    @Parameters({"tehnology", "platform"})
    @Test
    public void navigateTo3(String tehn, String pl) {
        MobilePhonePage mobilePhonePage = new MobilePhonePage(firefox).open().filterByScreenTechnology(tehn).filterByPlatform(pl);
        mobilePhonePage.setListStringProductLinks();
        System.out.println(mobilePhonePage.getListStringProductLinks());
        for (int i = 0; i < mobilePhonePage.getListStringProductLinks().size(); i++) {
            MobilePhoneAnalysisPage mobilePhoneAnalysisPage = new MobilePhoneAnalysisPage(WebDriverFactory.configureFirefox()).openPage(mobilePhonePage.getListStringProductLinks().get(i));
            Assert.assertEquals(mobilePhoneAnalysisPage.getScreenTechnology(), tehn);
            Assert.assertEquals(mobilePhoneAnalysisPage.getPlatform(), pl);
            mobilePhoneAnalysisPage.closePage();
        }

    }
}