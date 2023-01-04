package xocdia_management.backend.repository;

import xocdia_management.backend.database.AdminDB;
import xocdia_management.backend.database.PlayerDB;
import xocdia_management.backend.model.Admin;
import xocdia_management.backend.model.Player;

import java.util.List;

public class AdminRepository {


    public List<Admin> findAll() {
        return AdminDB.admins;
    }
}
