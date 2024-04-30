import java.util.LinkedList;
public class BoundedPriorityQueue extends LinkedList<Appointment> {

    private LinkedList<Appointment> queue;

    private final int maxSize;
    private final String doctor;



    public BoundedPriorityQueue(int maxSize, String doctor) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
        this.doctor = doctor;

    }


    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }



    public boolean isFull() {
        return queue.size() == maxSize;
    }


    public boolean offer(Appointment appointment){
        if(isFull()){
            return false;
        }
        queue.add(appointment);
        return true;
    }



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
