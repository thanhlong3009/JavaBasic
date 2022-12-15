package homework_film_management;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // In ra thông tin phim
        printInfo();
        // Tìm phim theo tiêu đề
        findByTitle("Bad");

    }

    public static Movie[] movies = {
            new Movie(1, "TITANIC", "Điện ảnh lãng mạn", "James Cameron", "1-11-1997", "194 phút"),
            new Movie(2, "CÔNG VIÊN KỶ JURA", "Viễn tưởng", "Steven Spielberg", "7-6-2013", "127 phút"),
            new Movie(3, "HUYỀN THOẠI NGƯỜI DƠI", "Hành động", "Christopher Nolan", "19-8-2005", "140 phút"),
    };

    public static Serial[] serials = {
            new Serial(1, "GAME OF THRONES", "Viễn tưởng", "Mark Mylod", "17-4-2011",73 ,"60 phút"),
            new Serial(2, "THE WALKING DEAD", "Viễn tưởng", "Robert Kirkman", "12-9-2012", 177,"70 phút"),
            new Serial(3, "BREAKING BAD", "Hình sự", " Vince Gilligan", "29-9-2010", 62,"90 phút"),
    };


    public static void printInfo() {

        System.out.println("--------Danh sách phim--------- ");
        for (int i = 0; i < 3; i++) {
            System.out.println(movies[i]);
        }
        System.out.println();
        System.out.println("--------Danh sách phim truyền hình series---------");
        for (int i = 0; i < 3; i++) {
            System.out.println(serials[i]);
        }
        System.out.println();
    }

    // Tìm phim theo tiêu đề
    public static void findByTitle(String title) {
        int count = 0;
        for (Movie film : movies)  {
            if (film.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(film);
                count++;
            }
        }
        for (Serial film : serials) {
            if (film.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(film);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có bộ phim nào cần tìm");
        }
    }

}
