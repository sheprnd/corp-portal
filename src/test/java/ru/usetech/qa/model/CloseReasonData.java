package ru.usetech.qa.model;

public class CloseReasonData {

    private String name;
    private Integer satisfaction;

    public String getName() {
        return name;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public CloseReasonData withName(String name) {
        this.name = name;
        return this;
    }

    public CloseReasonData withSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
        return this;
    }
}
