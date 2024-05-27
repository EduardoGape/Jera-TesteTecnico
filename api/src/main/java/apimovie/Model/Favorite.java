package apimovie.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "favorite")
public class Favorite  {

    @Id
    private String id;
    private List<Movie> movies;
    private String profile;

    // Getters e setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public  List<Movie> getMovie() {
        return movies;
    }

    public void setMovie( List<Movie> movies) {
        this.movies = movies;
    }
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
