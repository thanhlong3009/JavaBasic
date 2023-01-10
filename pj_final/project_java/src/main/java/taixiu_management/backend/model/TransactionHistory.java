package taixiu_management.backend.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionHistory {
    private String email;
    private String time;
    private int transactionCode;
    private int amount;
    private String content;
    private String status;
}
