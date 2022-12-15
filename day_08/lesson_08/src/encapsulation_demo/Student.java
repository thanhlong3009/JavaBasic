package encapsulation_demo;

public class Student {
    private String id;
    private double avgPoint;
    private int age;
    private String grade;

    public Student() {
    }

    public Student(String id, double avgPoint, int age, String grade) {
        setId(id);
        setAge(age);
        setAvgPoint(avgPoint);
        setGrade(grade);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() != 8) {
            System.out.println("Nhập mã sinh viên không đúng");
            return;
        }
        this.id = id;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        if (avgPoint < 0.0 || avgPoint > 10.00) {
            System.out.println("Nhập điểm trung bình không chính xác");
            return;
        }
        this.avgPoint = avgPoint;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            System.out.println("Nhập tuổi không chính xacs");
        }
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        if (grade.charAt(0) != 'A' || grade.charAt(0) != 'C') {
            System.out.println("Nhập lớp không chính xác");
            return;
        }

        this.grade = grade;
    }

//    public void showInfo(Student std) {
//        System.out.println(std);
//    }

    public void showInfo() {
        System.out.println(this);
    }

    public void  calculateSchoolShip() {
        if (avgPoint <8) {
            System.out.println("bạn không nhận được học bổng");
        }else {
            System.out.println("Bạn đã nhận được học bổng");
        }
    }


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", avgPoint=" + avgPoint +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }
}
