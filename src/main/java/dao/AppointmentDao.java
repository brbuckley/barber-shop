package dao;

import exception.NotExistException;
import lombok.Setter;
import model.Appointment;
import model.Appointment;

import javax.persistence.EntityManager;

public class AppointmentDao implements Dao<Appointment> {

    @Setter
    private EntityManager em;

    public AppointmentDao(EntityManager entityManager) {
        setEm(entityManager);
    }

    @Override
    public Appointment get(long id) throws NotExistException {
        Appointment appointment = em.find(Appointment.class, id);
        if (appointment != null) {
            return appointment;
        } else {
            throw new NotExistException("Appointment");
        }
    }

    @Override
    public void add(Appointment appointment) throws NotExistException {
        em.getTransaction().begin();
        em.persist(appointment);
        em.getTransaction().commit();
    }

    @Override
    public void update(Appointment appointment) throws NotExistException {
        get(appointment.getId());
        em.getTransaction().begin();
        em.merge(appointment);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Appointment appointment) throws NotExistException {
        get(appointment.getId());
        em.getTransaction().begin();
        em.merge(appointment);
        em.getTransaction().commit();
    }
}
