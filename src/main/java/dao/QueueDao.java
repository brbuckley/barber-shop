package dao;

import exception.NotExistException;
import lombok.Setter;
import model.Queue;
import model.Queue;

import javax.persistence.EntityManager;

public class QueueDao implements Dao<Queue> {

    @Setter
    private EntityManager em;

    public QueueDao(EntityManager entityManager) {
        setEm(entityManager);
    }

    @Override
    public Queue get(long id) throws NotExistException {
        Queue queue = em.find(Queue.class, id);
        if (queue != null) {
            return queue;
        } else {
            throw new NotExistException("Queue");
        }
    }

    @Override
    public void add(Queue queue) throws NotExistException {
        em.getTransaction().begin();
        em.persist(queue);
        em.getTransaction().commit();
    }

    @Override
    public void update(Queue queue) throws NotExistException {
        get(queue.getId());
        em.getTransaction().begin();
        em.merge(queue);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Queue queue) throws NotExistException {
        get(queue.getId());
        em.getTransaction().begin();
        em.merge(queue);
        em.getTransaction().commit();
    }
}
