import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class LinkedListTests {


    @Test
    public void testSize_EmptyList() {
        LinkedList instance = new LinkedList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);

    }


    @Test
    public void testSize_PopulatedList() {
        LinkedList instance = new LinkedList();
        Appointment a1 = new Appointment("Saoirse", "McGuinness", LocalDate.of(1999, 22,6), "Checkup", LocalDate.now(), 1, "Dr. Curtain");
        Appointment a2 = new Appointment("Shauna", "Cooney", LocalDate.of(1998, 7, 9), "Bloods", LocalDate.now(), 2, "Dr. McGrath");
        Appointment a3 = new Appointment("Sophie", "Nardone", LocalDate.of(2000, 28, 2), "Checkup", LocalDate.now(), 3, "Dr. McGrath");

        instance.add(a1);
        instance.add(a2);
        instance.add(a3);
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testAdd() {
        LinkedList instance = new LinkedList();
        Appointment a1 = new Appointment("John", "Smith", LocalDate.of(2000, 5, 11), "Checkup", LocalDate.now(), 4, "Dr. Reilly");
        instance.add(a1);
        assertEquals(1, instance.size());
    }









}
