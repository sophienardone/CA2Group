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
                    addPatient(sc);
                    break;
                case "2":
                    deletePatient(sc);
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

    private static void addPatient(Scanner sc) {
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter date of birth: ");
        LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());

        Patient newPatient = new Patient(firstName, lastName, dateOfBirth, null, null);

        boolean existingPatient = false;

        for (LinkedList<Patient> doctorQueue : doctorsQueue) {
            for (Patient patient : doctorQueue) {
                if (patient.getFirstName().equalsIgnoreCase(firstName) &&
                        patient.getLastName().equalsIgnoreCase(lastName) && patient.getDateOfBirth().equals(dateOfBirth)) {
                    existingPatient = true;
                    break;
                }
            }
        }

        if (existingPatient) {
            System.out.println("Patient with the same details already exists in the practice.");
        } else {
            for (LinkedList<Patient> doctorQueue : doctorsQueue) {
                if (doctorQueue.size() < upperBound) {
                    doctorQueue.add(newPatient);
                    System.out.println("Patient added successfully.");
                    return;
                }
            }
            System.out.println("All doctor queues are full. Patient could not be added.");
        }


    }


    private static void deletePatient(Scanner sc) {
        System.out.print("Enter first name of the patient to delete: ");
        String firstName = sc.nextLine();

        System.out.print("Enter last name of the patient to delete: ");
        String lastName = sc.nextLine();

        System.out.print("Enter date of birth of the patient to delete (yyyy-mm-dd): ");
        LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());

        boolean patientFound = false;


        for (LinkedList<Patient> doctorQueue : doctorsQueue) {

            for (Patient patient : doctorQueue) {
                if (patient.getFirstName().equalsIgnoreCase(firstName) &&
                        patient.getLastName().equalsIgnoreCase(lastName) &&
                        patient.getDateOfBirth().equals(dateOfBirth)) {
                    doctorQueue.remove(patient);
                    patientFound = true;

                    for (Appointment appointment : patient.getAppointments()) {
                        if (appointment.getDate().isAfter(LocalDate.now())) {
                            System.out.println("Canceled appointment for " + appointment.getFirstName() +
                                    appointment.getLastName() + " scheduled on " + appointment.getDate());
                            patient.getAppointments().remove(appointment);
                        } else {
                            System.out.println("Cannot cancel appointment for " + appointment.getFirstName() +
                                    appointment.getLastName() + " scheduled on " + appointment.getDate() + ". It is already past.");
                        }
                    }
                    System.out.println("Patient removed successfully.");
                    return;
                }
            }
        }

        if (!patientFound) {
            System.out.println("Patient not found in the practice.");
        }
    }


}
