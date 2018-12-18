package ru.comp;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.support.PageFactory;
import ru.comp.pages.SurveyPage;
import ru.comp.steps.HomePageSteps;
import ru.comp.steps.SurveyPageSteps;

import java.util.ArrayList;

public class WrikeJUnitTest extends JUnitTestBase {

    private SurveyPage surveyPage;

    @Before
    public void initPageObjects() {
        surveyPage = PageFactory.initElements(driver, SurveyPage.class);
    }

    @Test
    @DisplayName("Move to survey page test")
    public void testMoveToSurveyPage() {
        HomePageSteps homePageSteps = new HomePageSteps(driver);

        homePageSteps.goToQAndASectionStep(email);
        //check with assertion that you are moved to the next page
        Assert.assertEquals(driver.getCurrentUrl(), surveyUrl);
    }

    @Test
    @DisplayName("Submit Q&A section test")
    public void testSubmitQAndASection(){
        SurveyPageSteps surveyPageSteps = new SurveyPageSteps(driver);

        //Fill in the Q&A section at the left part of page (like random generated answers)
        surveyPageSteps.fillInTheQAndASectionStep(new ArrayList<String>(){{
            add("Very interested");
            add("16–25");
            add("Yes");
        }});
        //check with assertion that your answers are submitted
        Assert.assertTrue(surveyPage.getSurveySuccessMessage().isDisplayed());
    }

    @Test
    @DisplayName("Resend email button test")
    public void testResendEmailButton(){
        SurveyPageSteps surveyPageSteps = new SurveyPageSteps(driver);

        //Click on "Resend email"
        surveyPageSteps.clickOnResendEmail();
        // + check it with assertion
        Assert.assertFalse(surveyPage.getResendEmailButton().isDisplayed());
    }

    /**
     *  7. Check that section "Follow us" at the site footer contains the "Twitter" button that leads to the correct url and has the correct icon.
     */
    @Test
    @DisplayName("Check that section \"Follow us\"")
    public void testTwitter(){
        Assert.assertTrue(surveyPage.getTwitterLink().isDisplayed());
    }
}
