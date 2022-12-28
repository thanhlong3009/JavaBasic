package book_management.backend.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;

    @SerializedName("category")
    private List<String> categories;

    private String title;
    private String author;

    @SerializedName("page_number")
    private int pageNumber;
    @SerializedName("release_year")
    private int release_year;
}
