package org.top.airportdirectoryapp.model;

// Airport - класс, описывающий сущность аэропорта
public class Airport {
    private String code;         // уникальный трехбуквенный код аэропорта в большом регистре
    private String name;         // наименование аэропорта
    private Integer runwayCount; // кол-во ВПП

    public Airport() {}

    public Airport(String code, String name, Integer runwayCount) {
        this.code = code;
        this.name = name;
        this.runwayCount = runwayCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRunwayCount() {
        return runwayCount;
    }

    public void setRunwayCount(Integer runwayCount) {
        this.runwayCount = runwayCount;
    }
}
