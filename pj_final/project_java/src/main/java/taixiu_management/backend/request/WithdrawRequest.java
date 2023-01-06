package taixiu_management.backend.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WithdrawRequest {
    private String email;
    private int amountWithdraw;
}
