package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
public class MainController {

    private UserRepesitory userRepesitory;

    public MainController(UserRepesitory userRepesitory) { //dostarczamy obiektu z stringa
        this.userRepesitory = userRepesitory;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) Gender gender) {

        List<User> all;
        if (gender != null) {
            all = userRepesitory.findAllByGenderOrderByNameDesc(gender); //zwracamy liste wszystkich urzytkowników, metoda jest z JpaRepository
        } else {
            all = userRepesitory.findAll();
        }

        Random random = new Random();
        User user = all.get(0);
        user.setName(user.getName() + random.nextInt(10));

        userRepesitory.save(user);

        model.addAttribute("users", all); //dodajemy atrybut users i all przekazujemy
        model.addAttribute("userToAdd", new User());
        return "home";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userRepesitory.save(user);
        return "redirect:/";
    }
}
