//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;

public class Task2 {
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

    public static  String generateRandomIPv4(Random random)
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


    public static  String generateRandomText(int ipv4Count, double ipv4Percentage, Random random)
    {
        return  "text";
    }

}

