package app.service;

import app.model.Admin;
import app.repository.AdminRepo;
import java.util.List;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminService {

  @Setter private AdminRepo adminRepo;

  /** Custom constructor with spring injected repository. */
  public AdminService(AdminRepo adminRepo) {
    this.adminRepo = adminRepo;
  }

  public Admin getAdmin(long id) {
    // findBy() vs getBy()
    return adminRepo.findById(id).get();
  }

  public List<Admin> getAllAdmins() {
    return adminRepo.findAll();
  }

  public Admin postAdmin(Admin admin) {
    return adminRepo.save(admin);
  }

  public Admin updateAdmin(Admin admin) {
    Admin adminEntity = adminRepo.findById(admin.getId()).get();
    adminEntity = admin;
    adminRepo.save(adminEntity);
    return adminEntity;
  }

  public void deleteAdmin(long adminId) {
    adminRepo.deleteById(adminId);
  }
}
