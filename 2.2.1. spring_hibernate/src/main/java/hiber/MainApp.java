package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User taras = new User("TARAS", "Popov", "popov@mail.ru");
        Car car = new Car("Lada", 2110);
        taras.setCar(car);
        userService.add(taras);

        User ilya = new User("Илья", "Кухарюк", "илья1@mail.ru");
        Car car2 = new Car("BMW", 345);
        ilya.setCar(car2);
        userService.add(ilya);

        User sergey = new User("Сергей", "Соколов", "Sokol@mail.ru");
        Car car3 = new Car("Renault", 123);
        sergey.setCar(car3);
        userService.add(sergey);

        User vlad = new User("Vlad", "Stepanov", "Step@mail.ru");
        Car car4 = new Car("Mersedes", 600);
        vlad.setCar(car4);
        userService.add(vlad);

        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car =" + user.getCar());
            System.out.println();
        }

        System.out.println(userService.getUser("Mersedes", 600));

        context.close();
    }
}
