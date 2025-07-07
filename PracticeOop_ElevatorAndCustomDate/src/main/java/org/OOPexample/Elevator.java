package org.OOPexample;

public class Elevator
{
    final double passengerElevator = 0;
    final double cargoElevator = 401;
    final double industrialElevator = 1501;

    double maxWeight;
    int maxFloor;
    int currentFloor;

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Elevator() {}

    public Elevator(int currentFloor, int floor, double maxWeight) {
        this.currentFloor = currentFloor;
        this.maxFloor = floor;
        this.maxWeight = maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        if (maxWeight < 0)
        {
            this.maxWeight = 0;
        }
        else
        {
            this.maxWeight = maxWeight;
        }
    }

    public void setMaxFloor(int maxFloor) {
        if (maxFloor < 0)
        {
            this.maxFloor = 0;
        }
        else
        {
            this.maxFloor = maxFloor;
        }
    }

    public void setCurrentFloor(int currentFloor) {
        if (currentFloor < 0 || currentFloor > maxFloor)
        {
            currentFloor = 0;
        }
        else
        {
            this.currentFloor = currentFloor;
        }
    }

    public void callElevator(int targetFloor)
    {
        if (targetFloor >= 0 && targetFloor <= maxFloor)
        {
            currentFloor = targetFloor;
        }
        else
        {
            System.out.println("Этаж задан некорректно");
        }
    }

    public void  sendElevator(int targetFloor, double passengeresWeight)
    {
        if (passengeresWeight<=0)
        {
            System.out.println("Пассажиры должны иметь положительный вес");
        }
        else if (targetFloor >= 0 && targetFloor <= maxFloor && targetFloor != currentFloor && passengeresWeight <= maxWeight)
        {
            currentFloor = targetFloor;
        }
        else if(currentFloor == targetFloor)
        {
            System.out.println("Нельзя ехать на этаж на котором уже находится лифт");
        }
        else if (passengeresWeight > maxWeight)
        {
            System.out.println("Перегруз");
        }
        else
        {
            System.out.println("Введен ошибочный этаж");
        }
    }

    public String getElevatorType()
    {
        if (maxWeight < cargoElevator)
        {
            return "Лифт пассажирский";
//            System.out.println("Лифт пассажирский");
        }
        else if(maxWeight < industrialElevator)
        {
            return "Лифт грузовой";
//            System.out.println("Лифт грузовой");
        }
        else
        {
            return "Лифт промышленный";
//            System.out.println("Лифт промышленный");
        }
    }

    public  void elevatorInfo()
    {
        System.out.println("Тип лифта: " + getElevatorType());
        System.out.println("Грузоподъмность: " + getMaxWeight());
        System.out.println("Этажность: " + getMaxFloor());
    }

}
