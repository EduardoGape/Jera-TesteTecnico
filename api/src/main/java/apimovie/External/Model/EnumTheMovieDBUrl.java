package apimovie.External.Model;

public enum EnumTheMovieDBUrl {
    AUTHENTICATION("authentication"),
    SEARCHMOVIE("/search/movie");

    private String description;

    EnumTheMovieDBUrl(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}