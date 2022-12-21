package exception_demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedException {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("text.txt");
        System.out.println(file.getName());

        FileReader fileReader = new FileReader(file);
    }
}
