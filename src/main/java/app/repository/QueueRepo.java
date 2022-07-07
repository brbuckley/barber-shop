package app.repository;

import app.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepo extends JpaRepository<Queue, Long> {}
