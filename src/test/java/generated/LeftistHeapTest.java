package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import projectTestModify.heap.LeftistHeap;
import static org.junit.jupiter.api.Assertions.*;

public class LeftistHeapTest {
    private LeftistHeap leftistHeap;

    @BeforeEach
    public void setUp() {
        leftistHeap = new LeftistHeap();
    }

    @Test
    public void testExtractMinEmptyHeap() {
        assertEquals(-1, leftistHeap.extract_min());
    }

    @Test
    public void testExtractMinSingleElementHeap() {
        int element = 5;
        leftistHeap.insert(element);
        assertEquals(element, leftistHeap.extract_min());
        assertTrue(leftistHeap.isEmpty());
    }

    @Test
    public void testExtractMinMultipleElementsHeap() {
        leftistHeap.insert(5);
        leftistHeap.insert(3);
        leftistHeap.insert(8);
        assertEquals(3, leftistHeap.extract_min());
        assertFalse(leftistHeap.isEmpty());
        assertEquals(5, leftistHeap.extract_min());
        assertFalse(leftistHeap.isEmpty());
        assertEquals(8, leftistHeap.extract_in_order().get(0));
    }

    @Test
    public void testInOrderEmptyHeap() {
        assertTrue(leftistHeap.in_order().isEmpty());
    }

    @Test
    public void testInOrderSingleElementHeap() {
        int element = 5;
        leftistHeap.insert(element);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(element);
        assertEquals(expected, leftistHeap.in_order());
    }

    @Test
    public void testInOrderMultipleElementsHeap() {
        leftistHeap.insert(5);
        leftistHeap.insert(3);
        leftistHeap.insert(8);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);
        expected.add(8);
        assertEquals(expected, leftistHeap.in_order());
    }
}