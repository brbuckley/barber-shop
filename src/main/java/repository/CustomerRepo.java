package repository;

import core.GetConnection;
import dao.CustomerDao;
import exception.NotExistException;
import lombok.Setter;
import model.Customer;

import javax.persistence.EntityManager;

public class CustomerRepo {

    @Setter
    private static CustomerDao customerDao;

    public CustomerRepo() {
        EntityManager em = GetConnection.getConnection("MyPersistence").getEm();
        setCustomerDao(new CustomerDao(em));
    }

    public CustomerRepo(String persistence) {
        EntityManager em = GetConnection.getConnection(persistence).getEm();
        setCustomerDao(new CustomerDao(em));
    }

    public void add(Customer customer) throws NotExistException {
        customerDao.add(customer);
    }

    public Customer get(long id) throws NotExistException {
        return customerDao.get(id);
    }

    public void update(Customer customer) throws NotExistException {
        customerDao.update(customer);
    }

    public void remove(Customer customer) throws NotExistException {
        customerDao.remove(customer);
    }
}
