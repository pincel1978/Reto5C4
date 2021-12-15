package com.cuatroa.retodos;

import com.cuatroa.retodos.model.Clone;
import com.cuatroa.retodos.model.Order;
import com.cuatroa.retodos.model.User;
import com.cuatroa.retodos.repository.OrderRepository;
import com.cuatroa.retodos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.cuatroa.retodos.repository.crud.CloneCrudRepository;
import com.cuatroa.retodos.repository.crud.OrderCrudRepository;
import com.cuatroa.retodos.repository.crud.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class RetodosApplication implements CommandLineRunner {

    @Autowired
    private CloneCrudRepository cloneCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RetodosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        cloneCrudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
//
//        cloneCrudRepository.saveAll(List.of(
//                new Clone(1, "ACER", "CORE I5", "WINDOWS 10", "ALTO RENDIMIENTO. Precio y calidad ", "8GB", "3T", true, 2550000, 5, "http://www.micacharro.com/img/clon1.png"),
//                new Clone(2, "ACER", "CORE I7", "WINDOWS 10", "ALTO RENDIMIENTO economia", "16GB", "5T", true, 3550000, 5, "http://www.micacharro.com/img/clon2.png")
//        ));
//
//        userCrudRepository.saveAll(List.of(
//                new User(1, "46669989", "BLODY MARRY", ft.parse("1996-11-15"), "11", "CR 34-45", "3174565625", "stellez@gmail.com", "Demo123.", "ZONA 2", "ASE"),
//                new User(2, "52369563", "JUANA DE ARCO", ft.parse("1987-05-15"), "05", "CR 34-45", "3265632", "jdarco@gmail.com", "Demo123.", "ZONA 2", "ASE")
//        ));

    }
}
