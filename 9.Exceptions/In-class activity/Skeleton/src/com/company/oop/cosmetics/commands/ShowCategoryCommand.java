package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.exceptions.InvalidInputException;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class ShowCategoryCommand implements Command {
    private static final int COUNT_OF_LIST_PARAMETERS = 1;

    private final ProductRepository productRepository;

    public ShowCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        try {
            ValidationHelpers.validateListCount(parameters.size(), COUNT_OF_LIST_PARAMETERS);
            String categoryName = parameters.get(0);
            return showCategory(categoryName);
        }catch (InvalidInputException e){
            return e.getMessage();
        }
    }

    private String showCategory(String categoryName) {
        Category category = productRepository.findCategoryByName(categoryName);

        return category.print();
    }

}
