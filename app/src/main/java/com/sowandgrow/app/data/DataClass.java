package com.sowandgrow.app.data;

public class DataClass {

    private String dataName;
    private String dataBot;
    private String dataDesc;
    private String dataWater;
    private String dataImage;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataName() {
        return dataName;
    }

    public String getDataBot() {
        return dataBot;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public String getDataWater() {
        return dataWater;
    }

    public String getDataImage() {
        return dataImage;
    }

    public DataClass(String dataName, String dataBot, String dataDesc, String dataWater, String dataImage) {
        this.dataName = dataName;
        this.dataBot = dataBot;
        this.dataDesc = dataDesc;
        this.dataWater = dataWater;
        this.dataImage = dataImage;
    }

    public DataClass(){

    }
}
