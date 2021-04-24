package bm.app.githubuserrepostars.controllers;

import bm.app.githubuserrepostars.model.UserRepos;
import bm.app.githubuserrepostars.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

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

    @PostMapping("/repos")
    public String getReposOfTheProvidedUser(@RequestParam String username,
                                            Model model) throws IOException {
        UserRepos[] resultArray = userService.getReposForAUser(username);
        model.addAttribute("resultArray", resultArray);
        return "resultRepoList";
    }

    @PostMapping("/stars")
    public String getStarsCountOfReposOfTheProvidedUser(@RequestParam String username,
                                                        Model model) throws IOException {
        int numberOfSummedStars = userService.countTheStars(username);
        model.addAttribute("username", username);
        model.addAttribute("numberOfSummedStars", numberOfSummedStars);
        return "resultStarsCount";
    }

}
