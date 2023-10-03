package com.sowandgrow.app.data;

public class PlantsModel {
    private String imageResource;
    private String botanicalName;
    private String plantName;
    private String plantType;
    private String bloomTime;
    private String plantColor;
    private String nativeArea;
    private String toxicity;
    private String sunExposure;
    private String care;
    private String water;
    private String sun;

    public PlantsModel(){}

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

    public String getBotanicalName() {
        return botanicalName;
    }

    public void setBotanicalName(String botanicalName) {
        this.botanicalName = botanicalName;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public String getBloomTime() {
        return bloomTime;
    }

    public void setBloomTime(String bloomTime) {
        this.bloomTime = bloomTime;
    }

    public String getPlantColor() {
        return plantColor;
    }

    public void setPlantColor(String plantColor) {
        this.plantColor = plantColor;
    }

    public String getNativeArea() {
        return nativeArea;
    }

    public void setNativeArea(String nativeArea) {
        this.nativeArea = nativeArea;
    }

    public String getToxicity() {
        return toxicity;
    }

    public void setToxicity(String toxicity) {
        this.toxicity = toxicity;
    }

    public String getSunExposure() {
        return sunExposure;
    }

    public void setSunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }

    public String getCare() {
        return care;
    }

    public void setCare(String care) {
        this.care = care;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public PlantsModel(String imageResource, String botanicalName, String plantName, String plantType, String bloomTime, String plantColor, String nativeArea, String toxicity, String sunExposure, String care, String water, String sun) {
        this.imageResource = imageResource;
        this.botanicalName = botanicalName;
        this.plantName = plantName;
        this.plantType = plantType;
        this.bloomTime = bloomTime;
        this.plantColor = plantColor;
        this.nativeArea = nativeArea;
        this.toxicity = toxicity;
        this.sunExposure = sunExposure;
        this.care = care;
        this.water = water;
        this.sun = sun;
    }
}
