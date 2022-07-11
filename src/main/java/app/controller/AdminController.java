package app.controller;

import app.model.Admin;
import app.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Controller for Admin services. */
@RestController
@RequestMapping("/admin")
public class AdminController {

  private AdminService adminService;

  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  @ApiOperation(value = "Search admin by ID.", response = Admin.class)
  @GetMapping(value = "/{adminId}", produces = "application/json")
  public ResponseEntity getAdmin(@PathVariable(value = "adminId") long id) {
    return new ResponseEntity(adminService.getAdmin(id), HttpStatus.OK);
  }

  @GetMapping(value = "/all", produces = "application/json")
  public ResponseEntity getAllAdmins() {
    return new ResponseEntity(adminService.getAllAdmins(), HttpStatus.OK);
  }

  @ApiOperation(value = "Creates a new admin.", response = Admin.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity postAdmin(@RequestBody Admin admin) {
    return new ResponseEntity(adminService.postAdmin(admin), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates an admin.", response = Admin.class)
  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateAdmin(@RequestBody Admin admin) {
    return new ResponseEntity(adminService.updateAdmin(admin), HttpStatus.OK);
  }

  @ApiOperation(value = "Deletes an admin.")
  @DeleteMapping(value = "/delete/{adminId}")
  public ResponseEntity deleteAdmin(@PathVariable(value = "adminId") long adminId) {
    adminService.deleteAdmin(adminId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
