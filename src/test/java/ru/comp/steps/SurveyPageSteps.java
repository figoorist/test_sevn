package ru.comp.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.comp.pages.SurveyPage;

import java.util.ArrayList;

public class SurveyPageSteps {
    /**
     * HomePage object
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
     * @param values
     */
    public void fillInTheQAndASectionStep(ArrayList<String> values){
        for(int i = 0; i < surveyPage.getQuestionElements().size(); i++){
            surveyPage.getQuestionElements().get(i).findElement(By.linkText(values.get(i))).click();
        }
        surveyPage.getSubmitSurveyButton().click();
    }
}
