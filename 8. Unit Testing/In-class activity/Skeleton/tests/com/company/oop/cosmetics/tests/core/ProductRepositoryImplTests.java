package com.company.oop.cosmetics.tests.core;

import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImplTests {
    private ProductRepositoryImpl productRepository;

    @BeforeEach
    public void initFields() {
        productRepository = new ProductRepositoryImpl();
    }

    @Test
    public void constructor_Should_InitializeProducts() {
        Assertions.assertEquals(0, productRepository.getProducts().size());
    }

    @Test
    public void constructor_Should_InitializeCategories() {
        Assertions.assertEquals(0, productRepository.getCategories().size());
    }

    @Test
    public void getCategories_Should_ReturnCopyOfCollection() {
        List<Category> listOne = productRepository.getCategories();
        List<Category> listTwo = productRepository.getCategories();

        Assertions.assertNotSame(listOne, listTwo);
    }

    @Test
    public void getProducts_Should_ReturnCopyOfCollection() {
        List<Product> listOne = productRepository.getProducts();
        List<Product> listTwo = productRepository.getProducts();

        Assertions.assertNotSame(listOne, listTwo);
    }

    @Test
    public void categoryExists_Should_ReturnTrue_When_CategoryExists() {
        String categoryName = "top";

        productRepository.createCategory(categoryName);

        Assertions.assertTrue(productRepository.categoryExist(categoryName));
    }

    @Test
    public void categoryExists_Should_ReturnFalse_When_CategoryDoesNotExist() {
        String categoryNameOne = "top";
        String categoryNameTwo = "shoes";

        productRepository.createCategory(categoryNameOne);

        Assertions.assertFalse(productRepository.categoryExist(categoryNameTwo));
    }

    @Test
    public void productExists_Should_ReturnTrue_When_ProductExists() {
        String productName = "T-shirt";
        String brandName = "Nike";
        Double price = 44.44;
        GenderType genderType = GenderType.UNISEX;

        productRepository.createProduct(productName, brandName, price, genderType);

        Assertions.assertTrue(productRepository.productExist(productName));
    }

    @Test
    public void productExists_Should_ReturnFalse_When_ProductDoesNotExist() {
        String productName = "T-shirt";
        String brandName = "Nike";
        Double price = 44.44;
        GenderType genderType = GenderType.UNISEX;

        productRepository.createProduct(productName, brandName, price, genderType);

        Assertions.assertFalse(productRepository.productExist("fake product"));
    }

    @Test
    public void createProduct_Should_AddToProducts_When_ArgumentsAreValid() {
        String productName = "T-shirt";
        String brandName = "Nike";
        Double price = 44.44;
        GenderType genderType = GenderType.UNISEX;
        productRepository.createProduct(productName, brandName, price, genderType);

        Assertions.assertTrue(productRepository.productExist(productName));
    }

    @Test
    public void createCategory_Should_AddToCategories_When_ArgumentsAreValid() {
        String categoryName = "top";
        productRepository.createCategory(categoryName);

        Assertions.assertTrue(productRepository.categoryExist(categoryName));
    }

    @Test
    public void findCategoryByName_Should_ReturnCategory_When_Exists() {
        String categoryName = "top";
        productRepository.createCategory(categoryName);

        Category category = productRepository.findCategoryByName(categoryName);

        Assertions.assertNotNull(category);
        Assertions.assertEquals(CategoryImpl.class,category.getClass());
    }

    @Test
    public void findCategoryByName_Should_ThrowException_When_DoesNotExist() {
        Assertions.assertThrows(
                InvalidUserInputException.class,
                () -> productRepository.findCategoryByName("fake category"));
    }

    @Test
    public void findProductByName_Should_ReturnCategory_When_Exists() {
        String productName = "T-shirt";
        String brandName = "Nike";
        Double price = 44.44;
        GenderType genderType = GenderType.UNISEX;
        productRepository.createProduct(productName, brandName, price, genderType);
        Product product = productRepository.findProductByName(productName);

        Assertions.assertNotNull(product);
        Assertions.assertEquals(productName,product.getName());
    }

    @Test
    public void findProductByName_Should_ThrowException_When_DoesNotExist() {
        Assertions.assertThrows(
                InvalidUserInputException.class,
                () -> productRepository.findProductByName("fake product"));
    }

}
