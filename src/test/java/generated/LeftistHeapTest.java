package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.heap.LeftistHeap;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeftistHeapTest {

    private LeftistHeap leftistHeap;

    @BeforeEach
    public void setUp() {
        leftistHeap = new LeftistHeap();
    }

    @Test
    public void testInsertAndExtractMin() {
        leftistHeap.insert(5);
        leftistHeap.insert(3);
        leftistHeap.insert(8);

        assertEquals(3, leftistHeap.extract_min());
        assertEquals(5, leftistHeap.extract_min());
        assertEquals(8, leftistHeap.extract_min());
        assertEquals(-1, leftistHeap.extract_min()); // Should return -1 for empty heap
    }

    @Test
    public void testMerge() {
        LeftistHeap otherHeap = new LeftistHeap();
        otherHeap.insert(2);
        otherHeap.insert(7);

        leftistHeap.merge(otherHeap);

        ArrayList<Integer> inOrderList = leftistHeap.in_order();
        assertEquals(new ArrayList<>(List.of(2, 5, 7, 8)), inOrderList);
    }

    @Test
    public void testClear() {
        leftistHeap.insert(10);
        leftistHeap.clear();

        assertTrue(leftistHeap.isEmpty());
        assertEquals(-1, leftistHeap.extract_min()); // Should return -1 for empty heap
    }
}