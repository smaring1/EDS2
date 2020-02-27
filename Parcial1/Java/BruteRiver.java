import java.util.LinkedList;
import java.util.Scanner;

class BruteRiver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //Creating the scanner
        LinkedList<Integer> cars = new LinkedList<>();
        //int cars [] = new int[1440]; //Creating an array which size will be maximum the limit of the problem
        int c = Integer.parseInt(scan.nextLine()); //Reading the first line containing the number of test cases
        String test = ""; //Initialising a String for saving the inputs
        String[] values = new String[3]; //Declaring an array for saving initial test values
        int arrival = 0; //Initialising a variable for saving each car arrival
        int index = 0;
        int waiting = 1;
        int arrivalTime = 0;
        int trips = 0;
        int n = 0; //Initialising a variable for saving the ferry capacity
        int t = 0; //Initialising a variable for saving the time that the ferry takes to go from one side to another
        int m = 0; //Initialising a variable for the cars to be transported
        for (int i = 0; i < c; i++) { //A loop for doing the number of test cases given in the first input line
            test = scan.nextLine(); //Reads the test lines containing info about the ferry load, the travel time and cars to be moved
            if (test.length() >= 5) { //Just to make sure: this line checks if the line being read is the initial line of a test
                values = test.split(" "); //Array receiving elements in the test declaration separated with a space
            }
            n = Integer.parseInt(values[0]); //Parsing n input n to integer
            t = Integer.parseInt(values[1]); //Parsing t input to integer
            m = Integer.parseInt(values[2]); //Parsing m input to integer
            for (int j = 0; j < m; j++) { //Loop for putting cars in a queue ordered depending on the arrival to terminal
                arrival = Integer.parseInt(scan.nextLine()); //Reading and parsing each car inputed
                cars.addLast(arrival);
            }
            System.out.println(solution(n, t, m, cars, index, waiting, arrivalTime, trips)); //Printing the solution for a test case
            cars.clear();
        }
    }

    public static double solution(int n, int t, int m, LinkedList<Integer> cars, int index, int waiting, int arrivalTime, int trips) {
        double sol1 = 0;
        double sol2 = 0;
        if (index < (m-1)) {
            sol1 = solution(n, t, m, cars, index + 1, 1 + waiting - (Math.min(waiting, n)), (Math.max(arrivalTime, cars.get(index))) + (t * 2), trips + 1);
            sol2 = solution(n, t, m, cars, index + 1, waiting + 1, arrivalTime, trips);
            return Math.min(sol1, sol2);
        } else {
            if (waiting == 0) {
                return Double.parseDouble((arrivalTime - t) + "." + trips);
            } else {
                return solution(n, t, m, cars, index, waiting - (Math.min(waiting, n)), (Math.max(arrivalTime, cars.get(index))) + (t * 2), trips + 1);
            }
        }
    }
}
