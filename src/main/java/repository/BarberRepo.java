package repository;

import core.GetConnection;
import dao.BarberDao;
import exception.NotExistException;
import lombok.Setter;
import model.Barber;

import javax.persistence.EntityManager;

public class BarberRepo {

    @Setter
    private static BarberDao barberDao;

    public BarberRepo() {
        EntityManager em = GetConnection.getConnection("MyPersistence").getEm();
        setBarberDao(new BarberDao(em));
    }

    public BarberRepo(String persistence) {
        EntityManager em = GetConnection.getConnection(persistence).getEm();
        setBarberDao(new BarberDao(em));
    }

    public void add(Barber barber) throws NotExistException {
        barberDao.add(barber);
    }

    public Barber get(long id) throws NotExistException {
        return barberDao.get(id);
    }

    public void update(Barber barber) throws NotExistException {
        barberDao.update(barber);
    }

    public void remove(Barber barber) throws NotExistException {
        barberDao.remove(barber);
    }
}
