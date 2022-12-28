package method_reference;

import lombok.*;

@FunctionalInterface
interface IStudent {
    void display();
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private int id;
    private String name;
    private String email;

    public void printInfo() {
        System.out.println(id + " - " + name + " - " + email);
    }
}