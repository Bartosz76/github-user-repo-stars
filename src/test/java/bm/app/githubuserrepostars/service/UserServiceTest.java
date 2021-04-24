package bm.app.githubuserrepostars.service;

import bm.app.githubuserrepostars.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    UserService userService;
    UserService userServiceMock;

    @Test
    @DisplayName("Should return a name of the first repository of a provided user.")
    void shouldReturnTheNameOfTheFirstRepoOfAUser() throws IOException {
        //given
        String name = "nitay";
        //when
        User[] resultArray = userService.getAUser(name);
        //then
        assertThat(resultArray[0].getName()).isEqualTo("ai-deadlines");
    }

    @Test
    @DisplayName("Should return a total number of all stars a provided user received for their repositories.")
    void shouldCountTheStarsOfAllUsersRepos() throws IOException {
        //given
        String name = "pjhyett";
        //when
        int numberOfStars = userService.countTheStars(name);
        //then
        assertThat(numberOfStars).isEqualTo(597);
    }

    @Test
    void shouldReturnAPrePreparedArray() throws IOException {
        //given
        String name = "cyndaquil";
        User[] pokemon = {new User("flaminglyGoodProject", 155),
                          new User("apiOfTheFlame", 14),
                          new User("fieryHedgehog", 36)};
        //when
        Mockito.when(userServiceMock.getAUser(name)).thenReturn(pokemon);
        //then
        assertThat(userServiceMock.getAUser(name)).isEqualTo(pokemon);
    }

    @BeforeEach
    void setUp() {
        userService = new UserService();
        userServiceMock = Mockito.mock(UserService.class);
    }

}