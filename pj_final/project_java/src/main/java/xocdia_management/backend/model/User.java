package xocdia_management.backend.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String userName;
    private String email;
    private String password;
}
