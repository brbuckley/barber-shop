package repository;

import core.GetConnection;
import dao.AppointmentDao;
import exception.NotExistException;
import lombok.Setter;
import model.Appointment;

import javax.persistence.EntityManager;

public class AppointmentRepo {
    @Setter
    private static AppointmentDao appointmentDao;

    public AppointmentRepo() {
        EntityManager em = GetConnection.getConnection("MyPersistence").getEm();
        setAppointmentDao(new AppointmentDao(em));
    }

    public AppointmentRepo(String persistence) {
        EntityManager em = GetConnection.getConnection(persistence).getEm();
        setAppointmentDao(new AppointmentDao(em));
    }

    public void add(Appointment appointment) throws NotExistException {
        appointmentDao.add(appointment);
    }

    public Appointment get(long id) throws NotExistException {
        return appointmentDao.get(id);
    }

    public void update(Appointment appointment) throws NotExistException {
        appointmentDao.update(appointment);
    }

    public void remove(Appointment appointment) throws NotExistException {
        appointmentDao.remove(appointment);
    }
}
