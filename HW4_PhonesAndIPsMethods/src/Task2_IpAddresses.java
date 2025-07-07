//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;

public class Task2_IpAddresses {
    public static  boolean validateIPv4(String ipv4String) {

        if (ipv4String == null || ipv4String.isEmpty() || ipv4String.endsWith(".")) {
            return false;
        }

        String[] octets = ipv4String.split("\\.");
        if (octets.length != 4) {
            return false;
        }

        try {
            for (String octet : octets) {
                int num = Integer.parseInt(octet);
                if (num < 0 || num > 255) {
                    return false;
                }

                if (octet.length() > 1 && octet.startsWith("0")) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static String generateRandomIPv4(Random random)
    {
        StringBuilder ipv4 = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int octet = random.nextInt(0, 256); 
            ipv4.append(String.valueOf(octet));
            if (i < 3)
            {
                ipv4.append(".");
            }
        }
        return String.valueOf(ipv4);
    }


    public static String[] extractAllIPv4(String text) {
        // 1. заменим все символы, не являющиеся цифрами или точками на один пробел
        String sanitizedText = text.replaceAll("[^0-9.]+", " ").trim();
        // 2. сделаем сплит по пробелам
        String[] potentialAddrs = sanitizedText.split(" ");
        // 3. посчитаем кол-во валидных ip-адресов и запишем информацию о них
        boolean[] isValid = new boolean[potentialAddrs.length];
        int validCount = 0;
        for (int i = 0; i < potentialAddrs.length; i++) {
            if (validateIPv4(potentialAddrs[i])) {
                isValid[i] = true;
                validCount++;
            } else {
                isValid[i] = false;
            }
        }
        // 5. сформируем результат
        String[] addrs = new String[validCount];
        int n = 0;
        for (int i = 0; i < potentialAddrs.length; i++) {
            if (isValid[i]) {
                addrs[n] = potentialAddrs[i];
                n++;
            }
        }
        // 6. вернуть результат
        return addrs;
    }

    public static String generateRandomText(int ipv4Count, double ipv4Percentage, Random random)
    {
        if (ipv4Percentage <= 0 || ipv4Percentage >= 100)
        {
            throw new IllegalArgumentException("Процент IP-адрессов должен быть между 0 и 100");
        }
        ipv4Percentage /=100;

        // 1. Генерация IP-адрессов
        String[] ipAddresses = new String[ipv4Count];
        for (int i = 0; i < ipv4Count; i++)
        {
            ipAddresses[i] = generateRandomIPv4(random);
        }

        // 2. Расчет общей длины текста
        int onlyIpLength = ipv4Count * 15; // Каждый IPv4 занимает до 15 символов (xxx.xxx.xxx.xxx)
        int totalTextLength = (int) (onlyIpLength / ipv4Percentage);

        //3. Генерирация текста
        StringBuilder textBuilder = new StringBuilder();
        int ipIndex = 0;
        int charsRemaining = totalTextLength;


        //4. Вставка первой последовательности перед IP
        if (ipv4Count > 0)
        {
            int charsBefore = random.nextInt(charsRemaining / (ipv4Count + 1));
            appendRandomText(textBuilder, charsBefore, random);
            charsRemaining -= charsBefore;
        }

        while (ipIndex < ipv4Count && charsRemaining > 0)
        {
            //5. Вставка IP из заготовленных
            textBuilder.append(ipAddresses[ipIndex++]);
            charsRemaining -= ipAddresses[ipIndex - 1].length();

            //6. Вставка разделителя
            if (ipIndex < ipv4Count) {
                char separator = getRandomSeparator(random);
                textBuilder.append(separator);
                charsRemaining--;
            }

            //7. Вставка текста
            if (ipIndex < ipv4Count) {
                int charsBetween = random.nextInt(charsRemaining / (ipv4Count - ipIndex + 1));
                appendRandomText(textBuilder, charsBetween, random);
                charsRemaining -= charsBetween;
            }
        }

        return textBuilder.toString();
    }

    private static char getRandomChar(Random random)
    {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 .,;:!?()";
        return chars.charAt(random.nextInt(chars.length()));
    }

    private static void appendRandomText(StringBuilder builder, int length, Random random)
    {
        for (int i = 0; i < length; i++) {
            builder.append(getRandomChar(random));
        }
    }

    private static char getRandomSeparator(Random random)
    {
        String separators = ",;:!?";
        return separators.charAt(random.nextInt(separators.length()));
    }




}

