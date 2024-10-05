package org.example.services;

import static org.example.utils.Common.zero;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.interfaces.AnimalGroupValidator;
import org.example.interfaces.BetMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The JogoDoBicho class represents the core logic for a betting game.
 * It utilizes the AnimalGroupValidator and BetMatcher dependencies
 * to determine the outcome based on the bet value, bet number,
 * and sorted number.

 * This class is annotated with @Data, @Service, and @AllArgsConstructor
 * indicating that it is a Spring-managed service component with
 * automatic constructor injection.
 */
@Data
@Service
@AllArgsConstructor
public class JogoDoBicho {

    @Autowired
    AnimalGroupValidator animalGroupValidator;
    @Autowired
    BetMatcher betMatcher;

    public String validateGame(final float betValue, final int betNumber, final int betSorted) {
        if (hasZeroParameter(betValue, betNumber, betSorted)) {
            return handleZeroParameters(betValue, betNumber, betSorted);
        }

        final int matchLevel = betMatcher.getBetMatchLevel(betNumber, betSorted);

        if(matchLevel == zero){
            final float result = animalGroupValidator.validateAnimalGroup(betValue, betNumber, betSorted);
            return finalResult(result);
        }

        final float result = betMatcher.calculateBetValue(matchLevel, betValue);
        return finalResult(result);
    }

    private boolean hasZeroParameter(float betValue, int betNumber, int betSorted) {
        return betValue == zero || betNumber == zero || betSorted == zero;
    }

    private String handleZeroParameters(float betValue, int betNumber, int betSorted) {
        if (betValue == zero && betNumber == zero && betSorted == zero) {
            return "Fim";
        }
        return "0.00";
    }

    private String finalResult(final float result) {
        return String.format("%.2f",result);
    }

}

