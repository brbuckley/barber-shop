package dao;

import exception.NotExistException;
import lombok.Setter;
import model.Shop;

import javax.persistence.EntityManager;

public class ShopDao implements Dao<Shop> {

    @Setter
    private EntityManager em;

    public ShopDao(EntityManager entityManager) {
        setEm(entityManager);
    }

    @Override
    public Shop get(long id) throws NotExistException {
        Shop shop = em.find(Shop.class, id);
        if (shop != null) {
            return shop;
        } else {
            throw new NotExistException("Shop");
        }
    }

    @Override
    public void add(Shop shop) throws NotExistException {
        em.getTransaction().begin();
        em.persist(shop);
        em.getTransaction().commit();
    }

    @Override
    public void update(Shop shop) throws NotExistException {
        get(shop.getId());
        em.getTransaction().begin();
        em.merge(shop);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Shop shop) throws NotExistException {
        get(shop.getId());
        em.getTransaction().begin();
        em.merge(shop);
        em.getTransaction().commit();
    }
}
