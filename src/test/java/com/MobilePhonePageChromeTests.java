package com;

import attd.pages.catalog.electronics.mobilephone.MobilePhoneAnalysisPage;
import attd.pages.catalog.electronics.mobilephone.MobilePhonePage;
import attd.selenium.WebDriverFactory;
import com.base.BaseChromeTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MobilePhonePageChromeTests extends BaseChromeTest {

    @DataProvider
    public Object[][] filterByDateByOs(){
        return new Object[][]{
                {new String[]{"Apple iOS"}, new String[]{"2017"}},
        };
    }


    @Test(dataProvider = "filterByDateByOs")
    public void filterByDateByOsTest(String[] os, String[] date) {
        MobilePhonePage mobilePhonePage = new MobilePhonePage(chrome).open().filterByDateCheckBox(date).filterByOS(os);
        mobilePhonePage.setListStringProductLinks();
        System.out.println(mobilePhonePage.getListStringProductLinks());
        for(int i=0; i<mobilePhonePage.getListStringProductLinks().size(); i++){
            MobilePhoneAnalysisPage mobilePhoneAnalysisPage =
                    new MobilePhoneAnalysisPage(WebDriverFactory.
                            configureChrome()).openPage(mobilePhonePage.getListStringProductLinks().get(i));
            Assert.assertEquals(mobilePhoneAnalysisPage.getOs(), os[0]);
            Assert.assertEquals(mobilePhoneAnalysisPage.getDate().toString(), date[0]);
            mobilePhoneAnalysisPage.closePage();
        }
    }





}
