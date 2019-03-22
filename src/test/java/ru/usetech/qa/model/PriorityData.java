package ru.usetech.qa.model;

public class PriorityData {

    private String priorityName;

    public String getPriorityName() {
        return priorityName;
    }

    public PriorityData withName(String priorityName) {

        this.priorityName = priorityName;
        return this;

    }
}
