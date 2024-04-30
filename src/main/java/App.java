import java.time.LocalDate;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;


public class App {


    private static LinkedList<Patient>[] doctorsQueue;
    public static int upperBound;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the upper bound for the queue");
        int upperBound = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter number of doctors rostered for the day:");
        int rosteredAmount = sc.nextInt();

        doctorsQueue = new LinkedList[rosteredAmount];
        for (int i = 0; i < rosteredAmount; i++) {
            doctorsQueue[i] = new LinkedList<Patient>();
        }



    }




}
