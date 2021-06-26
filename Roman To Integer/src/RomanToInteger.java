import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        String s = "MCMXCIV";

        Map<Character, Integer> romanValues = new HashMap<>();

        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;

        char previousChar = s.charAt(0); // 'previousChar' variable for tracking previously traced character in String 's'.

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i); // 'currentChar' variable for saving current iterating character.
            if (romanValues.get(currentChar) <= romanValues.get(previousChar)) { // checking if currentChar's value is less
                                                                                 // than or equal to previousChar's value.
                                                                                 // e.g.- III, VI, MDC, CXI, etc.
                result += romanValues.get(currentChar); // adding value of currentChar to result.
            } else {  // if currentChar's value is greater than previousChar's value.
                      // e.g.- IV, IX, MCD, CMX, VL, etc.
                result += romanValues.get(currentChar) - (2 * romanValues.get(previousChar));
                // Because we have added previousChar's value already in the previous iteration, so we are subtracting twice of
                // previousChar's value from currentChar's value before adding it to result.
                // e.g.- for "IV" : 1st iteration- result = 0 + 1 -> {result += 'I'} = 1
                //                  2nd iteration- result = 1 + (5 - (2 * 1)) -> {result += 'V' - (2 * 'I')} = 4
                // So instead of (I + V)=6, it will be (I + (V - 2*I))=4.
            }
            previousChar = currentChar; // saving currentChar as previousChar for next iteration.
        }

        System.out.println(result);
    }
}
