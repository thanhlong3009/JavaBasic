package taixiu_management.backend.request;

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
    private String passwordWithdaw;
}
