package generated;

import projectTestModify.heap.LeftistHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class LeftistHeapTest {

    private LeftistHeap leftistHeap;

    @BeforeEach
    public void setup() {
        leftistHeap = new LeftistHeap();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(leftistHeap.isEmpty());
        leftistHeap.insert(1);
        assertFalse(leftistHeap.isEmpty());
    }

    @Test
    public void testClear() {
        leftistHeap.insert(2);
        leftistHeap.clear();
        assertTrue(leftistHeap.isEmpty());
    }

    @Test
    public void testMerge() {
        LeftistHeap heap1 = new LeftistHeap();
        heap1.insert(3);
        leftistHeap.insert(4);
        leftistHeap.merge(heap1);
        assertEquals(3, leftistHeap.extract_min());
    }

    @Test
    public void testInsert() {
        leftistHeap.insert(5);
        assertFalse(leftistHeap.isEmpty());
    }

    @Test
    public void testExtractMin() {
        leftistHeap.insert(6);
        assertEquals(6, leftistHeap.extract_min());
        assertTrue(leftistHeap.isEmpty());
        assertEquals(-1, leftistHeap.extract_min());
    }

    @Test
    public void testInOrder() {
        leftistHeap.insert(7);
        leftistHeap.insert(6);
        leftistHeap.insert(8);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(7);
        expected.add(8);
        assertEquals(expected, leftistHeap.in_order());
    }
}