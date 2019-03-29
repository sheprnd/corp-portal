package ru.usetech.qa.model;

public class WebhookData {

    private String webhookName;
    private String webhookUrl;

    public String getWebhookName() {
        return webhookName;
    }

    public String getWebhookUrl() {
        return webhookUrl;
    }

    public WebhookData withName(String webhookName) {

        this.webhookName = webhookName;
        return this;

    }

    public WebhookData withUrl(String webhookUrl) {

        this.webhookUrl = webhookUrl;
        return this;

    }
}
