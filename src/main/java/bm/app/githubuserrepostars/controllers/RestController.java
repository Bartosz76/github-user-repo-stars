package bm.app.githubuserrepostars.controllers;

import bm.app.githubuserrepostars.model.User;
import bm.app.githubuserrepostars.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {

    private UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{username}/repos")
    public User[] getUserRepos(@PathVariable String username) throws IOException {
        return userService.getAUser(username);
    }

    @GetMapping("/users/{username}/repos/stars/sum")
    public int getTheSumOfUserReposStars(@PathVariable String username) throws IOException {
        return userService.countTheStars(username);
    }

}
