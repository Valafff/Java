package org.example;
import org.example.users.User;


import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

public class Main {

    public static void withAnonymousClass() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(111, 101, -1010, -12345, 0));
        System.out.println("numbers: " + numbers);

        // сортировка чисел с компаратором
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == null || o2 == null) {
                    throw new UnsupportedOperationException("null values is unsupported");
                }
                int o1DigitsCount = Integer.toString(Math.abs(o1)).length();
                int o2DigitsCount = Integer.toString(Math.abs(o2)).length();
                return Integer.compare(o1DigitsCount, o2DigitsCount);
            }
        };
        numbers.sort(comparator);

        System.out.println("sorted numbers: " + numbers);
    }

    public static void withCallbackMethod() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(111, 101, -1010, -12345, 0));
        System.out.println("numbers: " + numbers);

        // сортировка чисел с передачей callback-метода
        numbers.sort(Main::compareByDigitsLength);

        System.out.println("sorted numbers: " + numbers);
    }

    public static int compareByDigitsLength(Integer o1, Integer o2) {
        if (o1 == null || o2 == null) {
            throw new UnsupportedOperationException("null values is unsupported");
        }
        int o1DigitsCount = Integer.toString(Math.abs(o1)).length();
        int o2DigitsCount = Integer.toString(Math.abs(o2)).length();
        return Integer.compare(o1DigitsCount, o2DigitsCount);
    }

    public static void withLambdaExpression() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(111, 101, -1010, -12345, 0));
        System.out.println("numbers: " + numbers);

        // сортировка чисел с компаратором
        final Counter counter = new Counter();
        numbers.sort((o1, o2) -> {
            counter.inc();
            System.out.println("compareTo#" + counter.get());
            if (o1 == null || o2 == null) {
                throw new UnsupportedOperationException("null values is unsupported");
            }
            int o1DigitsCount = Integer.toString(Math.abs(o1)).length();
            int o2DigitsCount = Integer.toString(Math.abs(o2)).length();
            return Integer.compare(o1DigitsCount, o2DigitsCount);
        });
        System.out.println("compareTo count: " + counter.get());

        System.out.println("sorted numbers: " + numbers);
    }

    public static class Counter {
        private int counter;

        public Counter() {
            counter = 0;
        }

        public void inc() {
            counter++;
        }

        public int get() {
            return counter;
        }
    }


    public  static  int getAvarage(List<User> users)
    {
        int counter = 0;
        for (User user : users)
        {
            counter += user.getBonusBalance();
        }
        int avarage = counter/users.size();
        return  avarage;
    }


    // deactivateUsers - деактивация пользователей (user.setActive(false))
    // проверяется для всех пользователей условие, и если оно выполняется, то деактировать такого пользователя
    public static void deactivateUsers(List<User> users, Predicate<User> condition)
    {
        for (User user : users) {
            if (condition.test(user)) {
                user.setActive(false);
            }
        }
    }

    // extractUsers - извлечение пользователей из полученного списка по некоторому условию
    // все пользователи, для которых выполняется условие, должны быть удалены из полученного списка (параметр меняется)
    // и добавлены в новый список, который вернуть через return
    public static List<User> extractUsers(List<User> users, Predicate<User> condition) {
        throw new UnsupportedOperationException("implement me");
    }



    public static void main(String[] args) {
        withAnonymousClass();
        withCallbackMethod();
        withLambdaExpression();

        List<User> users = generateUserList(10, 100, new Random());

        System.out.println("users:");
        users.forEach(System.out::println);

        // ЗАДАНИЕ:
        // 1. реализовать тело метода deactivateUsers
        // 2. с помощью данного метода деактивировать всех пользователей у которых бонусный баланс меньше
        // среднего бонусного баланса среди всех пользователей
        // 3. вывести результат
        int avarage = getAvarage(users);
        deactivateUsers(users, user ->  user.getBonusBalance() < avarage);
        users.forEach(System.out::println);




        // 4. реализовать тело метода extractUsers
        // 5. с помощью данного метода извлечь всех деактивированных пользователей из исходного списка
        // вывести полученные списки (исходный с извлеченными деактивированными пользователями, и список деактивированных)

        // УСЛОВИЕ: в main без циклов, в процедурах использовать циклы с функциональными интерфейсами
    }

    private static List<User> generateUserList(int n, int maxBonusBalance, Random random) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = i + 1;
            String nickname = "user#1" + (i + 1);
            int bonusBalance = random.nextInt(maxBonusBalance + 1);
            users.add(new User(id, nickname, bonusBalance));
        }
        return users;
    }





}







