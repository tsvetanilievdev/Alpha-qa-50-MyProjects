package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    public static final int MIN_CATEGORY_NAME_LENGTH = 2;
    public static final int MAX_CATEGORY_NAME_LENGTH = 15;
    
    private String name;
    private List<Product> products;
    
    public CategoryImpl(String name) {
        validateName(name, MIN_CATEGORY_NAME_LENGTH, MAX_CATEGORY_NAME_LENGTH);
        this.name = name;
        this.products = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public List<Product> getProducts() {
        // because we do NOT want to give access to real reference and everybody outside to be able to manipulate it!!
        return new ArrayList<>(products);
    }
    
    public void addProduct(Product product) {
        products.add(product);
    }
    
    public void removeProduct(Product product) {
        if(!products.contains(product)){
            throw new IllegalArgumentException(String.format("%s is NOT into the category:%s!", product.getName(),name));
        }
        products.remove(product);
    }
    
    //The engine calls this method to print your category! You should not rename it!
    public String print() {
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }else {
            StringBuilder str = new StringBuilder();
            str.append(String.format("#Category: %s%n", getName()));
            for (Product product: products) {
                str.append(product.print());
            }
            return str.toString();
        }

    }

    private void validateName(String name,int MIN_PROPERTY_LENGTH, int MAX_PROPERTY_LENGTH ) {
        if (name.length() < MIN_PROPERTY_LENGTH || name.length() > MAX_PROPERTY_LENGTH) {
            throw new IllegalArgumentException(String.format("The category must be between %d and %d characters long!",
                    MIN_PROPERTY_LENGTH,
                    MAX_PROPERTY_LENGTH));
        }else if(name.isEmpty() || name == null){
            throw new IllegalArgumentException("The category cannot be empty or null");
        }
    }
}
