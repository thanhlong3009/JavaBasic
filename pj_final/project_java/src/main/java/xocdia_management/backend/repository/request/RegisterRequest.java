package xocdia_management.backend.repository.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterRequest {
    private String userName;
    private String email;
    private String password;
    private int accountBalance = 0;
}
