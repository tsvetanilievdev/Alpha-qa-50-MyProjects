package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.InvalidGenderTypeInputException;
import com.company.oop.cosmetics.exceptions.InvalidInputException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateProductCommand implements Command {
    private static final int COUNT_OF_LIST_PARAMETERS = 4;
    private static final String PRODUCT_CREATED = "Product with name %s was created!";

    private final ProductRepository productRepository;

    public CreateProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {

        try {
            ValidationHelpers.validateListCount(parameters.size(), COUNT_OF_LIST_PARAMETERS);
        } catch (InvalidInputException e) {
            return String.format("CreateProduct %s", e.getMessage());
        }

        try {
            String name = parameters.get(0);
            String brand = parameters.get(1);
            double price = ValidationHelpers.validateValueIsDouble(parameters.get(2));
            GenderType gender = ValidationHelpers.validateGenderType(parameters.get(3));

            return createProduct(name, brand, price, gender);
        } catch (InvalidGenderTypeInputException e) {
            return e.getMessage();
        } catch (InvalidInputException e) {
            return e.getMessage();
        } catch (NumberFormatException e) {
            return "Third parameter should be price (real number).";
        }
    }

    private String createProduct(String name, String brand, double price, GenderType gender) {
        try {
            ValidationHelpers.validateProductNameIsUnique(productRepository, name);
            productRepository.createProduct(name, brand, price, gender);

            return String.format(PRODUCT_CREATED, name);
        } catch (InvalidInputException e) {
            return e.getMessage();
        }
    }

}
