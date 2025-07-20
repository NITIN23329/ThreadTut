package lld.questions.ticketSystem;

public class Movie {
    private String name;
    private String language;
    private int rating;

    public Movie(String name, String language, int rating) {
        this.name = name;
        this.language = language;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", rating=" + rating +
                '}';
    }
}
