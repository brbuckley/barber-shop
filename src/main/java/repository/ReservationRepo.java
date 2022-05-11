package repository;

import core.GetConnection;
import dao.ReservationDao;
import exception.NotExistException;
import lombok.Setter;
import model.Reservation;

import javax.persistence.EntityManager;

public class ReservationRepo {
    @Setter
    private static ReservationDao reservationDao;

    public ReservationRepo() {
        EntityManager em = GetConnection.getConnection("MyPersistence").getEm();
        setReservationDao(new ReservationDao(em));
    }

    public ReservationRepo(String persistence) {
        EntityManager em = GetConnection.getConnection(persistence).getEm();
        setReservationDao(new ReservationDao(em));
    }

    public void add(Reservation reservation) throws NotExistException {
        reservationDao.add(reservation);
    }

    public Reservation get(long id) throws NotExistException {
        return reservationDao.get(id);
    }

    public void update(Reservation reservation) throws NotExistException {
        reservationDao.update(reservation);
    }

    public void remove(Reservation reservation) throws NotExistException {
        reservationDao.remove(reservation);
    }
}
