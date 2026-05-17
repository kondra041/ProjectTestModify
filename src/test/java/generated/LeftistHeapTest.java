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
    public void testIsEmptyInitially() {
        assertTrue(leftistHeap.isEmpty());
    }

    @Test
    public void testInsertAndExtractMin() {
        leftistHeap.insert(10);
        assertEquals(10, leftistHeap.extract_min());

        leftistHeap.insert(20);
        leftistHeap.insert(5);
        assertEquals(5, leftistHeap.extract_min());
        assertEquals(10, leftistHeap.extract_min());
        assertEquals(20, leftistHeap.extract_min());
    }

    @Test
    public void testExtractMinFromEmptyHeap() {
        assertEquals(-1, leftistHeap.extract_min());
    }

    @Test
    public void testInOrderTraversal() {
        leftistHeap.insert(3);
        leftistHeap.insert(1);
        leftistHeap.insert(4);
        leftistHeap.insert(2);

        ArrayList<Integer> inOrder = leftistHeap.in_order();
        assertEquals(new ArrayList<>(List.of(1, 2, 3, 4)), inOrder);
    }

    @Test
    public void testMerge() {
        LeftistHeap heap1 = new LeftistHeap();
        heap1.insert(5);
        heap1.insert(7);

        LeftistHeap heap2 = new LeftistHeap();
        heap2.insert(3);
        heap2.insert(6);

        leftistHeap.merge(heap1);
        leftistHeap.merge(heap2);

        ArrayList<Integer> inOrder = leftistHeap.in_order();
        assertEquals(new ArrayList<>(List.of(3, 5, 6, 7)), inOrder);
    }

    @Test
    public void testClear() {
        leftistHeap.insert(10);
        leftistHeap.clear();

        assertTrue(leftistHeap.isEmpty());
    }
}