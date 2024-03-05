import java.util.HashMap;
import java.util.Map;

public class Main {
    // Problem description : Create a method that transform a given value from 1 to 3000 to roman numbers
    public static void main(String[] args) {
        // Cases where 5 is used
        convertToRoman(545);
        // Cases where 4 is used
        convertToRoman(440);
        convertToRoman(123);
        convertToRoman(1224);
        convertToRoman(404);
        // Cases where some values are less or greater than 5, excluding 4
        convertToRoman(3);
        convertToRoman(27);
        convertToRoman(13);
        convertToRoman(362);
        convertToRoman(8);
        // Cases using 9s
        convertToRoman(9);
        convertToRoman(19);
        convertToRoman(49);
        convertToRoman(99);
        // Invalid case
        convertToRoman(3001);
        // Case where mas value is 3000
        convertToRoman(3000);

    }

    public static void convertToRoman(int value) {
        if (value > 3000 || value < 0) {
            System.out.println("This operation is not allowed: " + value);
            return;
        }
        Map<Integer, Character> romanDigits = new HashMap<>();
        romanDigits.put(1, 'I');
        romanDigits.put(5, 'V');
        romanDigits.put(10, 'X');
        romanDigits.put(50, 'L');
        romanDigits.put(100, 'C');
        romanDigits.put(500, 'D');
        romanDigits.put(1000, 'M');

        int originalValue = value;
        int maxDivider = 1;

        while (value / maxDivider >= 1) {
            maxDivider *= 10;
        }
        maxDivider /= 10;

        StringBuilder romanNumberString = new StringBuilder();
        for (int i = maxDivider; i > 0; i = i / 10) {
            int divisionResult = value / i;
            value = value % i;
            // Case where division is zero, nos printing a value
            if (divisionResult == 0) {
                continue;
            }
            // case value = 4 Example : IV , XL, CD
            if (divisionResult == 4) {
                romanNumberString.append(romanDigits.get(i));
                romanNumberString.append(romanDigits.get((divisionResult + 1) * i));
                continue;
            }
            // case value = 5 Example : V , L , D
            if (divisionResult == 5) {
                romanNumberString.append(romanDigits.get(divisionResult * i));
                continue;
            }
            // case value < 4 Example : III
            if (divisionResult < 4) {
                for (int j = 0; j < divisionResult; j++) {
                    romanNumberString.append(romanDigits.get(i));
                }
                continue;
            }
            // case value > 5 Example : VIII
            if (divisionResult < 9) {
                romanNumberString.append(romanDigits.get(5 * i));
                for (int j = 0; j < divisionResult - 5; j++) {
                    romanNumberString.append(romanDigits.get(i));
                }
                continue;
            }
            // case value 9 Example: IX
            if (divisionResult == 9) {
                romanNumberString.append(romanDigits.get(i));
                romanNumberString.append(romanDigits.get((i * 10)));
            }
        }
        System.out.println(originalValue + " converted to roman is: " + romanNumberString);
    }
}