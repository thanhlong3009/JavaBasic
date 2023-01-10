package taixiu_management.backend.database;

import taixiu_management.backend.model.TransactionHistory;
import taixiu_management.backend.utlis.FileUtils;

import java.util.List;

public class TransactionHistoryDB {
    public static List<TransactionHistory> transactionHistories = FileUtils.getDataFromFileHistory("histories.json");
}
