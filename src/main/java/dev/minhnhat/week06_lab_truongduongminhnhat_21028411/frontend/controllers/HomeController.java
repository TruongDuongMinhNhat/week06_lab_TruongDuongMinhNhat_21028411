package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.frontend.controllers;

import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.User;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.impl.PostService;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @GetMapping("/log-in")
    public String directToLogin() {
        return "index";
    }

    @GetMapping("/register")
    public String directToRegister() {
        return "register-account";
    }

    @PostMapping("/log-in")
    public String logIn(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userService.checkLogin(email, password).get();
        user.setLastLogin(LocalDate.now());
        userService.save(user);
        model.addAttribute("accountDetail", user);
        return "homepage";
    }

    @PostMapping("/create-account")
    public String createAccount(
            @RequestParam String firstName,
            @RequestParam String middleName,
            @RequestParam String lastName,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String intro,
            @RequestParam String profile
    ) {
        int randomPassword = ThreadLocalRandom.current().nextInt(10000000, 99999999);
        User user = new User(firstName, middleName, lastName, phone, email, String.valueOf(randomPassword), LocalDate.now(), LocalDate.now(), intro, profile);
        userService.save(user);
        ModelMap model = new ModelMap();
        model.addAttribute("accountDetail", user);
        model.addAttribute("listPost", postService.findAll());
        return "homepage";
    }
}
