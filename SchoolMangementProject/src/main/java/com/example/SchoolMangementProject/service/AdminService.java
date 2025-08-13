package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.entity.Admin;
import com.example.SchoolMangementProject.repo.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(String id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    public Admin createAdmin(Admin admin) {
        if (adminRepository.findByEmail(admin.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        admin.setPassword(passwordEncoder.encode(admin.getPassword())); // encrypt password
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(String id, Admin updatedAdmin) {
        Admin existing = getAdminById(id);
        existing.setFirstName(updatedAdmin.getFirstName());
        existing.setLastName(updatedAdmin.getLastName());
        existing.setEmail(updatedAdmin.getEmail());
        existing.setPhone(updatedAdmin.getPhone());
        if (updatedAdmin.getPassword() != null && !updatedAdmin.getPassword().isEmpty()) {
            existing.setPassword(passwordEncoder.encode(updatedAdmin.getPassword()));
        }
        return adminRepository.save(existing);
    }

    public void deleteAdmin(String id) {
        adminRepository.deleteById(id);
    }
}
