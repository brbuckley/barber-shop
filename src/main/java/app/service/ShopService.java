package app.service;

import app.model.Shop;
import app.repository.ShopRepo;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

  @Setter private ShopRepo repository;

  /** Custom constructor with spring injected repository. */
  public ShopService(ShopRepo repository) {
    this.repository = repository;
  }

  public Shop getShop(long id) {
    return repository.findById(id).get();
  }
}
