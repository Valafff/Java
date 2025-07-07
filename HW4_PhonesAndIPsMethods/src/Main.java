import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        String[] arrPhones = new  String[5];

        long min = 10000000000L;
        long max = 99999999999L;

        for (int i = 0; i < arrPhones.length; i++) {
            var n = (rand.nextLong(max - min) + min);
            arrPhones[i] =  String.valueOf(n);
            if (i%2 == 0)
            {
                arrPhones[i] = "fakeNumber";
            }
        }

        System.out.println();
        System.out.println("validateRawNumber(String rawNumber)");
        for(String number: arrPhones)
        {
            var result = Task1_PhoneNumbers.validateRawNumber(number);
            System.out.println("Валидация номера " + number + " " +  result);
        }

        System.out.println();
        System.out.println("validateFormattedNumber(String formattedNumber)");
        System.out.println("Валидация номера +7-800-555-35-35 " + Task1_PhoneNumbers.validateFormattedNumber("+7-800-555-35-35"));
        System.out.println("Валидация номера +7-800-327-45-67 " + Task1_PhoneNumbers.validateFormattedNumber("+7-800-327-45-67"));
        System.out.println("Валидация номера qwerty " +Task1_PhoneNumbers.validateFormattedNumber("qwerty"));
        System.out.println("Валидация номера +123456789 " +Task1_PhoneNumbers.validateFormattedNumber("+123456789"));
        System.out.println("Валидация номера +7-800-654-29-81 " +Task1_PhoneNumbers.validateFormattedNumber("+7-800-654-29-81"));

        System.out.println();
        System.out.println("convertRawToFormatted(String rawNumber)");
        System.out.println(Task1_PhoneNumbers.convertRawToFormatted("8005553535"));
        System.out.println(Task1_PhoneNumbers.convertRawToFormatted("8001234567"));
        System.out.println(Task1_PhoneNumbers.convertRawToFormatted("1234567890"));
        System.out.println(Task1_PhoneNumbers.convertRawToFormatted("800123456"));
        System.out.println(Task1_PhoneNumbers.convertRawToFormatted(null));

        System.out.println();
        System.out.println("convertFormattedToRaw(String formattedNumber)");
        System.out.println(Task1_PhoneNumbers.convertFormattedToRaw("+7 800 555-35-35"));
        System.out.println(Task1_PhoneNumbers.convertFormattedToRaw("8 (800) 555-35-35"));
        System.out.println(Task1_PhoneNumbers.convertFormattedToRaw("+7(912)123-45-67"));
        System.out.println(Task1_PhoneNumbers.convertFormattedToRaw("800-555-35"));
        System.out.println(Task1_PhoneNumbers.convertFormattedToRaw(null));

        System.out.println();
        System.out.println("generateRawNumber(Random random)");
        System.out.println(Task1_PhoneNumbers.generateRawNumber(new Random()));
        System.out.println(Task1_PhoneNumbers.generateRawNumber(new Random()));
        System.out.println(Task1_PhoneNumbers.generateRawNumber(new Random()));
        System.out.println(Task1_PhoneNumbers.generateRawNumber(new Random()));
        System.out.println(Task1_PhoneNumbers.generateRawNumber(new Random()));

        System.out.println();
        System.out.println("generateFormattedNumber(Random random)");
        for (int i = 0; i < 5; i++) {
            String formattedNumber = Task1_PhoneNumbers.generateFormattedNumber(new Random());
            System.out.println(formattedNumber);
        }

        System.out.println();
        System.out.println("generateNumbers(int count, Random random): ");
        String[][] numbers = Task1_PhoneNumbers.generateNumbers(5, new Random());
        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = 0; j < numbers[i].length; j++)
            {
                System.out.println(numbers[i][j]);
            }
        }

        System.out.println();
        System.out.println("validateIPv4(String ipv4String): ");
        System.out.println(Task2_IpAddresses.validateIPv4("255.255.255.255"));
        System.out.println(Task2_IpAddresses.validateIPv4("333.444.555.255"));
        System.out.println(Task2_IpAddresses.validateIPv4("100."));
        System.out.println(Task2_IpAddresses.validateIPv4(""));
        System.out.println(Task2_IpAddresses.validateIPv4("192.168.0.1"));

        System.out.println();
        System.out.println("generateRandomIPv4(Random random):");
        boolean result;
        int counter = 0;
        while (counter < 5)
        {
            String ip = Task2_IpAddresses.generateRandomIPv4(rand);
            result =  Task2_IpAddresses.validateIPv4(ip);
            System.out.println("Адрес " + ip + (result ? " Адрес валидный" : " Адрес не валидный"));
            counter++;
        }

        System.out.println();
        System.out.println("extractAllIPv4(String text): ");
        String text = "Вчера я пытался подключиться к серверу с IP-адресом 192.168.1.1, но у меня ничего не вышло. " +
                "Мой друг посоветовал попробовать 256.300.400.500, но это тоже не сработало. Затем я нашел в интернете " +
                "список адресов и попробовал 10.0.0.1, который .15.оказался рабочим. Еще один адрес, 172.16.254.1, " +
                "тоже оказался валидным, но 192.168.300.400 не работал.";
        String[] addrs = Task2_IpAddresses.extractAllIPv4(text);
        System.out.println(Arrays.toString(addrs));

        System.out.println();
        System.out.println("generateRandomText(int ipv4Count, double ipv4Percentage, Random random)");
        String BUGAGA = Task2_IpAddresses.generateRandomText(5, 30, rand);
        System.out.println(BUGAGA);
        String[] BUGAGAaddrs = Task2_IpAddresses.extractAllIPv4(BUGAGA);
        System.out.println(Arrays.toString(BUGAGAaddrs));

    }
}

