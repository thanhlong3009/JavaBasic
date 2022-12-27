package account_management.backend.model;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String userName;
    private String password;
    private String email;
}
