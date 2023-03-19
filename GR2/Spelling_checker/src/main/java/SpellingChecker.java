import java.io.*;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

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
//                String[] words = line.split(" ");
                String[] words = line.trim().split(" ");
                int count = 0;
                for (String word : words) {
                    word = functuationHandling(word);
                    String infinitiveWord = word;
                    // kiểm tra xem nếu từ có đầu là un hoặc dis mà ko có trong từ điển thì xóa un và dis
                    if (infinitiveWord.startsWith("un") && !dictionary.contains(infinitiveWord)){
                            infinitiveWord = infinitiveWord.substring(2);
                    }
                    if (infinitiveWord.startsWith("dis") && !dictionary.contains(infinitiveWord)){
                            infinitiveWord = infinitiveWord.substring(3);
                    }
                    // kiểm tra xem xóa chữ cuôi của từ thì có được từ có nghĩa không
                    // kiếm trả có phải danh từ thêm s không
                    if (infinitiveWord.endsWith("s")  && !dictionary.contains(infinitiveWord)){
                        if (dictionary.contains(infinitiveWord.substring(0,infinitiveWord.length() - 1).toLowerCase())){
                            infinitiveWord = infinitiveWord.substring(0,infinitiveWord.length() - 1);
                        }
                    }
                    // kiểm tra xem có phải là từ có kí tự cuối là e không ví dụ love -> loved , larger -> large
                    if ((infinitiveWord.endsWith("ed") || infinitiveWord.endsWith("er")) && !dictionary.contains(infinitiveWord)){
                        if (dictionary.contains(infinitiveWord.substring(0,infinitiveWord.length() - 1).toLowerCase())){
                            infinitiveWord = infinitiveWord.substring(0,infinitiveWord.length() - 1);
                        }
                    }
                    // kiểm tra xem có phải là từ có kí tự cuối là e hoặc l ko
                    if ((infinitiveWord.endsWith("est") || infinitiveWord.endsWith("ly")) && !dictionary.contains(infinitiveWord)){
                        if (dictionary.contains(infinitiveWord.substring(0,infinitiveWord.length() - 2).toLowerCase())){
                            infinitiveWord = infinitiveWord.substring(0,infinitiveWord.length() - 2);
                        }
                    }

                    if (!dictionary.contains(infinitiveWord.toLowerCase())){
                        infinitiveWord = verbTensenHandling(infinitiveWord);
                    }
                    // kiểm tra từ có phải là số không
                    boolean numeric = true;
                    try {
                        double num = Double.parseDouble(word);
                    } catch (NumberFormatException e) {
                        numeric = false;
                    }
                    String lowerCaseWord = infinitiveWord.toLowerCase();
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
            word = functuationHandling(word);
            String infinitiveWord = word;
            // kiểm tra xem nếu từ có đầu là un hoặc dis mà ko có trong từ điển thì xóa un và dis
            if (infinitiveWord.startsWith("un") && !dictionary.contains(infinitiveWord)){
                infinitiveWord = infinitiveWord.substring(2);
            }
            if (infinitiveWord.startsWith("dis") && !dictionary.contains(infinitiveWord)){
                infinitiveWord = infinitiveWord.substring(3);
            }
            // kiểm tra xem xóa chữ cuôi của từ thì có được từ có nghĩa không
            // kiếm trả có phải danh từ thêm s không
            if (infinitiveWord.endsWith("s")  && !dictionary.contains(infinitiveWord)){
                if (dictionary.contains(infinitiveWord.substring(0,infinitiveWord.length() - 1).toLowerCase())){
                    infinitiveWord = infinitiveWord.substring(0,infinitiveWord.length() - 1);
                }
            }
            // kiểm tra xem có phải là từ có kí tự cuối là e không ví dụ love -> loved , larger -> large
            if ((infinitiveWord.endsWith("ed") || infinitiveWord.endsWith("er")) && !dictionary.contains(infinitiveWord)){
                if (dictionary.contains(infinitiveWord.substring(0,infinitiveWord.length() - 1).toLowerCase())){
                    infinitiveWord = infinitiveWord.substring(0,infinitiveWord.length() - 1);
                }
            }
            // kiểm tra xem có phải là từ có kí tự cuối là e hoặc l ko
            if ((infinitiveWord.endsWith("est") || infinitiveWord.endsWith("ly")) && !dictionary.contains(infinitiveWord)){
                if (dictionary.contains(infinitiveWord.substring(0,infinitiveWord.length() - 2).toLowerCase())){
                    infinitiveWord = infinitiveWord.substring(0,infinitiveWord.length() - 2);
                }
            }

            if (!dictionary.contains(infinitiveWord.toLowerCase())){
                infinitiveWord = verbTensenHandling(infinitiveWord);
            }
            // kiểm tra từ có phải là số không
            boolean numeric = true;
            try {
                double num = Double.parseDouble(word);
            } catch (NumberFormatException e) {
                numeric = false;
            }
            String lowerCaseWord = infinitiveWord.toLowerCase();
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
    public void searchDictionary(String word, String fileName) {
        List<String> words = new ArrayList<>();

        for (String s : getWords(fileName)) {
            if (s.contains(word)) {
                words.add(s);
            }
        }
        if (words.isEmpty()){
            System.out.println("Không tìm thấy cụm \"" + word + "\" trong file từ điển." );
        }else {
            for (String s : words) {
                System.out.println(s);
            }
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
    public void addToFile(String word, String fileName) {
        if (Objects.equals(fileName, "english_dictionary.txt")){
            word = Character.toLowerCase(word.charAt(0)) + word.substring(1);
        }else {
            word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
        }
        if (dictionary.contains(word) || properNouns.contains(word)) {
            System.out.println("Từ đã tồn tại trong file.");
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.newLine();
                writer.write(word);

                System.out.println("Đã thêm từ mới vào file.");
            } catch (IOException e) {
                System.out.println("Không thể ghi vào file " + fileName);
            }
        }
    }
//------------------------- HÀM CHECK ------------------------------------
    public static String functuationHandling(String word){
        if (word.endsWith(".") || word.endsWith(",") || word.endsWith(":") ||
                word.endsWith(";") || word.endsWith("!") || word.endsWith("?")) {
            word = word.substring(0, word.length() - 1);
        }
        return word;
    }
    public static String verbTensenHandling(String word){
        if (word.endsWith("ses") || word.endsWith("xes") || word.endsWith("zes") || word.endsWith("shes") || word.endsWith("ches") || word.endsWith("oes") || word.endsWith("ly")){
            word = word.substring(0,word.length() - 2);
        }else if (word.endsWith("ies")){
            word = word.substring(0,word.length() - 3) + "y";
        }else if (word.endsWith("ing") || word.endsWith("ction") || word.endsWith("est") ){
            word= word.substring(0,word.length() - 3);
        }else if ( word.endsWith("ed") || word.endsWith("er")){
            word = word.substring(0,word.length() - 2);
        } else if (word.endsWith("able") || word.endsWith("ctions") || word.endsWith("ness")){
            word = word.substring(0,word.length() - 4);
        } else if (word.endsWith("ation") ){
            word = word.substring(0,word.length() - 3) + "e";
        } else if (word.endsWith("fication")){
            word = word.substring(0,word.length() - 7) + "y";
        } else if (word.endsWith("iness")){
            word = word.substring(0,word.length() - 5) + "y";
        } else if (word.endsWith("ations")){
            word = word.substring(0,word.length() - 4) + "e" ;
        } else if (word.endsWith("s")) {
            word = word.substring(0,word.length() - 1);
        } else if (word.endsWith("fications")){
            word = word.substring(0,word.length() - 8) + "y";
        }
        return word;
    }

}
