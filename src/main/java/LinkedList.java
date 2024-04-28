public class LinkedList {

    //Fields
    private Node head;

    private Node tail;

    private int numberOfAppointments;

    protected final int maxSize;


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


    public void add(Appointment app){
        //create a new node with appointment
        Node newNode = new Node(app);
        //if linked list is empty, new node is set as head
        if(head == null){
            head = newNode;
        }else{
            //otherwise, new node is set as the next node of the tail
            tail.next = newNode;
        }
        //new node is now the new tail
        tail = newNode;
        //numberOfAppointments is incremented
        numberOfAppointments++;
    }

    public void remove(Appointment app){
        //current node is initialized as head and previous node as null
        Node current = head;
        Node prev = null;
        while (current != null){
            //if the app of the current node matches the given appointment
            if(current.data.equals(app)){
                //if previous node is null, update head
                if(prev == null){
                    head = current.next;
                }
                numberOfAppointments++;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void displayAllApps(){
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            //moves to the next node
            current = current.next;
        }
    }


    public int indexOf(Appointment app){
        Node current = head;
        int index =0;
        while(current != null){
            if(current.data.equals(app)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public Appointment get(int index) {
        if (index < 0 || index >= numberOfAppointments) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        //return appointment data at the specified index
        return current.data;
    }




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
