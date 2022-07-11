package app.service;

import app.model.Customer;
import app.repository.CustomerRepo;
import java.util.List;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

  @Setter private CustomerRepo customerRepo;

  /** Custom constructor with spring injected repository. */
  public CustomerService(CustomerRepo customerRepo) {
    this.customerRepo = customerRepo;
  }

  public Customer getCustomer(long id) {
    // findBy() vs getBy()
    return customerRepo.findById(id).get();
  }

  public List<Customer> getAllCustomers() {
    return customerRepo.findAll();
  }

  public Customer postCustomer(Customer customer) {
    return customerRepo.save(customer);
  }

  public Customer updateCustomer(Customer customer) {
    Customer customerEntity = customerRepo.findById(customer.getId()).get();
    customerEntity = customer;
    customerRepo.save(customerEntity);
    return customerEntity;
  }

  public void deleteCustomer(long customerId) {
    customerRepo.deleteById(customerId);
  }
}
