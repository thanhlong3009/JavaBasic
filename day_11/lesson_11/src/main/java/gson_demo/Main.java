package gson_demo;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng gson
        Gson gson = new Gson();

        // Tạo chuỗi Json
        String studentJson = """
            {
                "id": 1,
                "name": "Bùi Hiên",
                "age": 25,
                "email": "hien@techmaster.vn"
            }""";

        // Binding chuỗi json vào class
        Student student = gson.fromJson(studentJson, Student.class);

        // In ra thông tin của đối tượng
        System.out.println(student);


        Student student1 = gson.fromJson(studentJson, Student.class);
        System.out.println(student1);
    }
}
