package ru.usetech.qa.model;

import java.util.Objects;

public class FeedbackTemplateData {

    private String templateName;
    private String templateText;
    private String reasonText;


    public String getTemplateName() {

        return templateName;

    }

    public String getTemplateText(){

        return templateText;
    }

    public String getReasonText(){

        return reasonText;

    }



    public FeedbackTemplateData withName(String feedbackTemplateName) {

        this.templateName = feedbackTemplateName;
        return this;

    }

    public FeedbackTemplateData withText(String feedbackTemplateText){

        this.templateText = feedbackTemplateText;
        return this;
    }

    public FeedbackTemplateData withReasonText (String feedbackReasonText){

        this.reasonText = feedbackReasonText;
        return this;
    }

    @Override
    public String toString() {
        return "FeedbackTemplateData{" +
                "templateName='" + templateName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackTemplateData that = (FeedbackTemplateData) o;
        return Objects.equals(templateName, that.templateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templateName);
    }
}
