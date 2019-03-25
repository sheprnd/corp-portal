package ru.usetech.qa.model;

public class ReportGroupData {

    private String reportGroupName;

    public String getReportGroupName() {
        return reportGroupName;
    }

    public ReportGroupData withName(String reportGroupName) {

        this.reportGroupName = reportGroupName;
        return this;

    }
}
