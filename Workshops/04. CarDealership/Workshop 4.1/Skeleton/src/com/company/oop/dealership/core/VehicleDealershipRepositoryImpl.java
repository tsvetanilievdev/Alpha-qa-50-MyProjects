package com.company.oop.dealership.core;

import com.company.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.company.oop.dealership.models.*;
import com.company.oop.dealership.models.contracts.*;
import com.company.oop.dealership.models.enums.UserRole;

import java.util.ArrayList;
import java.util.List;

public class VehicleDealershipRepositoryImpl implements VehicleDealershipRepository {

    private static final String NO_LOGGED_IN_USER = "There is no logged in user.";
    private final static String NO_SUCH_USER = "There is no user with username %s!";
    private final static String USER_ALREADY_EXIST = "User %s already exist. Choose a different username!";

    private final List<User> users;
    private User loggedUser;

    public VehicleDealershipRepositoryImpl() {
        this.users = new ArrayList<>();
        this.loggedUser = null;
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public void addUser(User userToAdd) {
        if (users.contains(userToAdd)) {
            throw new IllegalArgumentException(String.format(USER_ALREADY_EXIST, userToAdd.getUsername()));
        }
        this.users.add(userToAdd);
    }

    @Override
    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new IllegalArgumentException(String.format(NO_SUCH_USER, username));
    }

    @Override
    public User getLoggedInUser() {
        if (loggedUser == null) {
            throw new IllegalArgumentException(NO_LOGGED_IN_USER);
        }
        return loggedUser;
    }

    @Override
    public boolean hasLoggedInUser() {
        return loggedUser != null;
    }

    @Override
    public void login(User user) {
        loggedUser = user;
    }

    @Override
    public void logout() {
        loggedUser = null;
    }

    @Override
    public Car createCar(String make, String model, double price, int seats) {
        Car car = new CarImpl(make, model, price, seats);
        return car;
    }

    @Override
    public Motorcycle createMotorcycle(String make, String model, double price, String category) {
        Motorcycle motorcycle = new MotorcycleImpl(make, model, price, category);
        return motorcycle;
    }

    @Override
    public Truck createTruck(String make, String model, double price, int weightCapacity) {
        Truck truck = new TruckImpl(make, model, price, weightCapacity);
        return truck;
    }

    @Override
    public User createUser(String username, String firstName, String lastName, String password, UserRole userRole) {
        User user = new UserImpl(username, firstName, lastName, password, userRole);
        return user;
    }

    @Override
    public Comment createComment(String content, String author) {
        Comment comment = new CommentImpl(content, author);
        return comment;
    }
}
