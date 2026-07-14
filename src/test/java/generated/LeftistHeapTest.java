import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import projectTestModify.heap.LeftistHeap;

@TestInstance(Lifecycle.PER_METHOD)
public class LeftistHeapExtractMinTest {

    @InjectMocks
    private LeftistHeap heap;

    @Mock
    private Node mockNode;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        heap = new LeftistHeap();
    }

    @Test
    void test_extractMin_emptyHeap() {
        int result = heap.extract_min();
        assertEquals(-1, result);
        assertTrue(heap.isEmpty());
    }

    @Test
    void test_extractMin_singleElement() {
        heap.insert(5);
        int result = heap.extract_min();
        assertEquals(5, result);
        assertTrue(heap.isEmpty());
    }

    @Test
    void test_extractMin_multipleElements() {
        heap.insert(3);
        heap.insert(1);
        heap.insert(2);

        // Extract first minimum (1)
        int firstExtract = heap.extract_min();
        assertEquals(1, firstExtract);

        // Heap should now have 2 and 3
        assertFalse(heap.isEmpty());

        // Extract second minimum (2)
        int secondExtract = heap.extract_min();
        assertEquals(2, secondExtract);
        assertFalse(heap.isEmpty());

        // Insert another element (4) to test further extraction
        heap.insert(4);

        // Extract third minimum (3)
        int thirdExtract = heap.extract_min();
        assertEquals(3, thirdExtract);
        assertFalse(heap.isEmpty());

        // Heap should now have 4
        // Extract last element (4)
        int fourthExtract = heap.extract_min();
        assertEquals(4, fourthExtract);
        assertTrue(heap.isEmpty());
    }

    private static class Node {
        int element;
        int npl;
        Node left;
        Node right;

        Node(int element) {
            this.element = element;
            npl = 0;
            left = right = null;
        }
    }
}