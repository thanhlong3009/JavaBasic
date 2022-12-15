package homework_film_management;

public class Movie extends Film{
    private String movieDuration;

    public Movie() {

    }

    public Movie(int id, String title, String category, String director, String releaseDate, String movieDuration) {
        super(id, title, category, director, releaseDate);
        this.movieDuration = movieDuration;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }




    @Override
    public String toString() {
        return "Movie{" + "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", director='" + getDirector() + '\'' +
                ", releaseDate='" + getReleaseDate() + '\''  +
                "movieDuration='" + movieDuration + '\'' +
                '}';
    }
}
