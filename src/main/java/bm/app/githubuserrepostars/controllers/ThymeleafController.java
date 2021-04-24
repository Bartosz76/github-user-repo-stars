package bm.app.githubuserrepostars.controllers;

import bm.app.githubuserrepostars.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    private UserService userService;

    public ThymeleafController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/landingpage")
    public String getLandingpage() {
        return "landingpage";
    }
}
