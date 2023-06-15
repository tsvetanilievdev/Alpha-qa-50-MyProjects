package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.AddProductToCategoryCommand;
import com.company.oop.cosmetics.commands.CreateCategoryCommand;
import com.company.oop.cosmetics.commands.CreateProductCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AddProductToCategoryCommandTests {
    private ProductRepositoryImpl productRepository;
    private CreateCategoryCommand createCategoryCommand;
    private CreateProductCommand createProductCommand;
    private AddProductToCategoryCommand addProductToCategoryCommand;
    private ArrayList<String> list;

    @BeforeEach
    public void initFields(){
        productRepository = new ProductRepositoryImpl();
        addProductToCategoryCommand = new AddProductToCategoryCommand(productRepository);
        createCategoryCommand = new CreateCategoryCommand(productRepository);
        createProductCommand = new CreateProductCommand(productRepository);
        list = new ArrayList<>();
    }
    @Test
    public void execute_Should_AddProductToCategory_When_ValidParameters(){
        String categoryName = "top";
        ArrayList<String> categoryList = new ArrayList<>();
        categoryList.add(categoryName);
        createCategoryCommand.execute(categoryList);

        ArrayList<String> productList = new ArrayList<>();
        String productName = "t-shirt";
        String productBrand = "Nike";
        String productPrice = "44.44";
        String productGender = "unisex";
        productList.add(productName);
        productList.add(productBrand);
        productList.add(productPrice);
        productList.add(productGender);
        createProductCommand.execute(productList);

        list.add(categoryName);
        list.add(productName);
        addProductToCategoryCommand.execute(list);

        Assertions.assertEquals(1,productRepository.getProducts().size());
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters(){
        Assertions.assertThrows(InvalidUserInputException.class,() -> addProductToCategoryCommand.execute(list));
    }

}
