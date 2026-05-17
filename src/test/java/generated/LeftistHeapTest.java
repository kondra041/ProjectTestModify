package generated;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.heap.LeftistHeap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeftistHeapTest {

    private LeftistHeap heap;

    @BeforeEach
    public void setUp() {
        heap = new LeftistHeap();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testInsertAndExtractMin() {
        heap.insert(5);
        heap.insert(3);
        heap.insert(7);

        assertEquals(3, heap.extract_min());
        assertEquals(5, heap.extract_min());
        assertEquals(7, heap.extract_min());
    }

    @Test
    public void testMergeHeaps() {
        LeftistHeap h1 = new LeftistHeap();
        h1.insert(2);
        h1.insert(4);

        LeftistHeap h2 = new LeftistHeap();
        h2.insert(1);
        h2.insert(3);

        heap.merge(h1);
        heap.merge(h2);

        assertEquals(1, heap.extract_min());
        assertEquals(2, heap.extract_min());
        assertEquals(3, heap.extract_min());
        assertEquals(4, heap.extract_min());
    }

    @Test
    public void testInOrderTraversal() {
        heap.insert(5);
        heap.insert(3);
        heap.insert(7);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);
        expected.add(7);

        assertEquals(expected, heap.in_order());
    }
}