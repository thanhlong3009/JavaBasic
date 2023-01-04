package xocdia_management.backend.database;

import xocdia_management.backend.model.Admin;
import xocdia_management.backend.model.Player;
import xocdia_management.backend.utlis.FileUtils;

import java.util.List;

public class AdminDB {
    public static List<Admin> admins = FileUtils.getDataFromFileAd("admins.json");
}
