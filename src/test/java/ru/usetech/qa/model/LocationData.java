package ru.usetech.qa.model;

public class LocationData {

    private String locationName;

    public String getLocationName() {
        return locationName;
    }

    public LocationData withName(String locationName) {

        this.locationName = locationName;
        return this;

    }
}
