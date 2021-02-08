package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //  SpringApplication.run(DemoApplication.class, args);

        // uruchamianie aplikacji konsolowej pierw, wyswietli dane w konsoli
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        UserRepesitory userRepesitory = context.getBean(UserRepesitory.class);

        User user = new User();
        user.setName("Daniel");
        userRepesitory.save(user);
        displayUser(userRepesitory);
    }

    private static void displayUser(UserRepesitory userRepesitory) {
        long id = 4L;
        Optional<User> userOptional = userRepesitory.findById(id);
        if (userOptional.isPresent()) { //jeśli nie zwruci null to wtedy działamy na użytkowniku
            User user = userOptional.get();
            System.out.println("Nazwa: " + user.getName());
        } else {
            System.out.println("Użytkownik o id: " + id + " nie istnieje!");
        }
    }

}
