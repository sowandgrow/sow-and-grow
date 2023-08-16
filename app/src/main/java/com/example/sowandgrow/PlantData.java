package com.example.sowandgrow;

public class PlantData {
    private String commonName;
    private String botanicalName; // Changed from "latinName"

    public PlantData(String commonName, String botanicalName) {
        this.commonName = commonName;
        this.botanicalName = botanicalName;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getBotanicalName() {
        return botanicalName;
    }
}
