package homework_film_management;

import java.util.Date;

public class Film {
    private int id;
    private String title;
    private String category;
    private String director;
    private String releaseDate;

    public Film() {
    }

    public Film(int id, String title, String category, String director, String releaseDate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void display() {
        System.out.println("Id: " + id + "\n" + "Tên phim: " + title + "\n" + "Thể loại: " + category + "\n" + "Giám đốc sản xuất : " + director + "\n" + "Ngày công chiếu: " + releaseDate);
    }


    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", director='" + director + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
