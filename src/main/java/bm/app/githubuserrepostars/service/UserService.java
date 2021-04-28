package bm.app.githubuserrepostars.service;

import bm.app.githubuserrepostars.model.UserRepos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final RestTemplate restTemplate = new RestTemplate();

    public UserRepos[] getReposForAUser(String username) throws IOException {
        UserRepos[] userRepos = fetchDataFromExternalApi(username);
        if (userRepos.length == 0) {
            logger.error("Could not find a provided user.");
            return null;
        } else {
            logger.info("The output returned.");
            return userRepos;
        }
    }

    public int countTheStars(String username) throws IOException {
       return Arrays.stream(fetchDataFromExternalApi(username)).mapToInt(user -> user.getStars()).sum();
    }

    private UserRepos[] fetchDataFromExternalApi(String username) throws IOException {
        return restTemplate.getForObject(provideTheUrl(username).toString(), UserRepos[].class);
    }

    private URL provideTheUrl(String username) throws MalformedURLException {
         URL url = new URL("https://api.github.com/users/" + username + "/repos");
         return url;
    }
}
