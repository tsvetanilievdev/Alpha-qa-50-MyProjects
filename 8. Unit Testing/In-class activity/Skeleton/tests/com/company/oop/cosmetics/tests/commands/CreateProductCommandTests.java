package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateProductCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.DuplicateEntityException;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CreateProductCommandTests {
    // @BeforeEach may help here
    private ProductRepositoryImpl productRepository;
    private CreateProductCommand createProductCommand;
    private ArrayList<String> productList;
    private String productName = "T-shirt";
    private String brandName = "Nike";
    private String priceString = "44.44";
    private String genderString = "unisex";


    @BeforeEach
    public void initFields(){
        productRepository = new ProductRepositoryImpl();
        createProductCommand = new CreateProductCommand(productRepository);
        productList = new ArrayList<>();
    }
    @Test
    public void execute_Should_AddNewProductToRepository_When_ValidParameters() {
        productList.add(productName);
        productList.add(brandName);
        productList.add(priceString);
        productList.add(genderString);

        createProductCommand.execute(productList);
        Assertions.assertEquals(1, productRepository.getProducts().size());
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        Assertions.assertThrows(InvalidUserInputException.class,() -> createProductCommand.execute(productList));
    }

    @Test
    public void execute_Should_ThrowException_When_DuplicateProductParameters() {
        productList.add(productName);
        productList.add(brandName);
        productList.add(priceString);
        productList.add(genderString);

        createProductCommand.execute(productList);
        Assertions.assertThrows(DuplicateEntityException.class,() -> createProductCommand.execute(productList));
    }

    @Test
    public void execute_Should_ThrowException_When_InvalidPriceIsProvided() {
        priceString = "INVALID_PRICE";

        productList.add(productName);
        productList.add(brandName);
        productList.add(priceString);
        productList.add(genderString);

        Assertions.assertThrows(InvalidUserInputException.class,
                () -> createProductCommand.execute(productList),
                "Third parameter should be price (real number).");
    }

    @Test
    public void execute_Should_ThrowException_When_InvalidGenderTypeIsProvided() {
        genderString = "child";
        productList.add(productName);
        productList.add(brandName);
        productList.add(priceString);
        productList.add(genderString);

        Assertions.assertThrows(InvalidUserInputException.class,
                () -> createProductCommand.execute(productList),
                "Third parameter should be price (real number).");
    }

}
