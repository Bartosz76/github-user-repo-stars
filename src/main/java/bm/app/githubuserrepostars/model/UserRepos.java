package bm.app.githubuserrepostars.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRepos {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName(value = "stargazers_count")
    @Expose
    private Integer stars;

    @Override
    public String toString() {
        return "REPOSITORY: " +
                "Name: '" + name + '\'' +
                ", The number of stars: '" + stars + '\'' +
                '.';
    }
}
