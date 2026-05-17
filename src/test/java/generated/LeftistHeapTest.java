package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeftistHeapTest {

    private LeftistHeap heap;

    @BeforeEach
    public void setUp() {
        heap = new LeftistHeap();
    }

    @Test
    public void testInsertAndExtractMin() {
        heap.insert(3);
        heap.insert(1);
        heap.insert(2);

        assertEquals(1, heap.extract_min());
        assertEquals(2, heap.extract_min());
        assertEquals(3, heap.extract_min());
    }

    @Test
    public void testIsEmptyAfterClear() {
        heap.insert(5);
        heap.clear();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testExtractMinFromEmptyHeap() {
        assertEquals(-1, heap.extract_min());
    }
}