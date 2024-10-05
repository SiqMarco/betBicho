package org.example.interfaces;

/**
 * Interface for matching and calculating bet values based on specified criteria.
 */
public interface BetMatcher {
    int getBetMatchLevel(int betNumber, int betSorted);
    float calculateBetValue(int matchLevel, float betValue);
}
