public class LinkedList {

    //Fields
    private Node head;

    private Node tail;

    private int numberOfAppointments;

    private final int maxSize;


    //Constructor
    public LinkedList(){
    this.head = null;
    this.tail = null;
    this.numberOfAppointments = 0;
    this.maxSize = 10;
    }

    //Constructor that accepts a maximum size
    public LinkedList(int maxSize) {
        this.head = null;
        this.tail = null;
        this.numberOfAppointments = 0;
        this.maxSize = maxSize;
    }

    public int size(){return numberOfAppointments;}


    public boolean isEmpty(){
        if (numberOfAppointments == 0) return true;
        else return false;
    }

    public boolean isFull(){ return numberOfAppointments == maxSize;}









    protected static class Node {

        private Appointment data;
        private Node next;

        public Node(Appointment data) {
            this.data = data;
            this.next = null;
        }

        //Getters and Setters


        public Appointment getData() {
            return data;
        }

        public void setData(Appointment data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
