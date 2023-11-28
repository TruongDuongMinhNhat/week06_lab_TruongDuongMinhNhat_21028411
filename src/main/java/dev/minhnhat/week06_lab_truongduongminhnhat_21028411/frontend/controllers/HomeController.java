package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.frontend.controllers;

import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.User;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.impl.PostService;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.impl.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @GetMapping("/log-in")
    public String directToLogin(HttpServletRequest request) {
        request.getServletContext().setAttribute("accountDetail", null);
        return "index";
    }

    @GetMapping("/register")
    public String directToRegister() {
        return "register-account";
    }

    @GetMapping("/homepage")
    public String directToHomePage(Model model) {
        model.addAttribute("listPost", postService.findAllByPublishedIsTrue(true));
        return "homepage";
    }

    @PostMapping("/log-in")
    public String logIn(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request) {
        User user = userService.checkLogin(email, password).orElse(null);

        if(user == null) {
            model.addAttribute("loginFailed", "Your email or password isn't correct!");
            return "index";
        }

        user.setLastLogin(LocalDateTime.now());
        userService.save(user);
        model.addAttribute("accountDetail", user);
        model.addAttribute("listPost", postService.findAllByPublishedIsTrue(true));

        request.getServletContext().setAttribute("accountLogin", user);
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
            @RequestParam String profile,
            HttpServletRequest request,
            Model model
    ) {
        int randomPassword = ThreadLocalRandom.current().nextInt(10000000, 99999999);
        User user = new User(firstName, middleName, lastName, phone, email, String.valueOf(randomPassword), LocalDateTime.now(),
                LocalDateTime.now(), intro, profile);
        userService.save(user);
        model.addAttribute("accountDetail", user);
        model.addAttribute("listPost", postService.findAllByPublishedIsTrue(true));

        request.getServletContext().setAttribute("accountLogin", user);
        return "homepage";
    }
}
