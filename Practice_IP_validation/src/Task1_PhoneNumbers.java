import java.util.Random;
import java.util.regex.Pattern;

public class Task1_PhoneNumbers {


    public static  boolean validateRawNumber(String rawNumber)
    {
        if (rawNumber == null || rawNumber.isEmpty())
        {
            return false;
        }
        int number = Character.getNumericValue(rawNumber.charAt(0));
        if (number <= 0)
        {
            return  false;
        }
        return rawNumber.matches("\\d{11}");
    }

    public  static  boolean validateFormattedNumber(String formattedNumber)
    {
        if (formattedNumber == null || formattedNumber.isEmpty()) {
            return false;
        }
        return formattedNumber.matches("\\+7-\\d{3}-\\d{3}-\\d{2}-\\d{2}");
    }

    public static String convertRawToFormatted(String rawNumber)
    {
        if (rawNumber == null || !rawNumber.matches("\\d{10}"))
        {
            return null;
        }
        return String.format("+7 %s %s-%s-%s", rawNumber.substring(0, 3), rawNumber.substring(3, 6), rawNumber.substring(6, 8), rawNumber.substring(8));
    }

    public static String convertFormattedToRaw(String formattedNumber) {
        if (formattedNumber == null)
        {
            return null;
        }

        if (Pattern.matches("^[+]?[7-8][\\s()-]*(\\d[\\s()-]*){9,10}$", formattedNumber))
        {
            String raw = formattedNumber.replaceAll("[^0-9]", "");
            return raw.startsWith("7") ? raw.substring(1) : raw;
        }
        return null;
    }

    public static String generateRawNumber(Random random) {
        String rawNumber;

        long min = 1000000000L;
        long max = 9999999999L;
        var n = (random.nextLong(max - min) + min);
        rawNumber = String.valueOf(n);

        return rawNumber;
    }

    public static String generateFormattedNumber(Random random)
    {
        String rawNumber = generateRawNumber(random);
        return  convertRawToFormatted(rawNumber);
    }

    public static String[][] generateNumbers(int count, Random random)
    {
        String[][] numbers = new String[count][2];
        for (int i = 0; i < count; i++) {
            String newNum = generateRawNumber(random);
            numbers[i][0] = newNum;
            newNum = convertRawToFormatted(newNum);
            numbers[i][1] = newNum;
        }
        return numbers;
    }



}