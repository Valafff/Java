package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.example.cars.Car;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        // ArrayList<Integer> numbers = new ArrayList<>(List.of(-5, -2, 33, 0, 15, 0, -100));

        int n = 10, min = -100, max = 100;
        final Random random = new Random();
        ArrayList<Integer> numbers = Stream.generate(() -> random.nextInt(min, max+1))
                .limit(n)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("numbers: " + numbers);

        ArrayList<Integer> positiveNumbers = numbers.stream()
                .filter(number -> number > 0)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("positive numbers: " + positiveNumbers);

        ArrayList<String> numbersAsHEXStrings = numbers.stream()
                .map(number -> {
                    String hexString = Integer.toHexString(Math.abs(number));
                    if (number < 0) {
                        return "-" + hexString;
                    }
                    return hexString;
                }).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("hex numbers: " + numbersAsHEXStrings);

        ArrayList<Integer> numbersWithStartZeroes = numbers.stream()
                .sorted((n1, n2) -> {
                    if (n1.equals(n2)) {
                        return 0;
                    }
                    if (n1 == 0) {
                        return -1;
                    }
                    return 1;
                }).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("numbers with start zeroes: " + numbersWithStartZeroes);

        Optional<Integer> firstPositiveNumber = numbers.stream()
                .filter(number -> number > 0)
                .findFirst();
        if (firstPositiveNumber.isPresent()) {
            System.out.println("first positive number: " + firstPositiveNumber.get());
        } else {
            System.out.println("no positive numbers in list");
        }

        long zeroesCount = numbers.stream()
                .filter(number -> number == 0)
                .count();
        System.out.println("zeroes count: " + zeroesCount);

        int absSum = numbers.stream()
                .reduce(0, (sum, number) -> Math.abs(number) + sum);
        System.out.println("abs sum: " + absSum);


        String[] models = new String[] {
                "BA3 2107", "Toyta Ipsum", "Nissan Almera 615", "BA3 2104",
                "Renault Logan", "Toyota Land Cruiser Prado", "Ford Gran Torino"
        };
        final int minPrice = 100, maxPrice = 3000, minPower = 70, maxPower = 350;
        List<Car> cars = Arrays.stream(models)
                .map(model -> new Car(
                        model,
                        random.nextInt(minPrice, maxPrice) * 1000L,
                        random.nextInt(minPower, maxPower)
                )).toList();
        System.out.println("Исходные автомобили:");
        cars.forEach(System.out::println);

        System.out.println("Дорогие автомобили:");
        ArrayList<Car> richCars = cars.stream().filter(car -> car.getPrice() > 1000000).collect(Collectors.toCollection(ArrayList::new));
        richCars.forEach(System.out::println);

        System.out.println("Автомобили с ценой выше средней рыночной:");
        long avaragePrice = cars.stream().mapToLong(Car::getPrice).sum()/cars.size();
        ArrayList<Car> overPriceCars = cars.stream().filter(car -> car.getPrice() > avaragePrice).collect(Collectors.toCollection(ArrayList::new));
        overPriceCars.forEach(System.out::println);

        System.out.println("Повышение цен:");
        cars.forEach(car -> car.setPrice((long)(car.getPrice() * 1.2)));
        cars.forEach(System.out::println);

        Map<String, List<Car>> carsByPower = cars.stream()
                .collect(Collectors.groupingBy(car -> {int power = car.getPower();
                    if (power < 95) return "до 95 л.с.";
                    else if (power <= 130) return "95-130 л.с.";
                    else return "более 130 л.с.";
                }));

        System.out.println("Сгруппированые по мощности");
        carsByPower.forEach((range, carList) -> {
            System.out.println("\nГруппа: " + range);
            carList.forEach(System.out::println);
        });

        System.out.println("\nМашины отсортированные по цене");
        cars.stream().sorted(Comparator.
                comparingLong(Car::getPrice)).
                forEach(System.out::println);

        System.out.println("\nМашины, отсортированные по мощности:");
        cars.stream().sorted(Comparator.
                comparingInt(Car::getPower)).
                forEach(System.out::println);

        System.out.println("\nОбъединение групп по мощности с дешевыми автомобилями:");

        List<Car> cheapCars = cars.stream().filter(car -> car.getPrice() < 1000000).toList();

        List<Car> combinedList = carsByPower.values().stream().flatMap(List::stream).collect(Collectors.toList());
        combinedList.addAll(cheapCars);

        combinedList.forEach(System.out::println);
    }
}