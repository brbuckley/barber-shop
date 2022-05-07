package core;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetConnection {

    private static GetConnection instance;
    @Getter
    private final EntityManager em;

    private GetConnection(String persistence) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence);
        this.em = emf.createEntityManager();
    }

    public static GetConnection getConnection(String persistence) {
        if (instance == null) {
            instance = new GetConnection(persistence);
        }
        return instance;
    }
}
