package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);


    List<Car> listCar();

    List<User> getUsers();

    User getUser(String model, int series);
}
