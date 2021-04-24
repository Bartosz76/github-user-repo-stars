package bm.app.githubuserrepostars.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRepos {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName(value = "stargazers_count")
    @Expose
    private Integer stars;

    public UserRepos() {
    }

    public UserRepos(String name, Integer stars) {
        this.name = name;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "REPOSITORY: " +
                "Name: '" + name + '\'' +
                ", The number of stars: '" + stars + '\'' +
                '.';
    }
}
