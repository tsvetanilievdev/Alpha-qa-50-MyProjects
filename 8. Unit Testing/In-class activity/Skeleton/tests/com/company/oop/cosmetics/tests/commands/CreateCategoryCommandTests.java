package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateCategoryCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.DuplicateEntityException;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CreateCategoryCommandTests {
    // @BeforeEach may help here
    private ProductRepositoryImpl productRepository;
    private CreateCategoryCommand createCategoryCommand;
    private ArrayList<String> categoryList;

    @BeforeEach
    public void initFields(){
        productRepository = new ProductRepositoryImpl();
        createCategoryCommand = new CreateCategoryCommand(productRepository);
        categoryList = new ArrayList<>();
    }
    @Test
    public void execute_Should_AddNewCategoryToRepository_When_ValidParameters() {
        String categoryName = "top";
        categoryList.add(categoryName);

        createCategoryCommand.execute(categoryList);
        Assertions.assertEquals(1, productRepository.getCategories().size());
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        Assertions.assertThrows(InvalidUserInputException.class,() -> createCategoryCommand.execute(categoryList));
    }

    @Test
    public void execute_Should_ThrowException_When_DuplicateCategoryName() {
        String categoryName = "top";
        categoryList.add(categoryName);
        createCategoryCommand.execute(categoryList);
        Assertions.assertThrows(DuplicateEntityException.class,() -> createCategoryCommand.execute(categoryList));
    }

}
