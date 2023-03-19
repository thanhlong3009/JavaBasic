import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
// sắp xếp và loại bỏ các từ bị trùng trong file text
public class SortAndRemoveDuplicateWords {
    public static void main(String[] args) {
        String fileName = "english_dictionary.txt";
        ArrayList<String> words = new ArrayList<>();

        // Đọc dữ liệu từ file vào ArrayList
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sắp xếp ArrayList theo thứ tự a b c
        Collections.sort(words);

        // Loại bỏ các từ bị lặp lại
        HashSet<String> uniqueWords = new HashSet<>();
        ArrayList<String> sortedAndUniqueWords = new ArrayList<>();
        for (String word : words) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
                sortedAndUniqueWords.add(word);
            }
        }

        // Ghi dữ liệu đã sắp xếp và loại bỏ từ bị lặp lại vào file
        try (FileWriter fw = new FileWriter(fileName)) {
            for (String word : sortedAndUniqueWords) {
                fw.write(word + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

