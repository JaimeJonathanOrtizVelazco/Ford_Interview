import java.util.HashMap;
import java.util.Map;

public class Main {
    // Method Number to string roman
    // from 1 to 3000
    public static void main(String[] args) {
        convertToRoman(544);
//        convertToRoman(1354);
//        convertToRoman(8);
//        convertToRoman(56);
        System.out.println("Hello world!");
    }

    public static void convertToRoman(int value) {

        //        String [] romanDigits = {"I","V","X", "L","C","D", "M"};
        Map<Integer,Character> romanDigits = new HashMap<>();
        romanDigits.put(1,'I');
        romanDigits.put(5,'V');
        romanDigits.put(10,'X');
        romanDigits.put(50,'L');
        romanDigits.put(100,'C');
        romanDigits.put(500,'D');
        romanDigits.put(1000,'M');

        // 254 CCLIV

        // 254 % 100 = 54 -> 254 / 100 = 2  CC
        // 54 % 10 = 4 -> 54 / 10 = 5; L
        // 4 % 1 = 4  / 1 = 4 IV
        int maxDivider = 1;
        int dividerIndex = -1;

        while (value / maxDivider >= 1) {
            dividerIndex ++;
            maxDivider *= 10;
        }
        maxDivider /= 10;

        // 544
        StringBuilder romanNumberString = new StringBuilder();
        for (int i = maxDivider; i > 0; i = i/10) {
            int divisionResult = value / i;
            value = value % i;
            // case value = 5 V
            if (divisionResult == 5){
                romanNumberString.append(romanDigits.get(divisionResult * i));
            }
            if(divisionResult == 4){
                romanNumberString.append(romanDigits.get(i));
                romanNumberString.append(romanDigits.get( (divisionResult + 1) * i));
            }
            // case value = 4 IV
            // case value < 4 III
            // case value > 5 VIII
            // case value 9 IX
//            if(value > 5)
        }
        System.out.println(romanNumberString.toString());
    }
}