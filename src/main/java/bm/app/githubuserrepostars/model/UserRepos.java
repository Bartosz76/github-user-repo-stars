package bm.app.githubuserrepostars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRepos {

    @JsonProperty("name")
    private String name;
    @JsonProperty("stargazers_count")
    private Integer stars;

    @Override
    public String toString() {
        return "REPOSITORY: " +
                "Name: '" + name + '\'' +
                ", The number of stars: '" + stars + '\'' +
                '.';
    }
}
