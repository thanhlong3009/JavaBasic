package xocdia_management.backend.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player {
    private String userName;
    private String email;
    private String password;
    private int accountBalance = 0;
}
