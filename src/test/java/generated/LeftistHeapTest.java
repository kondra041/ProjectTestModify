import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.heap.LeftistHeap;

class LeftistHeapTest {

    private LeftistHeap heap;

    @BeforeEach
    void setUp() {
        heap = new LeftistHeap();
    }

    @Test
    void testInsertWhenEmpty() {
        heap.insert(5);
        assertEquals(5, heap.extract_min());
        assertTrue(heap.isEmpty());
    }

    @Test
    void testMultipleInserts() {
        heap.insert(3);
        heap.insert(1);
        heap.insert(4);
        
        assertEquals(1, heap.extract_min());
        assertEquals(3, heap.extract_min());
        assertEquals(4, heap.extract_min());
        assertTrue(heap.isEmpty());
    }

    @Test
    void testInOrderTraversal() {
        heap.insert(2);
        heap.insert(5);
        heap.insert(3);
        
        ArrayList<Integer> inOrder = heap.in_order();
        assertEquals(2, inOrder.get(0));
        assertEquals(3, inOrder.get(1));
        assertEquals(5, inOrder.get(2));
    }

    @Test
    void testClear() {
        heap.insert(1);
        heap.insert(2);
        heap.clear();
        assertTrue(heap.isEmpty());
    }
}