package app.controller;

import app.exception.NotExistException;
import app.model.Customer;
import app.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ApiOperation(value = "Checks what is the class of the user, if it exists and returns a user.", response = Customer.class)
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity getCustomer(@RequestParam(value = "email") String email, @RequestParam(value = "password-hash") String passwordHash)
            throws NotExistException {
        Object user = loginService.getUser(email,passwordHash);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Object-Class", user.getClass().getSimpleName());
        return ResponseEntity.ok().headers(responseHeaders).body(user);
    }

}
