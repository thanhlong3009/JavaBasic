package homework_film_management;

public class Serial extends Film {
    private int episodeNumber;
    private String avgDuration;

    public Serial() {

    }

    public Serial(int id, String title, String category, String director, String releaseDate, int episodeNumber, String avgDuration) {
        super(id, title, category, director, releaseDate);
        this.episodeNumber = episodeNumber;
        this.avgDuration = avgDuration;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getAvgDuration() {
        return avgDuration;
    }

    public void setAvgDuration(String avgDuration) {
        this.avgDuration = avgDuration;
    }


    @Override
    public String toString() {
        return "Serial{" + "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", director='" + getDirector() + '\'' +
                ", releaseDate='" + getReleaseDate() + '\'' +
                "episodeNumber=" + episodeNumber +
                ", avgDuration='" + avgDuration + '\'' +
                '}';
    }
}
