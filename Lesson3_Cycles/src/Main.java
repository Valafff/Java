import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите число от 0 до 20: ");
//
//        int a = 0;
//        if (scanner.hasNextInt()) {
//            a = scanner.nextInt();
//        }
//        else {
//        }
//        if ( a <= 0 || a > 20)
//        {
//            System.out.println("Ошибка ввода");
//            System.exit(-1);
//        }
//        long counter = a;
//        long factorial = a;
//
//        // while
//        while (counter > 1) {
//            --counter;
//            factorial *= counter;
//        }
//        System.out.println("Факториал " + a + "! = " + factorial);
//
//
//        long dw = 1;
//        counter = 1;
//        do {
//            dw *=counter;
//            counter++;
//        } while (counter <= a);
//        System.out.println(a + "! = " + dw);
//
//        long result = 1;
//        for(int i = a; i >= 1; i--) {
//            result *= i;
//        }
//        System.out.println(a + "! = " + result);
        Scanner sc = new Scanner((System.in));
        System.out.print("Введите строку");
        String str = sc.nextLine();
        str = str.toLowerCase();
        str =str.replace(" ", "");
        StringBuilder str2 = new StringBuilder();;
        for (int i = str.length()-1; i >= 0; i--) {
            char c = str.charAt(i);
            str2.append(c);
        }
        if (str.contentEquals(str2))
        {
            System.out.print("Палиндром");
        }
        else
        {
            System.out.print("Не палиндром");
        }

    }
}