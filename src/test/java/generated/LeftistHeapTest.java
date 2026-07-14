package generated;

import projectTestModify.heap.LeftistHeap;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class LeftistHeapTest {

    private LeftistHeap heap;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        heap = new LeftistHeap();
    }

    @org.junit.jupiter.api.Test
    public void testExtractMin() {
        heap.insert(3);
        heap.insert(1);
        heap.insert(2);

        int min = heap.extract_min();
        assertEquals(1, min);

        min = heap.extract_min();
        assertEquals(2, min);

        min = heap.extract_min();
        assertEquals(3, min);

        assertTrue(heap.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testExtractMinEmptyHeap() {
        int min = heap.extract_min();
        assertEquals(-1, min);
    }

    @org.junit.jupiter.api.Test
    public void testInsertAndExtractMin() {
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);

        int min = heap.extract_min();
        assertEquals(2, min);

        min = heap.extract_min();
        assertEquals(5, min);

        min = heap.extract_min();
        assertEquals(8, min);

        assertTrue(heap.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testExtractMinAfterMerge() {
        LeftistHeap otherHeap = new LeftistHeap();
        otherHeap.insert(4);
        otherHeap.insert(6);

        heap.merge(otherHeap);

        int min = heap.extract_min();
        assertEquals(4, min);

        min = heap.extract_min();
        assertEquals(5, min);

        min = heap.extract_min();
        assertEquals(6, min);

        assertTrue(heap.isEmpty());
    }
}