package app.controller;

import app.model.Admin;
import app.repository.AdminRepo;
import app.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Controller for Admin services. */
@RestController
@RequestMapping("/admin")
public class AdminController {

  private AdminRepo adminRepo;

  public AdminController(AdminRepo adminRepo) {
    this.adminRepo = adminRepo;
  }

  @ApiOperation(value = "Search admin by ID.", response = Admin.class)
  @GetMapping(value = "/{adminId}", produces = "application/json")
  public ResponseEntity getAdmin(@PathVariable(value = "adminId") long id)
      throws JsonProcessingException {
    return new ResponseEntity(new AdminService(adminRepo).getAdmin(id), HttpStatus.OK);
  }

  @ApiOperation(value = "Creates a new admin.", response = Admin.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity getAdmin(@RequestBody Admin admin) throws JsonProcessingException {
    return new ResponseEntity(new AdminService(adminRepo).postAdmin(admin), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates an admin.", response = Admin.class)
  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateAdmin(@RequestBody Admin admin) {
    return new ResponseEntity(new AdminService(adminRepo).updateAdmin(admin), HttpStatus.OK);
  }

  @ApiOperation(value = "Deletes an admin.")
  @DeleteMapping(value = "/delete/{adminId}")
  public ResponseEntity deleteAdmin(@PathVariable(value = "adminId") long adminId) {
    AdminService adminService = new AdminService(adminRepo);
    adminService.deleteAdmin(adminId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
