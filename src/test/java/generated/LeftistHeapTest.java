package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.heap.LeftistHeap;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class LeftistHeapTest {

    private LeftistHeap heap;

    @BeforeEach
    void setUp() {
        heap = new LeftistHeap();
    }

    @Test
    void testExtractMin() {
        // Given
        heap.insert(5);
        heap.insert(2);
        heap.insert(7);

        // When
        int min = heap.extract_min();

        // Then
        assertEquals(2, min);
    }

    @Test
    void testExtractMinEmptyHeap() {
        // When
        int min = heap.extract_min();

        // Then
        assertEquals(-1, min);
    }

    @Test
    void testInOrderTraversal() {
        // Given
        heap.insert(5);
        heap.insert(2);
        heap.insert(7);

        // When
        ArrayList<Integer> inOrder = heap.in_order();

        // Then
        assertEquals(new ArrayList<>(Arrays.asList(2, 5, 7)), inOrder);
    }
}