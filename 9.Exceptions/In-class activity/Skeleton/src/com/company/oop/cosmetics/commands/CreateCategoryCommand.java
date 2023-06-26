package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.exceptions.InvalidInputException;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateCategoryCommand implements Command {
    private static final int COUNT_OF_LIST_PARAMETERS = 1;
    private static final String CATEGORY_CREATED = "Category with name %s was created!";

    private final ProductRepository productRepository;

    public CreateCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        try {
            ValidationHelpers.validateListCount(parameters.size(), COUNT_OF_LIST_PARAMETERS);
        } catch (InvalidInputException e) {
            return String.format("Product %s",e.getMessage());
        }
        String categoryName = parameters.get(0);
        return createCategory(categoryName);
    }

    private String createCategory(String categoryName) {
        if(!ValidationHelpers.validateCategoryNameIsUnique(productRepository, categoryName)){
            throw new InvalidInputException(String.format("Category %s already exist.", categoryName));
        }

        productRepository.createCategory(categoryName);

        return String.format(CATEGORY_CREATED, categoryName);
    }

}
