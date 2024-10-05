package inteface.impl;

import static org.example.utils.Common.zero;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.example.interfaces.impl.AnimalGroupValidatorImpl;
import org.example.utils.Common;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnimalGroupValidatorImplTest {

    private AnimalGroupValidatorImpl animalGroupValidator;

    @BeforeEach
    void setUp() {
        animalGroupValidator = new AnimalGroupValidatorImpl();
    }

    @Test
    void testValidateAnimalGroup_SameGroup_ShouldReturnValidBet() {

        float betValue = 100.0f;
        int betNumber = 24;
        int sortedNumber = 21;
        float result = animalGroupValidator.validateAnimalGroup(betValue, betNumber, sortedNumber);
        assertEquals(betValue * 16, result);
    }

    @Test
    void testValidateAnimalGroup_DifferentGroup_ShouldReturnZero() {
        float betValue = 100.0f;
        int betNumber = 24;
        int sortedNumber = 28;
        float result = animalGroupValidator.validateAnimalGroup(betValue, betNumber, sortedNumber);
        assertEquals(zero, result);
    }

    @Test
    void testIsSameAnimalGroup_TrueForBoundaryCases() {
        float betValue = 100.0f;
        int betNumber = 97;
        int sortedNumber = 100;

        float result = animalGroupValidator.validateAnimalGroup(betValue, betNumber, sortedNumber);

        assertEquals(betValue * 16, result);
    }
}

