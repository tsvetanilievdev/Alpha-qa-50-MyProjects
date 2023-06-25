package com.company.oop.cosmetics.utils;

import com.company.oop.cosmetics.commands.CommandType;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.InvalidInputException;
import com.company.oop.cosmetics.models.GenderType;

public class ValidationHelpers {

    public static void validateIntegerRange(String property, String input, int minLength, int maxLength) {
        if (input.length() < minLength || input.length() > maxLength) {
            throw new InvalidInputException(String.format("%s should be between %d and %d symbols.", property, minLength, maxLength));
        }
    }

    public static void validatePositiveNumber(String property, double value) {
        if (value < 0) {
            throw new InvalidInputException(String.format("%s can't be negative.", property));
        }
    }

    public static void validateListCount(int size, int mustCount) {
        if (size != mustCount) {
            throw new InvalidInputException("The size of the list of parameters must be exactly %d");
        }
    }

    public static void validateProductNameIsUnique(ProductRepository repository, String name) {
        if (repository.findProductByName(name) != null) {
            throw new InvalidInputException(String.format("Product %s already exist.", name));
        }
    }

    public static void validateCategoryNameIsUnique(ProductRepository repository, String name) {
        if (repository.findCategoryByName(name) != null) {
            throw new InvalidInputException(String.format("Category %s already exist", name));
        }
    }

    public static double validateValueIsDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public static GenderType validateGenderType(String genderType) {
        try {
            return GenderType.valueOf(genderType.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new InvalidInputException("Forth parameter should be one of Men, Women or Unisex.");
        }
    }

    public static CommandType validateCommandType(String commandType) {
        try {
            return CommandType.valueOf(commandType.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new InvalidInputException(String.format("Command %s is not supported.", commandType));
        }
    }

}
