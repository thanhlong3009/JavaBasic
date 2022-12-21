package employee_manager.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Employee {
    private int id;
    private String name;
    private String email;
    private int salary;
}
