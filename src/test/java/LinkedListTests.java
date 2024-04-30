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








}
