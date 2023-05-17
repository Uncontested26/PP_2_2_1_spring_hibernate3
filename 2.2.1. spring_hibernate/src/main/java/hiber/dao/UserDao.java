package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void add(Car car);

    List<Car> listCar();

    List<User> getUsers();

    User getUser(String model, int series);
}
