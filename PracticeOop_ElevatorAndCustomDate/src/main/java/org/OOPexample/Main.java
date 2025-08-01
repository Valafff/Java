package org.OOPexample;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CustomDate fullCustom = new CustomDate(10,10,1010);
        CustomDate onlyCustomDay = new CustomDate(10);
        CustomDate customDayAndMonthYear = new CustomDate(28,6);
        CustomDate nowDate = new CustomDate();

        System.out.println("Изначальная дата "+fullCustom.toString());
        System.out.println("Валидация " + fullCustom.isValid());
        fullCustom.next();
        System.out.println("Прибавление дня "+fullCustom.toString());
        System.out.println("Количество дней от 01.01.0000 "+fullCustom.toDays());
        System.out.println("Разница между датами "+fullCustom.dateOffset(nowDate));

        System.out.println();
        Elevator elevator = new Elevator();
        elevator.setMaxFloor(25);
        elevator.setCurrentFloor(13);
        elevator.setMaxWeight(900);
        System.out.println("Текущий этаж " + elevator.getCurrentFloor());
        elevator.callElevator(1);
        System.out.println("Текущий этаж " + elevator.getCurrentFloor());
        elevator.sendElevator(10, 450);
        System.out.println("Текущий этаж " + elevator.getCurrentFloor());
        System.out.println(elevator.getElevatorType());
        elevator.elevatorInfo();
    }
}