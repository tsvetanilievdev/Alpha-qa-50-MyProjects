package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CategoryImplTests {

    @Test
    public void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        //arrange
        CategoryImpl category = new CategoryImpl("top");
        //act, assert
        Assertions.assertEquals("top", category.getName());
    }

    @Test
    public void constructor_Should_InitializeProducts_When_ArgumentsAreValid() {
        //arrange
        CategoryImpl category = new CategoryImpl("top");
        //act, assert
        Assertions.assertEquals(0,category.getProducts().size());
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> new CategoryImpl("to"));
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsLongerThanExpected() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> new CategoryImpl("shirtshirtshirt"));
    }

    @Test
    public void addProduct_Should_AddProductToList() {
        //arrange
        CategoryImpl category = new CategoryImpl("top");
        //act
        ProductImpl product = new ProductImpl("t-shirt","Nike", 69.99, GenderType.MEN);
        category.addProduct(product);
        //assert
        Assertions.assertEquals(1,category.getProducts().size());
    }

    @Test
    public void removeProduct_Should_RemoveProductFromList_When_ProductExist() {
        //arrange
        CategoryImpl category = new CategoryImpl("top");
        //act
        ProductImpl product = new ProductImpl("t-shirt","Nike", 69.99, GenderType.MEN);
        category.addProduct(product);
        category.removeProduct(product);
        //assert
        Assertions.assertEquals(0,category.getProducts().size());
    }

    @Test
    public void removeProduct_should_notRemoveProductFromList_when_productNotExist() {
        //arrange
        CategoryImpl category = new CategoryImpl("top");
        //act
        ProductImpl product = new ProductImpl("t-shirt","Nike", 69.99, GenderType.MEN);
        ProductImpl product2 = new ProductImpl("t-shirt","Adidas", 99.99, GenderType.MEN);
        category.addProduct(product);
        category.removeProduct(product2);
        //assert
        Assertions.assertEquals(1,category.getProducts().size());
    }
    @Test
    public void print_should_printCategoryAndAllProducts_when_methodIsCalled(){
        //arrange
        String expected = String.format("#Category: top%n#t-shirt Nike%n #Price: $69,99%n #Gender: Men%n ===%n#t-shirt Adidas%n #Price: $99,99%n #Gender: Men%n ===%n");
        CategoryImpl category = new CategoryImpl("top");
        ProductImpl product = new ProductImpl("t-shirt","Nike", 69.99, GenderType.MEN);
        ProductImpl product2 = new ProductImpl("t-shirt","Adidas", 99.99, GenderType.MEN);
        category.addProduct(product);
        category.addProduct(product2);
        //act
        String printResult = category.print();
        //assert
        Assertions.assertEquals(expected, printResult);
    }

    @Test
    public void print_should_printCategoryAndNoProducts_when_methodIsCalled(){
        //arrange
        String expected = String.format("#Category: top%n #No product in this category");
        CategoryImpl category = new CategoryImpl("top");
        String printResult = category.print();

        //act, assert
        Assertions.assertEquals(expected, printResult);
    }
}
