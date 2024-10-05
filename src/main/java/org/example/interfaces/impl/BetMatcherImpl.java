package org.example.interfaces.impl;

import static org.example.utils.Common.hundred;
import static org.example.utils.Common.zero;

import org.example.interfaces.BetMatcher;
import org.springframework.stereotype.Component;

/**
 * Implementation of the BetMatcher interface. This class provides
 * methods to match bet levels and calculate bet values based on
 * specified criteria.
 */
@Component
public class BetMatcherImpl implements BetMatcher {
    private static final int betMax = 3;
    private static final int betMedium = 2;
    private static final int betMin = 1;
    private static final int maxValue = 3000;
    private static final int mediumValue = 500;
    private static final int minValue = 50;
    private static final int tenThousand = 10000;
    private static final int thousand = 1000;

    @Override
    public int getBetMatchLevel(final int betNum, final int betSorted) {
        if (betNum % tenThousand == betSorted % tenThousand) {
            return betMax;
        }
        if (betNum % thousand == betSorted % thousand) {
            return betMedium;
        }
        if (betNum % hundred == betSorted % hundred) {
            return betMin;
        }
        return zero;
    }

    @Override
    public float calculateBetValue(final int matchLevel, final float betValue) {
        switch (matchLevel) {
            case betMin -> {
                return minValue * betValue;
            }
            case betMedium -> {
                return mediumValue * betValue;
            }
            case betMax -> {
                return maxValue * betValue;
            }
            default -> {
                return zero;
            }
        }
    }
}
