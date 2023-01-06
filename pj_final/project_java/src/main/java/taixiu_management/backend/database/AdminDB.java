package taixiu_management.backend.database;

import taixiu_management.backend.model.Admin;
import taixiu_management.backend.utlis.FileUtils;

import java.util.List;

public class AdminDB {
    public static List<Admin> admins = FileUtils.getDataFromFileAd("admins.json");
}
