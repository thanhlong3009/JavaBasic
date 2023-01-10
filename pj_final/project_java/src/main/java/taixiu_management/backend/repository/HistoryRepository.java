package taixiu_management.backend.repository;

import taixiu_management.backend.database.TransactionHistoryDB;
import taixiu_management.backend.model.TransactionHistory;
import taixiu_management.backend.utlis.FileUtils;

import java.util.List;

public class HistoryRepository {
    // lấy ra danh sách lịch sử giao dịch từ histories.json
    public List<TransactionHistory> findAll() {
        return TransactionHistoryDB.transactionHistories;
    }

    // update lịch sử giao dịch
    public void updateFiles() {
        FileUtils.setDataToFileHistory("histories.json",findAll());
    }

}
