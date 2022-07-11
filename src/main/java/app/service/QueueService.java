package app.service;

import app.model.Queue;
import app.repository.QueueRepo;
import java.util.List;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QueueService {

  @Setter private QueueRepo queueRepo;

  /** Custom constructor with spring injected repository. */
  public QueueService(QueueRepo queueRepo) {
    this.queueRepo = queueRepo;
  }

  public Queue getQueue(long id) {
    // findBy() vs getBy()
    return queueRepo.findById(id).get();
  }

  public List<Queue> getAllQueues() {
    return queueRepo.findAll();
  }

  public Queue postQueue(Queue queue) {
    return queueRepo.save(queue);
  }

  public Queue updateQueue(Queue queue) {
    Queue queueEntity = queueRepo.findById(queue.getId()).get();
    queueEntity = queue;
    queueRepo.save(queueEntity);
    return queueEntity;
  }

  public void deleteQueue(long queueId) {
    queueRepo.deleteById(queueId);
  }
}
