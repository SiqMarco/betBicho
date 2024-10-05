package services;

import org.example.interfaces.AnimalGroupValidator;
import org.example.interfaces.BetMatcher;
import org.example.services.JogoDoBicho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class JogoDoBichoTest {

    @Mock
    private AnimalGroupValidator animalGroupValidator;

    @Mock
    private BetMatcher betMatcher;

    @InjectMocks
    private JogoDoBicho jogoDoBicho;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidateGame() {
        float betValue = 10.0f;
        int betNumber = 3;
        int betSorted = 3;
        when(betMatcher.getBetMatchLevel(anyInt(), anyInt())).thenReturn(1);
        when(betMatcher.calculateBetValue(anyInt(), anyFloat())).thenReturn(500.00f);
        String result = jogoDoBicho.validateGame(betValue, betNumber, betSorted);
        assertEquals("500.00", result);
    }

    @Test
    void testValidateGame_Fim() {
        float betValue = 0.0f;
        int betNumber = 0;
        int betSorted = 0;
        String result = jogoDoBicho.validateGame(betValue, betNumber, betSorted);
        assertEquals("Fim", result);
    }

    @Test
    void testValidateGame_ReturnsZeroString_WhenBetSortedIsZeros() {
        float betValue = 10.0f;
        int betNumber = 1;
        int betSorted = 0;
        String result = jogoDoBicho.validateGame(betValue, betNumber, betSorted);
        assertEquals("0.00", result);
    }

    @Test
    void testValidateGame_ReturnsZeroString_WhenBetNumberIsZeros() {
        float betValue = 10.0f;
        int betNumber = 0;
        int betSorted = 10;
        String result = jogoDoBicho.validateGame(betValue, betNumber, betSorted);
        assertEquals("0.00", result);
    }

    @Test
    void testValidateGame_ReturnsZeroString_WhenBetValueIsZeros() {
        float betValue = 0f;
        int betNumber = 1;
        int betSorted = 10;
        String result = jogoDoBicho.validateGame(betValue, betNumber, betSorted);
        assertEquals("0.00", result);
    }

    @Test
    void testValidateGame_ReturnsZeroString_WhenBetValueAndNumberAreZeros() {
        float betValue = 0f;
        int betNumber = 0;
        int betSorted = 10;
        String result = jogoDoBicho.validateGame(betValue, betNumber, betSorted);
        assertEquals("0.00", result);
    }

    @Test
    void testValidateGame_ValidateAnimalGroup() {
        float betValue = 100.0f;
        int betNumber = 1;
        int betSorted = 2;
        when(betMatcher.getBetMatchLevel(betNumber, betSorted)).thenReturn(0);
        when(betMatcher.calculateBetValue(1, betValue)).thenReturn(0.0f);
        when(animalGroupValidator.validateAnimalGroup(betValue, betNumber, betSorted)).thenReturn(1600.0f);
        String result = jogoDoBicho.validateGame(betValue, betNumber, betSorted);
        assertEquals("1600.00", result);
    }

}
