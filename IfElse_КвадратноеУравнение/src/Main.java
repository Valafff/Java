import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Введите номер месяца: ");
//        int month = Integer.parseInt(sc.nextLine());
//
//        String season;
//        if (month < 1 || month > 12)
//        {
//            System.out.println("error: такого месяца не существует");
//            return;
//        }
//        else if (month == 12 || month <= 2)
//        {
//            season = "зима";
//        }
//        else if (month >= 3 && month <= 5)
//        {
//            season = "весна";
//        }
//        else if (month >= 6 && month <= 8)
//        {
//            season = "лето";
//        }
//        else
//        {
//            season = "осень";
//        }
//        System.out.println("время года: " + season);


        //КВУР
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("введите a: ");
//        double a = scanner.nextDouble();
//        System.out.print("введите  b: ");
//        double b = scanner.nextDouble();
//        System.out.print("введите  c: ");
//        double c = scanner.nextDouble();
//
//        if (a == 0)
//        {
//            System.out.println("Уравнение решать нельзя");
//        }
//        else
//        {
//            double d = b * b - 4 * a * c;
//            if (d < 0)
//            {
//                System.out.println("Корней нет");
//            }
//            else if (d == 0)
//            {
//                double x = -b / (2 * a);
//                System.out.printf("Один корень: x = %.2f%n", x);
//            }
//            else
//            {
//                double x1 = (-b + Math.sqrt(d)) / (2 * a);
//                double x2 = (-b - Math.sqrt(d)) / (2 * a);
//                System.out.printf("два корня: x1 = %.2f, x2 = %.2f%n", x1, x2);
//            }
//        }

//        try {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Введите a: ");
//            double a = scanner.nextDouble();
//            System.out.print("Введите b: ");
//            double b = scanner.nextDouble();
//            System.out.print("Введите c: ");
//            double c = scanner.nextDouble();
//
//            if (a == 0) {
//                System.out.println("Уравнение решать нельзя");
//            }
//            else
//            {
//                double d = b * b - 4 * a * c;
//                if (d < 0)
//                {
//                    System.out.println("Корней нет");
//                }
//                else if (d == 0)
//                {
//                    double x = -b / (2 * a);
//                    System.out.printf("Один корень: x = %.2f%n", x);
//                }
//                else
//                {
//                    double x1 = (-b + Math.sqrt(d)) / (2 * a);
//                    double x2 = (-b - Math.sqrt(d)) / (2 * a);
//                    System.out.printf("Два корня: x1 = %.2f, x2 = %.2f%n", x1, x2);
//                }
//            }
//        }
//        catch (Exception e) {
//            System.out.println("Ошибка вводв");
//        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("введите a: ");

        double a, b, c;
        if (scanner.hasNextDouble())
        {
            a = scanner.nextDouble();
        }
        else
        {
            System.out.println("ошибка ввода");
            return;
        }
        System.out.print("введите  b: ");
        if (scanner.hasNextDouble())
        {
            b = scanner.nextDouble();
        }
        else
        {
            System.out.println("ошибка ввода");
            return;
        }
        System.out.print("введите  c: ");
        if (scanner.hasNextDouble())
        {
           c = scanner.nextDouble();
        }
        else
        {
            System.out.println("ошибка ввода");
            return;
        }

        if (a == 0)
        {
            System.out.println("Уравнение решать нельзя");
        }
        else
        {
            double d = b * b - 4 * a * c;
            if (d < 0)
            {
                System.out.println("Корней нет");
            }
            else if (d == 0)
            {
                double x = -b / (2 * a);
                System.out.printf("Один корень: x = %.2f%n", x);
            }
            else
            {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.printf("два корня: x1 = %.2f, x2 = %.2f%n", x1, x2);
            }
        }


    }
}