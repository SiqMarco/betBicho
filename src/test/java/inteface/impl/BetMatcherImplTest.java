package inteface.impl;

import static org.example.utils.Common.zero;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.interfaces.impl.BetMatcherImpl;
import org.example.utils.Common;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BetMatcherImplTest {

    private BetMatcherImpl betMatcher;

    @BeforeEach
    void setUp() {
        betMatcher = new BetMatcherImpl();
    }

    @Test
    void testGetBetMatchLevel_MaxMatch_ShouldReturnBetMax() {
        int betNum = 123456;
        int betSorted = 123456;
        int result = betMatcher.getBetMatchLevel(betNum, betSorted);
        assertEquals(3, result); // betMax
    }

    @Test
    void testGetBetMatchLevel_MediumMatch_ShouldReturnBetMedium() {
        int betNum = 123456;
        int betSorted = 654456;
        int result = betMatcher.getBetMatchLevel(betNum, betSorted);
        assertEquals(2, result); // betMedium
    }

    @Test
    void testGetBetMatchLevel_MinMatch_ShouldReturnBetMin() {
        int betNum = 123456;
        int betSorted = 654356;
        int result = betMatcher.getBetMatchLevel(betNum, betSorted);
        assertEquals(1, result); // betMin
    }

    @Test
    void testGetBetMatchLevel_NoMatch_ShouldReturnZero() {
        int betNum = 123456;
        int betSorted = 654321;
        int result = betMatcher.getBetMatchLevel(betNum, betSorted);
        assertEquals(zero, result); // zero
    }

    @Test
    void testCalculateBetValue_BetMin_ShouldReturnMinValue() {
        int matchLevel = 1; // betMin
        float betValue = 100.0f;
        float result = betMatcher.calculateBetValue(matchLevel, betValue);
        assertEquals(50 * betValue, result); // minValue * betValue
    }

    @Test
    void testCalculateBetValue_BetMedium_ShouldReturnMediumValue() {
        int matchLevel = 2; // betMedium
        float betValue = 100.0f;
        float result = betMatcher.calculateBetValue(matchLevel, betValue);
        assertEquals(500 * betValue, result); // mediumValue * betValue
    }

    @Test
    void testCalculateBetValue_BetMax_ShouldReturnMaxValue() {
        int matchLevel = 3; // betMax
        float betValue = 100.0f;
        float result = betMatcher.calculateBetValue(matchLevel, betValue);
        assertEquals(3000 * betValue, result); // maxValue * betValue
    }

    @Test
    void testCalculateBetValue_NoMatch_ShouldReturnZero() {
        int matchLevel = 0; // zero
        float betValue = 100.0f;
        float result = betMatcher.calculateBetValue(matchLevel, betValue);
        assertEquals(zero, result); // zero
    }
}

