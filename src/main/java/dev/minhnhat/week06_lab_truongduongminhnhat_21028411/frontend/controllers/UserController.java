package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.frontend.controllers;

import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.User;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.impl.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/view-detail-account")
    public String viewAccount(HttpServletRequest request, Model model) {
        model.addAttribute("account", (User) request.getServletContext().getAttribute("accountDetail"));
        return "account/view-account";
    }

    @GetMapping("/update-account")
    public String updateAccount(HttpServletRequest request, Model model) {
        model.addAttribute("account", (User) request.getServletContext().getAttribute("accountDetail"));
        return "account/update-account";
    }

    @PostMapping("/update-account/{id}")
    public String updateAccount(@PathVariable("id") String id,
                                @RequestParam String firstName,
                                @RequestParam String middleName,
                                @RequestParam String lastName,
                                @RequestParam String mobile,
                                @RequestParam String email,
                                @RequestParam String intro,
                                @RequestParam String profile,
                                @RequestParam String password) {
        User user = userService.findById(Long.parseLong(id)).get();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setMobile(mobile);
        user.setEmail(email);
        user.setIntro(intro);
        user.setProfile(profile);
        user.setIntro(intro);
        user.setPasswordHash(password);

        userService.save(user);
        return "account/view-account";
    }
}
