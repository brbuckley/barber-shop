package repository;

import core.GetConnection;
import dao.HaircutDao;
import exception.NotExistException;
import lombok.Setter;
import model.Haircut;

import javax.persistence.EntityManager;

public class HaircutRepo {
    @Setter
    private static HaircutDao haircutDao;

    public HaircutRepo() {
        EntityManager em = GetConnection.getConnection("MyPersistence").getEm();
        setHaircutDao(new HaircutDao(em));
    }

    public HaircutRepo(String persistence) {
        EntityManager em = GetConnection.getConnection(persistence).getEm();
        setHaircutDao(new HaircutDao(em));
    }

    public void add(Haircut haircut) throws NotExistException {
        haircutDao.add(haircut);
    }

    public Haircut get(long id) throws NotExistException {
        return haircutDao.get(id);
    }

    public void update(Haircut haircut) throws NotExistException {
        haircutDao.update(haircut);
    }

    public void remove(Haircut haircut) throws NotExistException {
        haircutDao.remove(haircut);
    }
}
