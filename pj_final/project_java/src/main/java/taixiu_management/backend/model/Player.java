package taixiu_management.backend.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player extends User{
    private int accountBalance = 0;
    private String passwordWithdaw;
    private int totalBet = 0;
    private int bettingProfit = 0;


}
