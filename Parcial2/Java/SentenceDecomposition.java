import java.util.Arrays;

public class SentenceDecomposition {
    public static void main(String[] args) {
        String s = "abba";
        String [] words = {"ab", "ac", "ad"};
        //System.out.println(decompose(s, words));
        System.out.println(wordSort("cab"));
    }

    public static int decompose(String s, String [] words) {
        int sum = 0;
        String [] wordsCopy = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsCopy[i] = words[i];
        }

        String current = "";
        for (int i = 0; i < words.length; i++) {

        }

        return sum;
    }

    public static String wordSort(String s) {
        String [] divided = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            divided[i] = s.charAt(i) + "";
        }
        Arrays.sort(divided);
        String result = "";
        for (int i = 0; i < divided.length; i++) {
            result += divided[i];
        }
        return result;
    }
}
