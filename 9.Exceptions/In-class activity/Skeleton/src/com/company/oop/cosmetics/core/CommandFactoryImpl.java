package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.commands.*;
import com.company.oop.cosmetics.core.contracts.CommandFactory;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.exceptions.InvalidInputException;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class CommandFactoryImpl implements CommandFactory {

    @Override
    public Command createCommandFromCommandName(String commandTypeValue, ProductRepository productRepository) {
        CommandType commandType = ValidationHelpers.validateCommandType(commandTypeValue);
        switch (commandType) {
            case CREATECATEGORY:
                return new CreateCategoryCommand(productRepository);
            case CREATEPRODUCT:
                return new CreateProductCommand(productRepository);
            case ADDPRODUCTTOCATEGORY:
                return new AddProductToCategoryCommand(productRepository);
            case SHOWCATEGORY:
                return new ShowCategoryCommand(productRepository);
            default:
                throw new InvalidInputException("Invalid command");
        }
    }
}
