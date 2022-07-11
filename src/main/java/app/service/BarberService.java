package app.service;

import app.model.Barber;
import app.repository.BarberRepo;
import java.util.List;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BarberService {

  @Setter private BarberRepo barberRepo;

  /** Custom constructor with spring injected repository. */
  public BarberService(BarberRepo barberRepo) {
    this.barberRepo = barberRepo;
  }

  public Barber getBarber(long id) {
    // findBy() vs getBy()
    return barberRepo.findById(id).get();
  }

  public List<Barber> getAllBarbers() {
    return barberRepo.findAll();
  }

  public Barber postBarber(Barber barber) {
    return barberRepo.save(barber);
  }

  public Barber updateBarber(Barber barber) {
    Barber barberEntity = barberRepo.findById(barber.getId()).get();
    barberEntity = barber;
    barberRepo.save(barberEntity);
    return barberEntity;
  }

  public void deleteBarber(long barberId) {
    barberRepo.deleteById(barberId);
  }
}
