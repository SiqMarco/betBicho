package org.example;

import org.example.services.JogoDoBicho;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Main class serves as the entry point for the Spring Boot application.
 * It initializes the application context and demonstrates the usage of
 * the JogoDoBicho service.

 * The main method performs the following steps:
 * - Initializes the application context using SpringApplication.run().
 * - Retrieves the JogoDoBicho bean from the application context.
 * - Defines the bet number, bet value, and sorted number for the game.
 * - Calls the validateGame method of JogoDoBicho to validate the game.
 * - Prints the result of the game validation.
 */
@ComponentScan(basePackages = "org.example")
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Main.class, args);
        JogoDoBicho jogoDoBicho = context.getBean(JogoDoBicho.class);

        final int betNumber = 32;
        final float betValue = 10.5f;
        final int sortedNumber = 213032;

        final String valorPago = jogoDoBicho.validateGame(betValue, betNumber, sortedNumber);

        System.out.println(
                String.format("%.2f", betValue) + " "
                        + String.format("%04d", betNumber) + " "
                        + sortedNumber + " "
                        + "(" + valorPago + ")"
        );
    }
}