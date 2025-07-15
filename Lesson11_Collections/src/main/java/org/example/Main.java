package org.example;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {

        // ЗАДАНИЕ: пользователь вводит n - целое, положительное число

        // программа должна поэтапно:
        // 1) создать 2 списока ArrayList<Integer<
        // 2) заполнить данные списки случайными числами от 0 до 100 в кол-ве n штук для каждого списка
        // 3) вывести сгенерированные списки
        // 4) создать новый список, в котором будут (без повторений, порядок не важен):
        //  - элементы первого исходного списка, отсутствующие во втором
        //  - элементы второго исходного списка, отсутствующие в первом
        // 5) вывести полученный список
        // 6) удалить из исходных списков элементы, которые вошли в третий новый список
        // 7) вывести измененные исходные списки

        Scanner scanner = new Scanner(System.in);
//        System.out.print("колличество элементов n: ");
//        int n = scanner.nextInt();
//
//        // 1) создать 2 списока ArrayList<Integer<
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//
//        // 2) заполнить данные списки случайными числами от 0 до 100 в кол-ве n штук для каждого списка
//        Random random = new Random();
//        for (int i = 0; i < n; i++)
//        {
//            list1.add(random.nextInt(101));
//            list2.add(random.nextInt(101));
//        }
//
//        // 3) вывести сгенерированные списки
//        System.out.println("Первый список: " + list1);
//        System.out.println("Второй список: " + list2);
//
//        // 4) создать новый список, в котором будут (без повторений, порядок не важен):
//        //  - элементы первого исходного списка, отсутствующие во втором
//        //  - элементы второго исходного списка, отсутствующие в первом
//        ArrayList<Integer> list3 = new ArrayList<>();
//
//        for (Integer value : list1 ) {
//            if (!list2.contains(value) && !list3.contains(value))
//            {
//                list3.add(value);
//            }
//        }
//
//        for (Integer value : list2) {
//            if (!list1.contains(value) && !list3.contains(value))
//            {
//                list3.add(value);
//            }
//        }
//        // 5) вывести полученный список
//        System.out.println("полученный список: " + list3);
//
//        // 6) удалить из исходных списков элементы, которые вошли в третий новый список
//        list1.removeAll(list3);
//        list2.removeAll(list3);
//
//        // 7) вывести измененные исходные списки
//        System.out.println("Измененный Первый список: " + list1);
//        System.out.println("Измененный Второй список: " + list2);
//


        // Пользователь вводит произвольную строку
        // Программа должна выполнить анализ строки и вывести по отдельности каждый символ данной строки
        //  и кол-во его вхождений в строку

        // порядок вывода не важен
        // информация для каждого символа выводиться без повторений

        // ввод: "hello world"

        // вывод:
        // 'h' - 1
        // 'e' - 1
        // 'l' - 3
        // 'o' - 2
        // ' ' - 1
        // 'w' - 1
        // 'r' - 1
        // 'd' - 1
        System.out.print("введите строку: ");
        String str = scanner.nextLine();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            String strcahar = String.valueOf(c);

            if (!map.containsKey(strcahar))
            {
                map.put(strcahar, 1);
            }
            else
            {
                int value = map.get(strcahar);
                map.put(strcahar, value + 1);
            }
        }
        System.out.println(map);

    }
}