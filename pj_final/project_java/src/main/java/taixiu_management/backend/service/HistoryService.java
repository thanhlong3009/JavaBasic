package taixiu_management.backend.service;

import taixiu_management.backend.controller.HistoryController;
import taixiu_management.backend.model.TransactionHistory;
import taixiu_management.backend.repository.HistoryRepository;
import taixiu_management.backend.request.HistoryRequest;

import java.util.ArrayList;
import java.util.List;

public class HistoryService {
    private final HistoryRepository historyRepository = new HistoryRepository();

    List <TransactionHistory> transactionHistories = historyRepository.findAll();

    // Tạo lịch sủ giao dịch
    public void updateHistory(HistoryRequest historyRequest) {
        TransactionHistory history = new TransactionHistory();
        history.setEmail(historyRequest.getEmail());
        history.setTime(historyRequest.getTime());
        history.setTransactionCode(historyRequest.getTransactionCode());
        history.setAmount(historyRequest.getAmount());
        history.setContent(historyRequest.getContent());
        history.setStatus(historyRequest.getStatus());

        transactionHistories.add(history);
        historyRepository.updateFiles();

    }

    // Lấy ra danh sách lịch sử giao dịch của người chơi theo email
    public List<TransactionHistory> getHistories(String email) {
        List<TransactionHistory> rs = new ArrayList<>();
        for (TransactionHistory t: historyRepository.findAll()) {
            if (t.getEmail().equals(email)){
                rs.add(t);
            }
        }
        return rs;
    }
}
