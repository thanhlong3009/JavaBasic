package xocdia_management.backend.controller;

import xocdia_management.backend.model.Admin;
import xocdia_management.backend.repository.request.LoginRequest;
import xocdia_management.backend.service.AdminService;

import java.util.List;

public class AdminController {
    private final AdminService adminService = new AdminService();

    public  List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    public Admin findAdminByEmail(String email) {
        return adminService.findAdminByEmail(email);
    }

    public boolean checkLogin(LoginRequest loginRequest) {
        return adminService.checkLogin(loginRequest);
    }
}
