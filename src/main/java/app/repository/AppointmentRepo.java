package app.repository;

import app.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Spring JPA repository for Album entity. */
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {}
