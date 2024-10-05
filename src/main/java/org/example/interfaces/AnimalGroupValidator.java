package org.example.interfaces;

/**
 * Interface for validating an animal group in a betting system.
 * Used to verify and calculate the bet value based on the animal group.
 */
public interface AnimalGroupValidator {
    float validateAnimalGroup(float betValue, int betNumber, int betSorted);
}
