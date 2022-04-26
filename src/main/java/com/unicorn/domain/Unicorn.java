package com.unicorn.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Unicorn {


    private int unicornId;
    private String name;
    private String hairColor;
    private int hornLength;
    private String hornColor;
    private String eyeColor;
    private int height;
    private String heightUnit;
    private int weight;
    private String weightUnit;
    private List<IdentifiableMarks> identifiableMarks;

    public int getUnicornId() {
        return unicornId;
    }

    public void setUnicornId(int unicornId) {
        this.unicornId = unicornId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public int getHornLength() {
        return hornLength;
    }

    public void setHornLength(int hornLength) {
        this.hornLength = hornLength;
    }

    public String getHornColor() {
        return hornColor;
    }

    public void setHornColor(String hornColor) {
        this.hornColor = hornColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public List<IdentifiableMarks> getIdentifiableMarks() {
        return identifiableMarks;
    }

    public void setIdentifiableMarks(List<IdentifiableMarks> identifiableMarks) {
        this.identifiableMarks = identifiableMarks;
    }
}
