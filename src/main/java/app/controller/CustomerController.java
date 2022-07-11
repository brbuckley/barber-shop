package app.controller;

import app.model.Customer;
import app.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Controller for Customer services. */
@RestController
@RequestMapping("/customer")
public class CustomerController {

  private CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @ApiOperation(value = "Search customer by ID.", response = Customer.class)
  @GetMapping(value = "/{customerId}", produces = "application/json")
  public ResponseEntity getCustomer(@PathVariable(value = "customerId") long id) {
    return new ResponseEntity(customerService.getCustomer(id), HttpStatus.OK);
  }

  @GetMapping(value = "/all", produces = "application/json")
  public ResponseEntity getAllCustomers() {
    return new ResponseEntity(customerService.getAllCustomers(), HttpStatus.OK);
  }

  @ApiOperation(value = "Creates a new customer.", response = Customer.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity postCustomer(@RequestBody Customer customer) {
    return new ResponseEntity(customerService.postCustomer(customer), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates a customer.", response = Customer.class)
  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateCustomer(@RequestBody Customer customer) {
    return new ResponseEntity(customerService.updateCustomer(customer), HttpStatus.OK);
  }

  @ApiOperation(value = "Deletes a customer.")
  @DeleteMapping(value = "/delete/{customerId}", produces = "application/json")
  public ResponseEntity deleteCustomer(@PathVariable(value = "customerId") long customerId) {
    customerService.deleteCustomer(customerId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
