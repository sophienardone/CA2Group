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


        String userChoice = null;


        do {
            menuOptions();
            System.out.println("Enter your choice");
            String choice = sc.next();
            switch (choice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        } while (true);






    }

    public static void menuOptions() {
        System.out.println("Choose an option:");
        System.out.println("1. Add a new patient");
        System.out.println("2. Delete a patient");
        System.out.println("3. Display all patients");
        System.out.println("4. Create a new appointment for a specific patient");
        System.out.println("5. Call the next patient in for a specified doctor");
        System.out.println("6. Exit");
    }




}
