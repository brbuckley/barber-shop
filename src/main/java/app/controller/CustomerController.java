package app.controller;

import app.model.Customer;
import app.repository.CustomerRepo;
import app.service.CustomerService;
import app.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

  private CustomerRepo customerRepo;

  public CustomerController(CustomerRepo customerRepo) {
    this.customerRepo = customerRepo;
  }

  /**
   * GET request for customer by id.
   *
   * @param id The id of the customer.
   * @return Customer.
   * @throws JsonProcessingException Exceptions while parsing the JSON response.
   */
  @ApiResponses(
      value = {
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
      })
  @ApiOperation(value = "Search customer by ID.", response = Customer.class)
  @GetMapping(value = "/{customerId}", produces = "application/json")
  public ResponseEntity getCustomer(@PathVariable(value = "customerId") long id)
      throws JsonProcessingException {
    return new ResponseEntity(new CustomerService(customerRepo).getCustomer(id), HttpStatus.OK);
  }

  /**
   * POST request to add a new Customer.
   *
   * @param id The id of the customer.
   * @return Customer.
   * @throws JsonProcessingException Exceptions while parsing the JSON response.
   */
  @ApiResponses(
      value = {
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
      })
  @ApiOperation(value = "Creates a new customer.", response = Customer.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity getCustomer(@RequestBody Customer customer) throws JsonProcessingException {
    return new ResponseEntity(
        new CustomerService(customerRepo).postCustomer(customer), HttpStatus.OK);
  }

  @PutMapping(value="/update", produces = "application/json")
  public ResponseEntity updateCustomer(@RequestBody Customer customer) throws JsonProcessingException {
    return new ResponseEntity(
            new CustomerService(customerRepo).updateCustomer(customer), HttpStatus.OK);
  }

  @DeleteMapping(value="/delete/{customerId}", produces = "application/json")
  public ResponseEntity deleteCustomer(@PathVariable(value = "customerId") long customerId) throws JsonProcessingException {
    new CustomerService(customerRepo).deleteCustomer(customerId);
    return new ResponseEntity(HttpStatus.OK);
  }

}
