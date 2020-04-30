import java.util.Arrays;
import java.util.LinkedList;

/**
 * This class solves the Sentence
 * Decomposition problem from
 * TopCoder which was used as
 * Data Structures and Algorithms II
 * second exam.
 */
public class SentenceDecomposition {
    public static void main(String[] args) {
        String s = "abba";
        String [] words = {"ab", "ac", "ad"};
        decompose(s, words);
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
        LinkedList<String> list = new LinkedList<>();
        int sum = 0;
        String [] wordsSorted = new String[words.length];
        String aux = "";

        for (int i = 0; i < words.length; i++) {
            wordsSorted[i] = words[i];
            wordsSorted[i] = wordSort(wordsSorted[i]);
        }



        return sum;
    }

    /**
     * This method sorts the
     * characters in a String
     * @param s String to be sorted
     * @return sorted String
     */
    public static String wordSort(String s) {
        char [] divided = s.toCharArray();
        Arrays.sort(divided);
        String result = "";
        for (int i = 0; i < divided.length; i++) {
            result += divided[i];
        }
        return result;
    }

    /**
     * This methid calculates
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
        int cost = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                cost++;
            }
        }
        return cost;
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
        return (wordSort(first).equals(wordSort(second)));
    }
}
