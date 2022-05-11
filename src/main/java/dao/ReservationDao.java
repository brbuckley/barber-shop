package dao;

import exception.NotExistException;
import lombok.Setter;
import model.Reservation;
import model.Reservation;

import javax.persistence.EntityManager;

public class ReservationDao implements Dao<Reservation>{

    @Setter
    private EntityManager em;

    public ReservationDao(EntityManager entityManager) {
        setEm(entityManager);
    }

    @Override
    public Reservation get(long id) throws NotExistException {
        Reservation reservation = em.find(Reservation.class, id);
        if (reservation != null) {
            return reservation;
        } else {
            throw new NotExistException("Reservation");
        }
    }

    @Override
    public void add(Reservation reservation) throws NotExistException {
        em.getTransaction().begin();
        em.persist(reservation);
        em.getTransaction().commit();
    }

    @Override
    public void update(Reservation reservation) throws NotExistException {
        get(reservation.getId());
        em.getTransaction().begin();
        em.merge(reservation);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Reservation reservation) throws NotExistException {
        get(reservation.getId());
        em.getTransaction().begin();
        em.merge(reservation);
        em.getTransaction().commit();
    }
}
