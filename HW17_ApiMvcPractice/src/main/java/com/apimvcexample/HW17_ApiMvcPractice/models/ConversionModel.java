package com.apimvcexample.HW17_ApiMvcPractice.models;

public class ConversionModel
{
    public String getFromSystem() {
        return fromSystem;
    }

    public String getToSystem() {
        return toSystem;
    }

    public String getNumber() {
        return number;
    }

    public String getResult() {
        return result;
    }

    public void setFromSystem(String fromSystem) {
        this.fromSystem = fromSystem;
    }

    public void setToSystem(String toSystem) {
        this.toSystem = toSystem;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ConversionModel() {
    }

    private String fromSystem;
    private String toSystem;
    private String number;
    private String result;

}
