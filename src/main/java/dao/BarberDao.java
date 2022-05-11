package dao;

import exception.NotExistException;
import lombok.Setter;
import model.Barber;

import javax.persistence.EntityManager;

public class BarberDao implements Dao<Barber> {

    @Setter
    private EntityManager em;

    public BarberDao(EntityManager entityManager) {
        setEm(entityManager);
    }

    @Override
    public Barber get(long id) throws NotExistException {
        Barber barber = em.find(Barber.class, id);
        if (barber != null) {
            return barber;
        } else {
            throw new NotExistException("Barber");
        }
    }

    @Override
    public void add(Barber barber) throws NotExistException {
        em.getTransaction().begin();
        em.persist(barber);
        em.getTransaction().commit();
    }

    @Override
    public void update(Barber barber) throws NotExistException {
        get(barber.getId());
        em.getTransaction().begin();
        em.merge(barber);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Barber barber) throws NotExistException {
        get(barber.getId());
        em.getTransaction().begin();
        em.merge(barber);
        em.getTransaction().commit();
    }
}
