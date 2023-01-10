package taixiu_management.backend.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HistoryRequest {
    private String email;
    private String time;
    private int transactionCode;
    private int amount;
    private String content;
    private String status;
}
