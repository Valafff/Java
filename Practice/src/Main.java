import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        String ip = Task2.generateRandomIPv4(rand);
        System.out.println(ip);

        boolean result =  Task2.validateIPv4(ip);

        String answer = result ? "Адрес валидный" : "Адрес не валидный";
        System.out.println(answer);
    }
}

