package dao;

import exception.NotExistException;
import lombok.Setter;
import model.Haircut;

import javax.persistence.EntityManager;

public class HaircutDao implements Dao<Haircut> {

    @Setter
    private EntityManager em;

    public HaircutDao(EntityManager entityManager) {
        setEm(entityManager);
    }

    @Override
    public Haircut get(long id) throws NotExistException {
        Haircut haircut = em.find(Haircut.class, id);
        if (haircut != null) {
            return haircut;
        } else {
            throw new NotExistException("Haircut");
        }
    }

    @Override
    public void add(Haircut haircut) throws NotExistException {
        em.getTransaction().begin();
        em.persist(haircut);
        em.getTransaction().commit();
    }

    @Override
    public void update(Haircut haircut) throws NotExistException {
        get(haircut.getId());
        em.getTransaction().begin();
        em.merge(haircut);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Haircut haircut) throws NotExistException {
        get(haircut.getId());
        em.getTransaction().begin();
        em.merge(haircut);
        em.getTransaction().commit();
    }
}
