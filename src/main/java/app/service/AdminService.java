package app.service;

import app.model.Admin;
import app.repository.AdminRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class AdminService {

  private ObjectMapper mapper;
  @Setter private RestTemplate restTemplate;

  @Setter private AdminRepo adminRepo;

  /** Custom constructor with spring injected repository. */
  public AdminService(AdminRepo adminRepo) {
    this.restTemplate = new RestTemplateBuilder().build();
    this.adminRepo = adminRepo;
    this.mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    this.mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
    this.mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
  }

  public Admin getAdmin(long id) throws JsonProcessingException {
    // findBy() vs getBy()
    return adminRepo.findById(id).get();
  }

  public Admin postAdmin(Admin admin) throws JsonProcessingException {
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
