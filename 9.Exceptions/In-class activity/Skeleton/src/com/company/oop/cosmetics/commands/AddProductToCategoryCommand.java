package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.InvalidInputException;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class AddProductToCategoryCommand implements Command {

    private static final int COUNT_OF_LIST_PARAMETERS = 2;
    private static final String PRODUCT_ADDED_TO_CATEGORY = "Product %s added to category %s!";

    private final ProductRepository productRepository;

    public AddProductToCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        try {
            ValidationHelpers.validateListCount(parameters.size(),COUNT_OF_LIST_PARAMETERS);
            String categoryNameToAdd = parameters.get(0);
            String productNameToAdd = parameters.get(1);

            return addProductToCategory(categoryNameToAdd, productNameToAdd);
        }catch (InvalidInputException e){
            return String.format(String.format("AddProduct command expects %s parameters.",COUNT_OF_LIST_PARAMETERS));
        }


    }

    private String addProductToCategory(String categoryName, String productName) {
        Category category = productRepository.findCategoryByName(categoryName);
        Product product = productRepository.findProductByName(productName);

        category.addProduct(product);

        return String.format(PRODUCT_ADDED_TO_CATEGORY, productName, categoryName);
    }

}
