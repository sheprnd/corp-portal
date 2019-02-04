package ru.usetech.qa.model;

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



    public FeedbackTemplateData withFeedbackTemplateName(String feedbackTemplateName) {

        this.templateName = feedbackTemplateName;
        return this;

    }

    public FeedbackTemplateData withFeedbackTemplateText (String feedbackTemplateText){

        this.templateText = feedbackTemplateText;
        return this;
    }

    public FeedbackTemplateData withReasonText (String feedbackReasonText){

        this.reasonText = feedbackReasonText;
        return this;
    }




}
