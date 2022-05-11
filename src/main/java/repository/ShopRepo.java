package repository;

import core.GetConnection;
import dao.ShopDao;
import exception.NotExistException;
import lombok.Setter;
import model.Shop;

import javax.persistence.EntityManager;

public class ShopRepo {

    @Setter
    private static ShopDao shopDao;

    public ShopRepo() {
        EntityManager em = GetConnection.getConnection("MyPersistence").getEm();
        setShopDao(new ShopDao(em));
    }

    public ShopRepo(String persistence) {
        EntityManager em = GetConnection.getConnection(persistence).getEm();
        setShopDao(new ShopDao(em));
    }

    public void add(Shop shop) throws NotExistException {
        shopDao.add(shop);
    }

    public Shop get(long id) throws NotExistException {
        return shopDao.get(id);
    }

    public void update(Shop shop) throws NotExistException {
        shopDao.update(shop);
    }

    public void remove(Shop shop) throws NotExistException {
        shopDao.remove(shop);
    }
}
