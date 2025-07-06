import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
//
//            int a = 10;
//            int b = 15;
//
//        System.out.println("a= "+ a + "; " + "b= " + b + ";" );
//        int c;
//        c = a;
//        a = b;
//        b = c;
//        System.out.println("a= "+ a + "; " + "b= " + b + ";" );

        Scanner sc = new Scanner(System.in);
            System.out.println("Длина окружности");
            double l = Double.parseDouble(sc.nextLine());
            double d = l/3.14;
            double s = 3.14*d*d/4;
//            System.out.println("Площадь круга:" + s);
            System.out.printf("Площадь круга: %f", ((l*l)/4*Math.PI));


        System.out.print("Введите количество секунд: ");
        int input = Integer.parseInt(sc.nextLine());
        int hours = input / 3600;
        int lastsec = input % 3600;
        int minutes = lastsec / 60;
        int sec = lastsec % 60;
        System.out.printf("%d c. = %d ч. %d м. %d с.", input, hours, minutes, sec);


        LocalDate today = LocalDate.now();
        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);
        long daysUntilNewYear = ChronoUnit.DAYS.between(today, newYear);
        System.out.printf("До Нового года: %d\n", daysUntilNewYear);
        }
    }
