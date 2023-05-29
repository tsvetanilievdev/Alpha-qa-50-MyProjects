package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public abstract class VehicleBase implements Vehicle {
    private final static int MAKE_LEN_MIN = 2;
    private final static int MAKE_LEN_MAX = 15;
    private final static String MAKE_MSG_ERR = String.format(
            "Make must be between %s and %s characters long!",
            MAKE_LEN_MIN,
            MAKE_LEN_MAX);
    private final static int MODEL_LEN_MIN = 1;
    private final static int MODEL_LEN_MAX = 15;
    private final static String MODEL_MSG_ERR = String.format(
            "Model must be between %s and %s characters long!",
            MODEL_LEN_MIN,
            MODEL_LEN_MAX);
    private final static double PRICE_VAL_MIN = 0.0;
    private final static double PRICE_VAL_MAX = 1000000.0;
    private final static String PRICE_MSG_ERR = format(
            "Price must be between %.1f and %.1f!",
            PRICE_VAL_MIN,
            PRICE_VAL_MAX);

    private String make;
    private String model;
    private double price;
    private List<Comment> comments;

    protected VehicleBase(String make, String model, double price) {
        setMake(make);
        setModel(model);
        setPrice(price);
        this.comments = new ArrayList<>();
    }

    @Override
    public String getMake() {
        return make;
    }

    private void setMake(String make) {
        validateMake(make);
        this.make = make;
    }

    @Override
    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        validateModel(model);
        this.model = model;
    }

    @Override
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

    protected void validateMake(String make) {
        ValidationHelpers.validateIntRange(make.length(), MAKE_LEN_MIN, MAKE_LEN_MAX, MAKE_MSG_ERR);
    }

    protected void validateModel(String model) {
        ValidationHelpers.validateIntRange(model.length(), MODEL_LEN_MIN, MODEL_LEN_MAX, MODEL_MSG_ERR);
    }

    protected void validatePrice(double price) {
        ValidationHelpers.validateDecimalRange(price, PRICE_VAL_MIN, PRICE_VAL_MAX, PRICE_MSG_ERR);
    }

    @Override
    public String toString() {
        return String.format("Make: %s%nModel: %s%nWheels: %d%nPrice: $%.0f%n",
                getMake(),
                getModel(),
                getWheels(),
                getPrice());
    }

    protected String printComments() {
        StringBuilder str = new StringBuilder();
        if (getComments().size() > 0) {
            str.append("--COMMENTS--");
            for (Comment comment : getComments()) {
                str.append(comment.toString());
            }
            str.append("\n--COMMENTS--");
        } else {
            str.append("--NO COMMENTS--");
        }
        return str.toString();
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(this.comments);
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }
}
