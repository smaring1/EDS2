import java.util.LinkedList;
import java.util.Scanner;

public class River {
    public static void main(String[] args) {
        //The next lines will read the input
        LinkedList<Integer> cars = new LinkedList<>();
        Scanner scan = new Scanner(System.in); //Creating the scanner
        int c = Integer.parseInt(scan.nextLine()); //Reading the first line containing the number of test cases
        String test = "";
        String values [] = new String[3];
        int arrival = 0;
        int n = 0;
        int t = 0;
        int m = 0;
        for (int i = 0; i < c; i++) {
            test = scan.nextLine();
            if (test.length() >= 5) {
                values = test.split(" ");
            }
            n = Integer.parseInt(values[0]);
            t = Integer.parseInt(values[1]);
            m = Integer.parseInt(values[2]);
            for (int j = 0; j < m; j++) {
                arrival = Integer.parseInt(scan.nextLine());
                //cars.algo(arrival);
            }
            //cars.clear();
        }
    }
}
