package taixiu_management.backend.controller;

import taixiu_management.backend.model.TransactionHistory;
import taixiu_management.backend.request.HistoryRequest;
import taixiu_management.backend.service.HistoryService;

import java.util.List;

public class HistoryController {
    private final HistoryService historyService = new HistoryService();


    // tạo lịch sử giao dịch
    public void updateHistory(HistoryRequest historyRequest) {
        historyService.updateHistory(historyRequest);
    }

    // Lấy ra lịch sử giao dịch của người chơi theo email
    public List<TransactionHistory> getHistories(String email) {
        return historyService.getHistories(email);
    }
}
