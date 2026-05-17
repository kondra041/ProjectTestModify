import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.heap.LeftistHeap;
import projectTestModify.heap.LeftistHeap.Node;

@ExtendWith(MockitoExtension.class)
public class LeftistHeapTest {

    @InjectMocks
    private LeftistHeap heap;

    @Test
    void testExtractMin() {
        Node mockRoot = mock(Node.class);
        when(mockRoot.left).thenReturn(null);
        when(mockRoot.right).thenReturn(null);
        doReturn(5).when(mockRoot).getElement();
        
        int result = heap.extract_min();
        assertEquals(5, result);
        verify(mockRoot).left;
        verify(mockRoot).right;
    }

    @Test
    void testInsert() {
        heap.insert(3);
        Node root = heap.root;
        assertAll(
            () -> assertNotNull(root),
            () -> assertEquals(3, root.element),
            () -> assertNull(root.left),
            () -> assertNull(root.right)
        );
    }

    @Test
    void testMerge() {
        LeftistHeap h1 = new LeftistHeap();
        h1.insert(2);
        h1.insert(5);
        
        heap.merge(h1);
        assertAll(
            () -> assertNotNull(heap.root),
            () -> assertEquals(2, heap.root.element),
            () -> assertEquals(5, heap.root.right.element)
        );
    }

    @Test
    void testExtractMinMultipleElements() {
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        
        int first = heap.extract_min();
        int second = heap.extract_min();
        
        assertEquals(2, first);
        assertEquals(3, second);
    }

    @Test
    void testClear() {
        heap.insert(5);
        heap.clear();
        
        assertTrue(heap.isEmpty());
    }

    @Test
    void testInOrderTraversal() {
        heap.insert(1);
        heap.insert(3);
        heap.insert(2);
        
        ArrayList<Integer> traversal = heap.in_order();
        assertAll(
            () -> assertEqualsSize(3, traversal),
            () -> assertEquals(List.of(1, 2, 3), traversal)
        );
    }

    @Test
    void testIsEmpty() {
        assertTrue(heap.isEmpty());
        heap.insert(5);
        assertFalse(heap.isEmpty());
    }
}