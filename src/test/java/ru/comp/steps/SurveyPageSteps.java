package ru.comp.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.comp.pages.SurveyPage;

import java.util.ArrayList;

public class SurveyPageSteps {
    /**
     * SurveyPage object
     */
    private SurveyPage surveyPage;

    /**
     * Constructor
     * @param driver
     */
    public SurveyPageSteps(WebDriver driver){
        surveyPage = PageFactory.initElements(driver, SurveyPage.class);
    }

    /**
     * 5. Fill in the Q&A section at the left part of page (like random generated answers)
     * @param values Question choices
     */
    @Step("Fill in the Q&A section at the left part of page")
    public void fillInTheQAndASectionStep(ArrayList<String> values){
        for(int i = 0; i < surveyPage.getQuestionElements().size(); i++){
            surveyPage.getQuestionElements().get(i).findElement(By.xpath("//button[contains(text(),'" + values.get(i) + "')]")).click();
        }
        surveyPage.getSubmitSurveyButton().click();
    }

    /**
     * 6. Click on "Resend email"
     */
    @Step("Resend email click")
    public void clickOnResendEmail(){
        surveyPage.getResendEmailButton().click();
    }
}
