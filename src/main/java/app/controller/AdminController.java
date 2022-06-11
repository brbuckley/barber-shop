package app.controller;

import app.model.Admin;
import app.repository.AdminRepo;
import app.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    /**
     * GET request for admin by id.
     *
     * @param id The id of the admin.
     * @return Admin.
     * @throws JsonProcessingException Exceptions while parsing the JSON response.
     */
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),
            })
    @ApiOperation(value = "Search admin by ID.", response = Admin.class)
    @GetMapping(value = "/{adminId}", produces = "application/json")
    public ResponseEntity getAdmin(@PathVariable(value = "adminId") long id)
            throws JsonProcessingException {
        return new ResponseEntity(new AdminService(adminRepo).getAdmin(id), HttpStatus.OK);
    }

    /**
     * POST request to add a new Admin.
     *
     * @param id The id of the admin.
     * @return Admin.
     * @throws JsonProcessingException Exceptions while parsing the JSON response.
     */
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),
            })
    @ApiOperation(value = "Creates a new admin.", response = Admin.class)
    @PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity getAdmin(@RequestBody Admin admin) throws JsonProcessingException {
        return new ResponseEntity(
                new AdminService(adminRepo).postAdmin(admin), HttpStatus.OK);
    }

    @PutMapping(value="/update", produces = "application/json")
    public ResponseEntity updateAdmin(@RequestBody Admin admin) throws JsonProcessingException {
        return new ResponseEntity(
                new AdminService(adminRepo).updateAdmin(admin), HttpStatus.OK);
    }

    @DeleteMapping(value="/delete/{barberId}")
    public ResponseEntity deleteAdmin(@PathVariable(value = "adminId") long id) {
        AdminService adminService = new AdminService(adminRepo);
        adminService.deleteAdmin(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
