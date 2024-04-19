public class LinkedList {

    //Fields
    private Node head;

    private Node tail;

    private int numberOfAppointments;







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
