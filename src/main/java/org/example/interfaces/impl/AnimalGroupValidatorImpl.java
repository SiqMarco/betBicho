package org.example.interfaces.impl;

import static org.example.utils.Common.hundred;
import static org.example.utils.Common.zero;

import org.example.interfaces.AnimalGroupValidator;
import org.springframework.stereotype.Component;

/**
 * Implementation of the AnimalGroupValidator interface. This class provides
 * methods to validate and calculate the bet value based on the animal group.
 */
@Component
public class AnimalGroupValidatorImpl implements AnimalGroupValidator {
    private static final int four = 4;
    private static final int one = 1;
    private static final int percentGroupValue = 16;


    @Override
    public float validateAnimalGroup(final float betValue, final int betNumber, final int sortedNumber) {
        if (isSameAnimalGroup(betNumber, sortedNumber)) {
            return getBetByGroup(betValue);
        }
        return zero;
    }

    private float getBetByGroup(final float betValue){
        return betValue * percentGroupValue;
    }

    private boolean isSameAnimalGroup(final int betNumber, final int sortedNumber) {
        int betNumberLastTwoDigits = betNumber % hundred;
        int sortedNumberLastTwoDigits = sortedNumber % hundred;
        return getAnimalGroup(betNumberLastTwoDigits) == getAnimalGroup(sortedNumberLastTwoDigits);
    }

    private int getAnimalGroup(int lastTwoDigits) {
        if (lastTwoDigits == zero) {
            lastTwoDigits = hundred;  // 100 is the same as 0
        }
        return (lastTwoDigits - one) / four + one;

    }
}
