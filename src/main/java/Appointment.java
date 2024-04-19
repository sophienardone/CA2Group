import java.time.LocalDate;
import java.util.Objects;

public class Appointment implements Comparable<Appointment> {

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

    //equals method

    public boolean equals(Object o) {
        //checks that the current object is the same of the object being compared
        if (this == o) return true;
        //checks if compared object is an instance of 'Appointment' class
        if (!(o instanceof Appointment)) return false;
        //casts Object 'o' to an Appointment object
        Appointment app = (Appointment) o;
        //checks if triageLevel of current Appointment object is equal to triageLevel of Appointment object being compared to
        return triageLevel == app.triageLevel &&
                firstName.equals(app.firstName) &&
                lastName.equals(app.lastName) &&
                dob.equals(app.dob) &&
                issue.equals(app.issue) &&
                date.equals(app.date) &&
                docFullName.equals(app.docFullName);
    }

    //hashcode method


    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dob, issue, date, triageLevel, docFullName);
    }


    //toString method


    @Override
    public String toString() {
        return "Appointment{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", issue='" + issue + '\'' +
                ", date=" + date +
                ", triageLevel=" + triageLevel +
                ", docFullName='" + docFullName + '\'' +
                '}';
    }


    //compareTo method
    public int compareTo(Appointment o) {
        if (this.triageLevel != o.triageLevel) {
            return Integer.compare(this.triageLevel, o.triageLevel);
        } else {
            return this.date.compareTo(o.date);
        }
    }
}
