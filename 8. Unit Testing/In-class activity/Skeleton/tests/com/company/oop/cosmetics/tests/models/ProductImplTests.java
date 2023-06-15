package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductImplTests {
    //Which are the test cases?
    @Test
    public void constructor_Should_InitializeProduct_When_AllArgumentsAreValid(){
        ProductImpl product = new ProductImpl("t-shirt","Nike", 44.44, GenderType.WOMEN);

        Assertions.assertEquals("t-shirt", product.getName());
        Assertions.assertEquals("Nike", product.getBrand());
        Assertions.assertEquals(44.44, product.getPrice());
        Assertions.assertEquals(GenderType.WOMEN, product.getGender());
    }

    @Test
    public void constructor_Should_Throw_When_NameIsShorter(){
        Assertions.assertThrows(
                InvalidUserInputException.class,
                () -> new ProductImpl("t","Nike", 44.44, GenderType.WOMEN));
    }
    @Test
    public void constructor_Should_Throw_When_NameIsLonger(){
        Assertions.assertThrows(
                InvalidUserInputException.class,
                () -> new ProductImpl("t-shirt-t-shirt","Nike", 44.44, GenderType.WOMEN));
    }

    @Test
    public void constructor_Should_Throw_When_BrandIsShorter(){
        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl("t-shirt","N", 44.44, GenderType.WOMEN));
    }
    @Test
    public void constructor_Should_Throw_When_BrandIsLonger(){
        Assertions.assertThrows(
                InvalidUserInputException.class,
                () -> new ProductImpl("t-shirt","NikeAdidasPumaNewBalance", 44.44, GenderType.WOMEN));
    }

    @Test
    public void constructor_Should_Throw_When_PriceIsNegative(){
        Assertions.assertThrows(
                InvalidUserInputException.class,
                () -> new ProductImpl("t-shirt","Nike", -44.44, GenderType.WOMEN));
    }
}
