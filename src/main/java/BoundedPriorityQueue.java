public class BoundedPriorityQueue extends LinkedList {

    private final String doctor;



    public BoundedPriorityQueue(int maxSize, String doctor) {
        super(maxSize);
        this.doctor = doctor;

    }

    public boolean safeAdd(Appointment appointment){
        if(size() < maxSize && appointment.getDocFullName().equalsIgnoreCase(doctor)){
            add(appointment);
            return true;
        } else {
            return false;
        }
    }

    public void failFastAdd(Appointment appointment) {
        if (size() >= maxSize ) {
            throw new IllegalStateException("Queue is full");
        }
        if(!appointment.getDocFullName().equalsIgnoreCase(doctor)){
            throw new IllegalArgumentException("Appointment doctor does not match queue doctor");
        }
        add(appointment);
    }







}
