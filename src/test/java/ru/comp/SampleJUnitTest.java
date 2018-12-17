package ru.comp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.support.PageFactory;

import ru.comp.pages.HomePage;
import ru.comp.steps.HomePageSteps;

public class SampleJUnitTest extends JUnitTestBase {

    private HomePage homepage;

    @Before
    public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

    @Test
    public void testMoveToSurveyPage() {
        HomePageSteps homePageSteps = new HomePageSteps(driver);
        homePageSteps.goToQAndASectionStep(email);
        Assert.assertEquals(driver.getCurrentUrl(), surveyUrl);
    }
}
