import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapinTest {

    @Test
    public void addOneItem() {
        Heapin hi = new Heapin();
        hi.add(4);

        int peeking = hi.peek();
        int getSize = hi.getSize();
        assertEquals(1, getSize);
        assertEquals(4, peeking);
    }

    @Test
    public void addTwoItems() {
        Heapin hi = new Heapin();
        hi.add(4);
        hi.add(3423);

        int peeking = hi.peek();
        int getSize = hi.getSize();
        assertEquals(2, getSize);
        assertEquals(4, peeking);
    }

    @Test
    public void addMultipleItems() {
        Heapin hi = new Heapin();
        hi.add(49373);
        hi.add(3423);
        hi.add(87422);
        hi.add(134);
        hi.add(49246);
        hi.add(5454);

        int peeking = hi.peek();
        int getSize = hi.getSize();
        assertEquals(6, getSize);
        assertEquals(134, peeking);
    }

}