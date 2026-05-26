package generated;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class LeftistHeapTest {

    @Test
    public void testInsertAndExtractMin() {
        LeftistHeap heap = new LeftistHeap();
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);

        assertEquals(3, heap.extract_min());
        assertEquals(5, heap.extract_min());
        assertEquals(8, heap.extract_min());
        assertEquals(-1, heap.extract_min()); // Test empty heap case
    }

    @Test
    public void testMerge() {
        LeftistHeap heap1 = new LeftistHeap();
        heap1.insert(4);
        heap1.insert(6);

        LeftistHeap heap2 = new LeftistHeap();
        heap2.insert(2);
        heap2.insert(7);

        heap1.merge(heap2);

        ArrayList<Integer> inOrder = heap1.in_order();
        assertEquals(List.of(2, 4, 6, 7), inOrder);
    }

    @Test
    public void testIsEmpty() {
        LeftistHeap heap = new LeftistHeap();
        assertTrue(heap.isEmpty());

        heap.insert(10);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testClear() {
        LeftistHeap heap = new LeftistHeap();
        heap.insert(9);
        heap.insert(2);

        heap.clear();
        assertTrue(heap.isEmpty());
    }
}