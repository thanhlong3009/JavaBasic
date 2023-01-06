package xocdia_management.backend.request;

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
