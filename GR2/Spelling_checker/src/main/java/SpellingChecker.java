import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SpellingChecker {
    private final HashSet<String> properNouns;
//    private final HashMap<String, Integer> dictionary;
    private final HashSet<String> dictionary;

    // Lưu từ điển và danh từ riêng vào hashmap, hashset
    public SpellingChecker(String properNounFile, String dictionaryFile) {
        properNouns = new HashSet<String>();
//        dictionary = new HashMap<String, Integer>();
        dictionary = new HashSet<String>();
        try {
            BufferedReader properNounReader = new BufferedReader(new FileReader(properNounFile));
            String line;
            while ((line = properNounReader.readLine()) != null) {
                properNouns.add(line.trim().toLowerCase());
            }
            properNounReader.close();

            BufferedReader dictionaryReader = new BufferedReader(new FileReader(dictionaryFile));
            while ((line = dictionaryReader.readLine()) != null) {
//                dictionary.put(line.trim().toLowerCase(), 1);
                dictionary.add(line.trim().toLowerCase());
            }
            dictionaryReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Kiểm tra chỉnh tả 1 file text
    public void checkSpellingByTextFile(String textFile) {
        try {
            BufferedReader textReader = new BufferedReader(new FileReader(textFile));
            String line;
            while ((line = textReader.readLine()) != null) {
                String[] words = line.split(" ");
                int count = 0;
                for (String word : words) {
                    // kiểm tra từ có phải là số không
                    boolean numeric = true;
                    try{
                        double num = Double.parseDouble(word);
                    } catch (NumberFormatException e) {
                        numeric = false;
                    }
                    String lowerCaseWord = word.trim().toLowerCase();
//                    if (!properNouns.contains(lowerCaseWord) && !dictionary.containsKey(lowerCaseWord)) {
                    if (!properNouns.contains(lowerCaseWord) && !dictionary.contains(lowerCaseWord) && !numeric) {
                        System.out.println("Từ sai chính tả: " + word);
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Không phát hiện ra lỗi sai chính tả");
                }
            }
            textReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Kiểm tra chính tả câu nhập từ bàn phím
    public void checkSpellingByKeyboard(String text) {
            String[] words = text.split(" ");
            int count = 0;
            for (String word : words) {
                // Kiểm tra từ có phải là 1 số không
                boolean numeric = true;
                try{
                    double num = Double.parseDouble(word);
                } catch (NumberFormatException e) {
                    numeric = false;
                }

                String lowerCaseWord = word.trim().toLowerCase();
//                if (!properNouns.contains(lowerCaseWord) && !dictionary.containsKey(lowerCaseWord)) {
                if (!properNouns.contains(lowerCaseWord) && !dictionary.contains(lowerCaseWord) && !numeric) {
                    System.out.println("Từ sai chính tả: " + word);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Không phát hiện ra lỗi sai chính tả");
            }
    }
    // Tìm kiếm từ vựng từ file từ điển/danh từ riêng theo gợi ý
    public  void searchDictionary(String word,String fileName){
        List<String> words = new ArrayList<>();

        for (String s: getWords(fileName)){
            if (s.contains(word)){
                words.add(s);
            }
        }
        for (String s: words){
            System.out.println(s);
        }
    }
    // Đọc từng từ trong file từ điển/danh từ riêng và trả về 1 list
    public static List<String> getWords(String fileName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file " + fileName);
        }
        return words;
    }
    // thêm từ mới vào file
    public void addToFile(String word,String fileName){
        if (dictionary.contains(word) || properNouns.contains(word))
        {
            System.out.println("Từ đã tồn tại trong file.");
        }else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.newLine();
                writer.write(word);
                System.out.println("Đã thêm từ mới vào file.");
            } catch (IOException e) {
                System.out.println("Không thể ghi vào file " + fileName);
            }
        }
    }

    public static void main(String[] args) {
        String properNounFile = "proper_nouns.txt";
        String dictionaryFile = "english_dictionary.txt";
        String textFile = "sample_text.txt";

        SpellingChecker checker = new SpellingChecker(properNounFile, dictionaryFile);
        checker.checkSpellingByTextFile(textFile);
    }
}
