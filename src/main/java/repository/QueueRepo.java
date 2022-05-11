package repository;

import core.GetConnection;
import dao.QueueDao;
import exception.NotExistException;
import lombok.Setter;
import model.Queue;

import javax.persistence.EntityManager;

public class QueueRepo {
    @Setter
    private static QueueDao queueDao;

    public QueueRepo() {
        EntityManager em = GetConnection.getConnection("MyPersistence").getEm();
        setQueueDao(new QueueDao(em));
    }

    public QueueRepo(String persistence) {
        EntityManager em = GetConnection.getConnection(persistence).getEm();
        setQueueDao(new QueueDao(em));
    }

    public void add(Queue queue) throws NotExistException {
        queueDao.add(queue);
    }

    public Queue get(long id) throws NotExistException {
        return queueDao.get(id);
    }

    public void update(Queue queue) throws NotExistException {
        queueDao.update(queue);
    }

    public void remove(Queue queue) throws NotExistException {
        queueDao.remove(queue);
    }
}
