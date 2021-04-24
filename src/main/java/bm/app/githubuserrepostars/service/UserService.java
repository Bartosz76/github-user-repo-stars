package bm.app.githubuserrepostars.service;

import bm.app.githubuserrepostars.model.User;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User[] getAUser(String username) throws IOException {
        InputStreamReader reader = new InputStreamReader(provideTheUrl(username).openStream());
        User[] users = new Gson().fromJson(reader, User[].class);
        if (users == null) {
            logger.error("No input provided.");
            return null;
        } else {
            logger.info("The output returned.");
            return users;
        }
    }

    public int countTheStars(String username) throws IOException {
        InputStreamReader reader = new InputStreamReader(provideTheUrl(username).openStream());
        User[] users = new Gson().fromJson(reader, User[].class);
       return Arrays.stream(users).mapToInt(user -> user.getStars()).sum();
    }

    private URL provideTheUrl(String username) throws MalformedURLException {
         URL url = new URL("https://api.github.com/users/" + username + "/repos");
         return url;
    }
}
