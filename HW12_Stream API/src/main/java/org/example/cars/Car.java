package org.example.cars;

public class Car
{
    public Car(String model, long price, int power) {
        this.model = model;
        this.price = price;
        this.power = power;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public long getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }

    private  String model;
    private long price;
    private  int power;

    @Override
    public String toString()
    {
       return "Марка "+  model + " Цена " + price + " Мощность " + power;
    }
}
