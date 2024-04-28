public class BoundedPriorityQueue extends LinkedList {

    private final String doctor;



    public BoundedPriorityQueue(int maxSize, String doctor) {
        super(maxSize);
        this.doctor = doctor;

    }

    public boolean safeAdd(Appointment appointment){
        if(this.size() < maxSize && appointment.getDocFullName().equalsIgnoreCase(doctor)){
            add(appointment);
            return true;
        } else {
            return false;
        }
    }







}
