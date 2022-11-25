public class Main {
    public static String globalVar = "Global variable";

    // pham vi global: khai bao ben ngoai method
    // pham vi method: khai bao ben trong method
    // pham vi block: khai bao ben trong dau {}
    public static void main(String[] args) {
        // Khai bao bien

        String firstName;
        String lastName;
        String email = "thanhlongite6@gmail.com";

        // gan gia tri cho bien

        firstName = "Long";
        lastName = "Tran";
        String fullName = firstName + " " + lastName;
        int age = 22;
        String address = "Hai Duong";

        System.out.println("firstname = " + firstName);
        System.out.println("lastname = " + lastName);
        System.out.println("fullname = " + fullName);
        System.out.println("Xin chao toi ten la " + fullName + ". Nam nay toi " + age + "tuoi. Que toi o " + address + ".");

        //Khai bao cac kieu dữ liệu
        long salary = 1_000_000_000L;
        float height = 1.7f;


        boolean isExist = true;
        boolean isMarry = false;

        char characterA = 'A';
        char characterB = 66; // tra bang ma ASCII
        System.out.println(characterA + " " + characterB);

        //ep kieu trong java
        //ep kieu ngam dinh( nho -> lon )
        int number = 10;
        long numberOne = number;

        // ep kieu tuong minh
        short numberTwo = (short) number;


        // goi bien global
        System.out.println(globalVar);

        //pham vi block
        {

            String blockVar = "Block Var ";
            System.out.println(blockVar);
        }
//        System.out.println(blockVar);   // ngoai pham vi su dung
//        System.out.println(blockVar);
    }

}


// Java code -> ByteCode -> Mã máy -> thực thi