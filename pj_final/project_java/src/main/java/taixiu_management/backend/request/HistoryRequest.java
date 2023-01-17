package taixiu_management.backend.request;

import lombok.*;
import taixiu_management.backend.model.Status;

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
    private Status status;
}
