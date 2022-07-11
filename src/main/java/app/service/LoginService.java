package app.service;

import app.exception.NotExistException;
import app.model.Admin;
import app.model.Barber;
import app.model.Customer;
import app.repository.AdminRepo;
import app.repository.BarberRepo;
import app.repository.CustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private AdminRepo adminRepo;
  private BarberRepo barberRepo;
  private CustomerRepo customerRepo;

  public LoginService(AdminRepo adminRepo, BarberRepo barberRepo, CustomerRepo customerRepo) {
    this.adminRepo = adminRepo;
    this.barberRepo = barberRepo;
    this.customerRepo = customerRepo;
  }

  public Object getUser(String email, String passwordHash) throws NotExistException {
    Customer customer = customerRepo.getCustomerByEmailAndPasswordHash(email, passwordHash);
    if (customer != null) {
      return customer;
    }
    Barber barber = barberRepo.getBarberByEmailAndPasswordHash(email, passwordHash);
    if (barber != null) {
      return barber;
    }
    Admin admin = adminRepo.getAdminByEmailAndPasswordHash(email, passwordHash);
    if (admin != null) {
      return admin;
    }
    throw new NotExistException("User");
  }
}
