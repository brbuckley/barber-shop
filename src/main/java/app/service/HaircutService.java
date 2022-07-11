package app.service;

import app.model.Haircut;
import app.repository.HaircutRepo;
import java.util.List;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HaircutService {

  @Setter private HaircutRepo haircutRepo;

  /** Custom constructor with spring injected repository. */
  public HaircutService(HaircutRepo haircutRepo) {
    this.haircutRepo = haircutRepo;
  }

  public Haircut getHaircut(long id) {
    // findBy() vs getBy()
    return haircutRepo.findById(id).get();
  }

  public List<Haircut> getAllHaircuts() {
    return haircutRepo.findAll();
  }

  public Haircut postHaircut(Haircut haircut) {
    return haircutRepo.save(haircut);
  }

  public Haircut updateHaircut(Haircut haircut) {
    Haircut haircutEntity = haircutRepo.findById(haircut.getId()).get();
    haircutEntity = haircut;
    haircutRepo.save(haircutEntity);
    return haircutEntity;
  }

  public void deleteHaircut(long haircutId) {
    haircutRepo.deleteById(haircutId);
  }
}
