package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateCategoryCommand;
import com.company.oop.cosmetics.commands.ShowCategoryCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShowCategoryCommandTests {
    private ProductRepositoryImpl productRepository;
    private CreateCategoryCommand createCategoryCommand;
    private ShowCategoryCommand showCategoryCommand;
    private ArrayList<String> list;

    @BeforeEach
    public void initFields(){
        productRepository = new ProductRepositoryImpl();
        createCategoryCommand = new CreateCategoryCommand(productRepository);
        showCategoryCommand = new ShowCategoryCommand(productRepository);
        list = new ArrayList<>();
    }
    @Test
    public void execute_Should_ShowCategory_When_ValidParameter(){
        String categoryName = "top";
        ArrayList<String> categoryList = new ArrayList<>();
        categoryList.add(categoryName);
        createCategoryCommand.execute(categoryList);

        list.add(categoryName);
        String expectedString = String.format("#Category: %s%n #No product in this category", categoryName);

        String printString = showCategoryCommand.execute(list);

        Assertions.assertEquals(expectedString, printString);
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameter(){
        Assertions.assertThrows(InvalidUserInputException.class, () -> showCategoryCommand.execute(list));
    }
}
