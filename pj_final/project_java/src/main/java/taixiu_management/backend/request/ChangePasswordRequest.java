package taixiu_management.backend.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ChangePasswordRequest {
    private String email;
    private String newPassword;
}
