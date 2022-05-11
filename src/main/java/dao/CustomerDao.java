package dao;

import exception.NotExistException;
import lombok.Setter;
import model.Customer;

import javax.persistence.EntityManager;

public class CustomerDao implements Dao<Customer> {

    @Setter
    private EntityManager em;

    public CustomerDao(EntityManager entityManager) {
        setEm(entityManager);
    }

    @Override
    public Customer get(long id) throws NotExistException {
        Customer customer = em.find(Customer.class, id);
        if (customer != null) {
            return customer;
        } else {
            throw new NotExistException("Customer");
        }
    }

    @Override
    public void add(Customer customer) throws NotExistException {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public void update(Customer customer) throws NotExistException {
        get(customer.getId());
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Customer customer) throws NotExistException {
        get(customer.getId());
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }
}
