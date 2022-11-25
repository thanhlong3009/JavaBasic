import java.sql.SQLOutput;

public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.PI);
        System.out.println(Math.ceil(3.3));//   -> 4
        System.out.println((Math.round(3.4)));


        System.out.println(Math.min(3, 8));
        System.out.println(Math.pow(5, 2));
        System.out.println(Math.random());

        //cong thuc tinh random 1 so nguyen ( 0 - n )
        int randomNumber = (int) Math.floor(Math.random() * 100);
        //cong thuc tinh random 1 so nguyen ( 100 - 999 )
        int randomNumber1 = (int) Math.floor(Math.random() * (999 - 100 + 1) + 100);
        System.out.println(randomNumber1);

    }
}
