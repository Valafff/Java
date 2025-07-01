import java.sql.Array;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        int n, min, max;
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("введите n: ");
//        n = scanner.nextInt();
//        System.out.print("введите  min: ");
//        min = scanner.nextInt();
//        System.out.print("введите  max: ");
//        max = scanner.nextInt();
//
//        int[] arr = new int[n];
//
//        Random random = new Random();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt(min, max);
//        }
//
//        System.out.println(Arrays.toString(arr));
//
//        OptionalInt tmpMax = Arrays.stream(arr).max();
//        OptionalInt tmpMin = Arrays.stream(arr).min();
//
//        double avarage = 0;
//        int sum = 0;
//        if (arr.length > 0)
//        {
//            for (int j : arr) {
//                avarage += j;
//                sum += j;
//            }
//            avarage = avarage/n;
//        }
//
//        System.out.println(tmpMax);
//        System.out.println(tmpMin);
//        System.out.println(avarage);
//        System.out.println(sum);

//        int n;
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("введите n: ");
//
//        // многомерные массивы в Java
//        int[][] matrix = new int[5][7];
//
//        Random random = new Random();
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                matrix[i][j] = random.nextInt(bound: 10);
//            }
//        }
//
//        for (int[] row : matrix) {
//            for (int item : row) {
//                System.out.print(item + " ");
//            }
//            System.out.println();
//        }

        // ЗАДАЧА: пользователь вводит 1 число - n - от 0 до 9

        // Программа должна СОЗДАТЬ (и только затем вывести) двумерный массив целых чисел размером n x n
        // Который имеет следующий вид:
        /*
            ДЛЯ n = 0: 0

            ДЛЯ n = 1 :

            1 1 1
            1 0 1
            1 1 1

            Для n = 2

            2 2 2 2 2
            2 1 1 1 2
            2 1 0 1 2
            2 1 1 1 2
            2 2 2 2 2

            и Т.Д,
        */


        int step, size, delta_i, delta_j;
        Scanner scanner = new Scanner(System.in);
        System.out.print("введите n: ");

        step = scanner.nextInt();
        size = step*2 +1;

        int[][] matrix = new int[size][size];

        int counter_i = 0;
        int counter_j = step;
        int deep = step;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                int delta = step - Math.abs(counter_j);
                if (deep  > Math.abs(counter_j))
                {
                    delta = step-deep;
                }
                matrix[i][j] = step - delta;
                counter_j--;
            }

            counter_j = step;
            counter_i ++;

            if (counter_i <= step)
            {
                deep--;
            }
            else
            {
                deep++;
            }
        }

        //Отрисовка
        for (int[] row : matrix) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}