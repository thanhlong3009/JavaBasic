import java.util.List;
import java.util.Scanner;

public class HomeUI {


    public void run() {
        String properNounFile = "proper_nouns.txt";
        String dictionaryFile = "english_dictionary.txt";
        SpellingChecker checker = new SpellingChecker(properNounFile, dictionaryFile);
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            menu();
            System.out.println();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                System.out.println();
                continue;
            }
            switch (option) {
                case 1: {
                    boolean subIsQuit = false;
                    int subOption = 0;
                    while (!subIsQuit) {
                        subMenu();
                        try {
                            System.out.print("Nhập lựa chọn : ");
                            subOption = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Lựa chọn không hợp lệ");
                            System.out.println();
                            continue;
                        }
                        switch (subOption) {
                            case 1: {
                                String textFile = "check1.txt";
                                System.out.println("------ KẾT QUẢ ------");
                                checker.checkSpellingByTextFile(textFile);
                                System.out.println();
                                break;
                            }
                            case 2: {
                                String textFile = "check2.txt";
                                System.out.println("------ KẾT QUẢ ------");
                                checker.checkSpellingByTextFile(textFile);
                                System.out.println();
                                break;
                            }
                            case 3: {
                                String textFile = "check3.txt";
                                System.out.println("------ KẾT QUẢ ------");
                                checker.checkSpellingByTextFile(textFile);
                                System.out.println();
                                break;
                            }
                            case 0: {
                                subIsQuit =true;
                                System.out.println("Quay lại!!!");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("------ KIỂM TRA CÂU NHẬP TỪ BÀN PHÍM ------");
                    System.out.println(" Nhập câu tiếng Anh cần kiểm tra: ");
                    String text = sc.nextLine();
                    System.out.println("------ KẾT QUẢ ------");
                    checker.checkSpellingByKeyboard(text);
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.println("------ TÌM KIẾM TỪ VỰNG -------");
                    System.out.println("Nhập gợi ý tìm kiếm:  ");
                    String word = sc.nextLine();
                    System.out.println("------ Danh sách các từ vựng tìm thấy ------");
                    checker.searchDictionary(word,"english_dictionary.txt");

                    break;
                }
                case 4: {
                    System.out.println("------ TÌM KIẾM DANH TỪ RIÊNG -------");
                    System.out.println("Nhập gợi ý tìm kiếm:  ");
                    String word = sc.nextLine();
                    System.out.println("------ Danh sách các danh từ riêng tìm thấy ------");
                    checker.searchDictionary(word,"proper_nouns.txt");

                    break;
                }
                case 5: {
                    System.out.println("------ THÊM TỪ MỚI VÀO FILE TỪ ĐIỂN ------");
                    System.out.println("Nhập từ mới cần thêm vào file từ điển");
                    String word = sc.nextLine();
                    checker.addToFile(word,"english_dictionary.txt");
                    break;
                }
                case 6: {
                    System.out.println("------ THÊM TỪ MỚI VÀO FILE DANH TỪ RIÊNG ------");
                    System.out.println("Nhập từ mới cần thêm vào file danh từ riêng");
                    String word = sc.nextLine();
                    checker.addToFile(word,"proper_nouns.txt");
                    break;
                }
                case 0: {
                    isQuit = true;
                    System.out.println("Thoát");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ, nhập lại");
                }
            }
        }
    }


    private static void subMenu() {
        System.out.println("------- DANH SÁCH CÁC FILE KIỂM TRA ------");
        System.out.println("1. check1.txt");
        System.out.println("2. check2.txt");
        System.out.println("3. check3.txt");
        System.out.println("0. Quay lại");
    }

    private static void menu() {
        System.out.println("-------- TỪ ĐIỂN TIẾNG ANH---------");
        System.out.println("1. Kiểm tra đầu vào từ 1 file cho sẵn");
        System.out.println("2. Kiểm tra chính tả câu tiếng Anh");
        System.out.println("3. Tìm kiếm từ điển tiếng Anh");
        System.out.println("4. Tìm kiếm từ điển danh từ riêng");
        System.out.println("5. Bổ sung từ điển tiếng Anh");
        System.out.println("6. Bổ sung từ điển danh từ riêng");
        System.out.println("0. Thoát");
    }
}
