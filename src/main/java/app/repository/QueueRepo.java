package app.repository;

import app.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueRepo extends JpaRepository<Queue, Long> {

    Queue findQueueByBarberId(long barberId);

    List<Queue> findAllByStatusEquals(String status);
}
