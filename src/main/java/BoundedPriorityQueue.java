public class BoundedPriorityQueue extends LinkedList {



    private final String doctor;



    public BoundedPriorityQueue(int maxSize, String doctor) {
        super(maxSize);
        this.doctor = doctor;

    }


    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }


    @Override
    public boolean isFull() {
        return super.isFull();
    }


    public boolean offer(Appointment appointment){
        if(isFull()){
            return false;
        }
        super.add(appointment);
        return true;
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
