package ru.usetech.qa.model;

public class ReportData {

    private String reportName;
    private Integer externalId;

    public String getReportName() {
        return reportName;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public ReportData withName(String reportName) {

        this.reportName = reportName;
        return this;
    }

    public ReportData withExternalId(Integer externalId) {

        this.externalId = externalId;
        return this;

    }
}
