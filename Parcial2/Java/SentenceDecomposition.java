import java.util.Arrays;

/**
 * This class solves the Sentence
 * Decomposition problem from
 * TopCoder which was used as
 * Data Structures and Algorithms II
 * second exam.
 */
public class SentenceDecomposition {
    public static void main(String[] args) {
        String s = "ommwreehisymkiml";
        String [] words = {"we", "were", "here", "my", "is", "mom", "here", "si", "milk", "where", "si"};
        System.out.println(decompose(s, words));
    }

    /**
     * This method decomposes words
     * and compares them with the String s
     * as requested on the description
     * of the problem in TopCoder.
     * @param s
     * @param words
     * @return
     */
    public static int decompose(String s, String [] words) {
        int length = s.length(); // Copying the length of the original sentence into a new String variable
        int [] memorization = new int[length + 1]; // Declaring the dynamic programming array to save the calculated values
        for (int i = 0; i < memorization.length; i++) { // Going through the DP array
            memorization[i] = Integer.MAX_VALUE; // Filling the DP array with max value.
        }
        memorization[0] = 0; // Assigning 0 to the first position in the DP array as usually done in DP solutions

        for (int i = 0; i < length; i++) if (memorization[i] < Integer.MAX_VALUE) {
            for (String a: words) if (i + a.length() <= length && areAnagrams(a, s.substring(i, i + a.length()))) {
                memorization[i + a.length()] = Math.min(memorization[i + a.length()],
                        memorization[i] + cost(s.substring(i, i + a.length()), a));
            }
        }
        if (memorization[length] == Integer.MAX_VALUE) {
            return -1;
        }
        return memorization[length];
    }

    /**
     * This method sorts the
     * characters in a String
     * @param s String to be sorted
     * @return sorted String
     */
    public static String wordSort(String s) {
        char [] divided = s.toCharArray(); // Declaring a character array and filling it with the characters in String s
        Arrays.sort(divided); // Sorting the character array
        String result = ""; // Declaring a new String that will be returned
        for (char c : divided) { // Going through the character array
            result += c; // Concatenating each character in the array to the result String
        }
        return result; // Returning the new String with its characters sorted
    }

    /**
     * This method calculates
     * the cost of converting
     * first String into second
     * String.
     * Cost is defined as the
     * number of characters in
     * which two Strings differ.
     * @param first
     * @param second
     * @return cost
     */
    public static int cost(String first, String second) {
        int cost = 0; // Declaring a counter variable for the cost
        for (int i = 0; i < first.length(); i++) { // Going through the characters in the words
            if (first.charAt(i) != second.charAt(i)) { // Comparing each character position in both word
                cost++; // If character positions differ from each other, we add 1 to the counter
            }
        }
        return cost; // Returning the total cost to convert the first word into the second one
    }

    /**
     * This method determines
     * whether two words are
     * anagrams or not.
     * @param first first word
     * @param second second word
     * @return true if they are anagrams
     * else, false.
     */
    public static boolean areAnagrams(String first, String second) {
        return (wordSort(first).equals(wordSort(second))); // Returning true if two words are anagrams, otherwise false
    }
}
