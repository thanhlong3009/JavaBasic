package xocdia_management.backend.repository.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepositRequest {
    private String email;
    private int amountDeposit;
}
