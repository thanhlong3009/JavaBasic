package taixiu_management.backend.repository;

import taixiu_management.backend.database.AdminDB;
import taixiu_management.backend.model.Admin;

import java.util.List;

public class AdminRepository {

    public List<Admin> findAll() {
        return AdminDB.admins;
    }
}
