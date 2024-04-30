import java.util.LinkedList;
public class BoundedPriorityQueue extends LinkedList<Appointment> {

    // Queue to store appointments
    private LinkedList<Appointment> queue;

    //maximum size of queue
    private final int maxSize;

    //doctor associated with the queue
    private final String doctor;



   //constructor
    public BoundedPriorityQueue(int maxSize, String doctor) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
        this.doctor = doctor;

    }



    // Override size method to return the size of the queue
    @Override
    public int size() {
        return queue.size();
    }


    // Override isEmpty method to check if the queue is empty
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }


    // Method to check if the queue is full
    public boolean isFull() {
        return queue.size() == maxSize;
    }


    /**
     * Adds an appointment to the queue
     * @param appointment the element to add
     * @return true if it was added sucessfully, false otherwise
     */
    public boolean offer(Appointment appointment){
        if(isFull()){
            return false;
        }
        queue.add(appointment);
        return true;
    }


    /**
     * adds an appointment to the queue in a fail-fast way
     * @param appointment An appointment object to be added to the queue
     */

    public void failFastAdd(Appointment appointment) {

        if (size() >= maxSize ) {
            throw new IllegalStateException("Queue is full");
        }
        if(!appointment.getDocFullName().equalsIgnoreCase(doctor)){
            throw new IllegalArgumentException("Appointment doctor does not match queue doctor");
        }
        queue.add(appointment);
    }















}
