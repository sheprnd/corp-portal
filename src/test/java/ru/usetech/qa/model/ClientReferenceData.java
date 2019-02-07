package ru.usetech.qa.model;

public class ClientReferenceData {

    private String referenceName;


    public String getreferenceName() {
        return referenceName;
    }


    public ClientReferenceData withName(String referenceName) {

        this.referenceName = referenceName;
        return this;

    }


}
