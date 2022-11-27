import java.util.Locale;

public class StringDemo {
    public static void main(String[] args) {
        // Khai bao theo kieu literal
        // khi các biến cùng giá trị sẽ cùng tham chiếu đến một ô nhớ,
        String name = "Thanh Long";
        String name1 = "Thanh Long";


        // Khai báo kiểu Object (new)
        // mỗi biết sẽ có một ô nhớ khác nhau
        String email = new String("thanhlongite6@gmail.com");
        String email1 = new String("thanhlongite6@gmail.com");

    //
        System.out.println(name);
        System.out.println(email);
        //So sánh chuỗi
        // == so sanh về địa chỉ ô nhớ( thường được áp dụng với primative type)
        System.out.println( name == name1);
        System.out.println( email == email1);



        //Phương thứ String
        String text = "Xin chao cac ban";
        String text1 = "Xin chao cac ban";
        String text2 = "Xin cHao cAc ban";


        System.out.println("In hoa: " + text.toUpperCase());
        System.out.println("In thuong: " + text.toLowerCase());
        System.out.println("Do dai : " + text.length());
        System.out.println("Cat chuoi : " + text.substring(0,8));
        System.out.println("Vị trí số 10 là ký tự : " + text.charAt(9));
        System.out.println("So sanhs : " + email1.equals(email));
        System.out.println("So sanhs không phân biệt hoa thường : " + text.equalsIgnoreCase(text2));







    }
}
