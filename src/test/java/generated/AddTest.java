package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.CalculatorOOPS.Add;
import projectTestModify.CalculatorOOPS.Operate;

@ExtendWith(MockitoExtension.class)
public class AddTest {

    @InjectMocks
    private Add add;

    @Mock
    private Double mockNumber;

    @BeforeEach
    void setUp() {
        when(mockNumber).thenReturn(50.0);
        initMocks(this);
    }

    @Test
    void testAddTwoPositiveNumbers() {
        assertAll(
            () -> assertEquals(5.0, add.getResult(2.0, 3.0)),
            () -> assertEquals(0.0, add.getResult())
        );
    }

    @Test
    void testSumWithZeros() {
        assertAll(
            () -> assertEquals(0.0, add.getResult(0.0, 0.0)),
            () -> assertEquals(5.0, add.getResult(0.0, 5.0))
        );
    }

    @Test
    void testNegativeNumbers() {
        assertAll(
            () -> assertEquals(-5.0, add.getResult(-2.0, -3.0)),
            () -> assertEquals(-10.0, add.getResult(-10.0))
        );
    }
}