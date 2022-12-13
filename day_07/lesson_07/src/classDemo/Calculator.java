package classDemo;


public class Calculator {
    public int number1;
    public int number2;

    public void printInfo() {
        System.out.println(number1 + ", " + number2);
    }

    public int addition() {
        return  number1 + number2;
    }

    public int subtract() {
        return number1 - number2;
    }

    public int multi() {
        return number1*number2;
    }

    public double division() {
        double result = 0;
        try {
            result = (double) (number1 / number2);
            return result;
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
