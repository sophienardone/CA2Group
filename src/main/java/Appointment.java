import java.time.LocalDate;

public class Appointment {

    //Fields
    private String firstName;

    private String lastName;

    private LocalDate dob;

    private String issue;

    private LocalDate date;

    private int triageLevel;

    private String docFullName;


   //constructor
    public Appointment(String firstName, String lastName, LocalDate dob, String issue, LocalDate date, int triageLevel, String docFullName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.issue = issue;
        this.date = date;
        this.triageLevel = triageLevel;
        this.docFullName = docFullName;
    }

    //getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel) {
        this.triageLevel = triageLevel;
    }

    public String getDocFullName() {
        return docFullName;
    }

    public void setDocFullName(String docFullName) {
        this.docFullName = docFullName;
    }
}
