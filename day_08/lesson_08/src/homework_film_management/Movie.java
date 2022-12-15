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

    public void display() {
        super.display();
        System.out.println("Thời lượng phim: " + movieDuration);
    }

    public void findByTitle(String title) {

    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieDuration='" + movieDuration + '\'' +
                '}';
    }
}
