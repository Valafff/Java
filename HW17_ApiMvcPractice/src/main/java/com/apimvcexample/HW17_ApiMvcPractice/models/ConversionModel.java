package com.apimvcexample.HW17_ApiMvcPractice.models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель конвертации систем счисления")
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

    @Schema(description = "Из какой системы счисления конвертировать", example = "10")
    private String fromSystem;
    @Schema(description = "В какую систему счисления конвертировать", example = "16")
    private String toSystem;
    @Schema(description = "Конвертируемое число", example = "255")
    private String number;
    @Schema(description = "Результат работы", example = "ff")
    private String result;

}
