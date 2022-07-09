package app.repository;

import app.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepo extends JpaRepository<Barber, Long> {

    Barber getBarberByEmailAndPasswordHash(String email, String passwordHash);

}
