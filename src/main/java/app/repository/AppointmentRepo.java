package app.repository;

import app.model.Appointment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** Spring JPA repository for Album entity. */
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

  @Query("SELECT a FROM Appointment a WHERE a.status = 0 AND a.queue.id = ?1")
  public List<Appointment> filterWaiting(long queueId);
}
