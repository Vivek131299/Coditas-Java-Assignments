import java.util.Scanner;

public class EditDistance {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();

        System.out.println("Minimum operations required : " + editDistance(word1, word2));
    }

    private static int editDistance(String word1, String word2) {

        if (word1.length() == 0) {
            return word2.length(); // we have to insert all characters if String word1 is empty.
        }
        if (word2.length() == 0) {
            return word1.length(); // we have to remove all characters if String word2 is empty.
        }

        // Creating substrings of word1 and word2 starting from index 1 (2nd character).
        String substringWord1 = word1.substring(1);
        String substringWord2 = word2.substring(1);

        int count = 0;

        if (word1.charAt(0) == word2.charAt(0)) { // if first characters of both Strings are equal, no need to do any operations.
            count = editDistance(substringWord1,substringWord2); // Again calling editDistance method for substrings of both words.
        } else { // if first character is not equal.

            // incrementing count as we are performing operations on first characters and adding minimum of all three operations (replace, remove, insert) by calling method recursively.
            count = 1 + Math.min(editDistance(substringWord1, substringWord2), // for character replacement, we are passing both substrings because after replacement characters are equal, so we move to next one.
                                 Math.min(editDistance(substringWord1, word2), // for character removal, we are passing substring of word1 and original word2 because now we need to check remaining substring.
                                          editDistance(word1, substringWord2))); // for character insertion, we are passing original word1 and substring of word 2 because now we need to check remaining word2.
        }

        return count;
    }
}
