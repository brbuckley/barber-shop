package app.service;

import app.model.Customer;
import app.repository.CustomerRepo;
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
public class CustomerService {

  private ObjectMapper mapper;
  @Setter private RestTemplate restTemplate;

  @Setter private CustomerRepo customerRepo;

  /** Custom constructor with spring injected repository. */
  public CustomerService(CustomerRepo customerRepo) {
    this.restTemplate = new RestTemplateBuilder().build();
    this.customerRepo = customerRepo;
    this.mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    this.mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
    this.mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
  }

  public Customer getCustomer(long id) throws JsonProcessingException {
    // findBy() vs getBy()
    return customerRepo.findById(id).get();
  }

  public Customer postCustomer(Customer customer) throws JsonProcessingException {
    return customerRepo.save(customer);
  }

  public Customer updateCustomer(Customer customer){
    Customer customerEntity = customerRepo.findById(customer.getId()).get();
    customerEntity=customer;
    customerRepo.save(customerEntity);
    return customerEntity;
  }

}
